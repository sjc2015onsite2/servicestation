package com.expositds.sjc.servicestation.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;
import com.expositds.sjc.servicestation.domain.service.WorkShop;


/**
* <b>MechanicOrdersController</b>
* 
* @author Sergey Rybakov
* 
* */

@Controller
@RequestMapping("/mechanic")
public class MechanicOrdersController {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private AuthorizedUserSite authorizedUserSiteService;
	
	@Autowired
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/myorders", method = RequestMethod.GET)
	public ModelAndView showOrdersOfMechanic(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		Set<Order> myorders = mechanicService.getMechanicOrders(mechanic);
		
		Map<Order,String> ordersanddate = new HashMap<>();
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
		
		String completedate = new String();
		String createdate = new String();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		if(order.getCompleteDate() != null)
			completedate = dateFormat.format(order.getCompleteDate().getTime());
		createdate = dateFormat.format(order.getCreateDate().getTime());
		
		Person mechanic = identificationService.getMechanicByOrder(order);
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		
		ArrayList<Service> addedworks = new ArrayList<>();
		//addedworks = order.getServices();
		
		//Integer cost = new Integer(0);
		
		/*String[][] serviceRows = new String[4][order.getServices().size()];
		int i = 0;
		for (Service currentService : order.getServices()) {
			serviceRows[0][i] = currentService.getName();
			serviceRows[1][i] = order.getServices().get(currentService);
			serviceRows[2][i] = order.getOrderServicesPriceList().get(currentService).toString();
			serviceRows[3][i] = Integer.toString((Integer.parseInt(serviceRows[1][i]) * Integer.parseInt(serviceRows[2][i])));
			cost += Integer.parseInt(serviceRows[3][i]);
			i++;
		}*/
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("statuses", OrderStatus.values());
		mav.addObject("stations", authorizedUserSiteService.getServiceStations());
		mav.addObject("completedate", completedate);
		mav.addObject("createdate", createdate);
		mav.addObject("order", order);
		mav.addObject("addedworks", addedworks);
		mav.addObject("partstoorder", order.getParts());
		mav.addObject("parts", mechanicService.getPartsQuantity(affilate));
		mav.addObject("works", mechanicService.getServicesCost(affilate));
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
			@RequestParam(value = "orderId") Order order) {	
		
		Map <Part, Integer> partandquantity = new HashMap<>();
		partandquantity.put(part, quantity);
		mechanicService.addPartsToOrder(order, partandquantity);
		
		ModelAndView mav = new ModelAndView();
		Long id = order.getOrderId();
		mav.setViewName("redirect:/mechanic/myorders/"+id);
	return mav;
	}
	
	@RequestMapping(value = "/freeorders", method = RequestMethod.GET)
	public ModelAndView showFreeOrders(Authentication auth){
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		Set<Order> freeorders = mechanicService.getMechanicFreeOrders(mechanic);
		
		Map<Order, String> orders = new HashMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Order currentorder : freeorders){
			orders.put(currentorder, dateFormat.format(currentorder.getCreateDate().getTime()));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("orders", orders);
		mav.setViewName("free.orders");
	return mav;
	}
	
	
}