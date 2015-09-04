package com.expositds.sjc.servicestation.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;
import com.expositds.sjc.servicestation.business.service.DtosBuilder;
import com.expositds.sjc.servicestation.domain.exception.PartLimitException;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* <b>MechanicOrdersController</b>
* 
* Контроллер отвечает за отображения списка свободных заявок, которые механик может взять себе;
* список заявок с которыми работает механик;
* отвечает за работу с конкретной заявкой заявкой.
* 
* @author Sergey Rybakov
* */

@Controller
@RequestMapping("/mechanic")
public class MechanicOrdersController {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private DtosBuilder customerOrderDtoBuilder;

	@Autowired
	private DtosBuilder dtosBuilder;
	
	@Autowired
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/freeorders", method = RequestMethod.GET)
	public ModelAndView showFreeOrders(Authentication auth){
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		Set<Order> freeorders = mechanicService.getMechanicFreeOrders(mechanic);
		
		Map<Order, String> orders = new TreeMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Order currentorder : freeorders){
			orders.put(currentorder, dateFormat.format(currentorder.getCreateDate().getTime()));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("orders", orders);
		mav.setViewName("free.orders");
	return mav;
	}
	
	@RequestMapping(value = "/myorders", method = RequestMethod.GET)
	public ModelAndView showOrdersOfMechanic(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		Set<Order> myorders = mechanicService.getMechanicOrders(mechanic);
		
		Map<Order,String> ordersanddate = new TreeMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
		
		for(Order currentorder : myorders){
			
			ordersanddate.put(currentorder, dateFormat.format(currentorder.getCreateDate().getTime()));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("ordersanddate", ordersanddate);
		mav.setViewName("mechanic.orders");
	return mav;
	}
	
	@RequestMapping(value = "/myorders/{orderId}", method = RequestMethod.GET)
	public ModelAndView freeOrder(@PathVariable("orderId") Order order){
		
		StationsDto stationsDto = dtosBuilder.build();
		CustomerOrderDto customerOrderDto = customerOrderDtoBuilder.build(order);
		
		Person mechanic = identificationService.getMechanicByOrder(order);
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		
		String[][] services = new String[customerOrderDto.getServiceNames().size()][3];
		for(int i = 0; i < customerOrderDto.getServiceNames().size(); i++){
			services[i][0] = customerOrderDto.getServiceNames().get(i);
			services[i][1] = customerOrderDto.getServiceCounts().get(i).toString();
			services[i][2] = customerOrderDto.getServiceSums().get(i).toString();
		}
		String[][] parts = new String[customerOrderDto.getPartNames().size()][2];
		for(int i = 0; i < customerOrderDto.getPartNames().size(); i++){
			parts[i][0] = customerOrderDto.getPartNames().get(i);
			parts[i][1] = customerOrderDto.getPartCounts().get(i).toString();
		}
		
		Map<Service, Integer> works = new HashMap<>();
		works.putAll(mechanicService.getServicesCost(affilate));
		String[][] allworks = new String[works.keySet().size()][2];
		int i = 0;
		for(Service currentWork : works.keySet()){
			allworks[i][0] = currentWork.getServiceId().toString();
			allworks[i][1] = currentWork.getName();
			i++; 
		}
		
		Map<Part, Integer> allpartsandquantity = new HashMap<>();
		allpartsandquantity.putAll(mechanicService.getPartsQuantity(affilate));
		String[][] allparts = new String[allpartsandquantity.keySet().size()][2];
		int j = 0;
		for(Part currentPart : allpartsandquantity.keySet()){
			allparts[j][0] = currentPart.getPartId().toString();
			allparts[j][1] = currentPart.getName();
			j++; 
		}
			
		ModelAndView mav = new ModelAndView();
		mav.addObject("statuses", OrderStatus.values());
		mav.addObject("services", services);
		mav.addObject("parts", parts);
		mav.addObject("customerOrderDto", customerOrderDto);
		mav.addObject("stationsDto", stationsDto);
		mav.addObject("contactData", order.getContactData());
		mav.addObject("allparts", allparts);
		mav.addObject("allworks", allworks);
		mav.setViewName("customer.order.data");
		return mav;
	}
	
	@RequestMapping(value = "/freeorders", method = RequestMethod.POST)
	public ModelAndView pickUp(
			@RequestParam(value = "orderId") Order order,
			Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		mechanicService.giveOrder(mechanic, order);
		ModelAndView mav = new ModelAndView();
		Long id = order.getOrderId();
		mav.setViewName("redirect:/mechanic/myorders/"+id);
	return mav;
	}
	
	@RequestMapping(value = "/myorders/changestatus", method = RequestMethod.POST)
	public ModelAndView cangeOrderData(
			@RequestParam(value = "orderId") Order order,
			@RequestParam OrderStatus newstatus) {
		mechanicService.setOrderStatus(order, newstatus);
		
		ModelAndView mav = new ModelAndView();
		Long id = order.getOrderId();
		mav.setViewName("redirect:/mechanic/myorders/"+id);
	return mav;
	}
	
	@RequestMapping(value = "/myorders/completedate", method = RequestMethod.POST)
	public ModelAndView compliteDate(
			@RequestParam(value = "orderId") Order order,
			@RequestParam String completedate) throws ParseException {	
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = (SimpleDateFormat) new SimpleDateFormat("dd.MM.yyyy", Locale.US);
		cal.setTime(sdf.parse(completedate));
		
		mechanicService.setOrderCompletionDate(order, cal);
		
		ModelAndView mav = new ModelAndView();
		Long id = order.getOrderId();
		mav.setViewName("redirect:/mechanic/myorders/"+id);
	return mav;
	}
	
	@RequestMapping(value = "/myorders/nitification", method = RequestMethod.POST)
	public ModelAndView createNotification(
			@RequestParam(value = "orderId") Order order,
			@RequestParam String notification) {	
		
		mechanicService.createClientNotification(order, notification);
		
		ModelAndView mav = new ModelAndView();
		Long id = order.getOrderId();
		mav.setViewName("redirect:/mechanic/myorders/"+id);
	return mav;
	}
	
	@RequestMapping(value = "/myorders/addworks", method = RequestMethod.POST)
	public ModelAndView addWorks(
			@RequestParam(value = "workId") Service service,
			@RequestParam(value = "orderId") Order order) {	
		
		Map <Service, Integer> services = new HashMap<>();
		services.put(service, 1);
		mechanicService.addServicesToOrder(order, services);
		
		ModelAndView mav = new ModelAndView();
		Long id = order.getOrderId();
		mav.setViewName("redirect:/mechanic/myorders/"+id);
	return mav;
	}
	
	@RequestMapping(value = "/myorders/addparts", method = RequestMethod.POST)
	public ModelAndView addParts(
			@RequestParam Integer quantity,
			@RequestParam(value = "partId") Part part,
			@RequestParam(value = "orderId") Order order) throws PartLimitException {	
		
		Map <Part, Integer> partandquantity = new HashMap<>();
		partandquantity.put(part, quantity);
		mechanicService.addPartsToOrder(order, partandquantity);
		
		ModelAndView mav = new ModelAndView();
		Long id = order.getOrderId();
		mav.setViewName("redirect:/mechanic/myorders/"+id);
	return mav;
	}
}