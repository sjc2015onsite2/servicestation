package com.expositds.sjc.servicestation.app;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;
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
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CustomerOrdersController</b>
 * 
 * Контроллер отвечает за отображение списка сделанных клиентом заявок
 * 
 * @author Sergey Rybakov
 * */


@Controller
@RequestMapping("/user")
public class CustomerOrdersController {

	@Autowired
	private AuthorizedUserSite authorizedUserSiteService;
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private DtosBuilder dtosBuilder;
	
		@RequestMapping(value = "/myorders", method = RequestMethod.GET)
		public ModelAndView myorders(
				@RequestParam(value = "page", required = false) Long page,
				Authentication auth) {
			
			if(page==null) page = 1L;
			Long pageSize = 3L;
			Long startPage = page;
			Long endPage = page + 5;
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
			
			Map<Order, Station> orders = new TreeMap<>();
			orders.putAll(authorizedUserSiteService.getOrdersLimit(user, (page-1L)*pageSize, 3L));
			String[][] allOrders = new String[orders.size()][8];
			int i = 0;
			for(Order currentOrder : orders.keySet()){
				CustomerOrderDto customerOrderDto = dtosBuilder.build(currentOrder);
				allOrders[i][0] = customerOrderDto.getProblemDescription();
				allOrders[i][1] = customerOrderDto.getOrderStatus();
				allOrders[i][2] = customerOrderDto.getStationName();
				allOrders[i][3] = customerOrderDto.getMechanicName();
				Integer cost = new Integer(0);
				for(int j = 0; j < customerOrderDto.getServiceNames().size(); j++){
					cost+=customerOrderDto.getServiceSums().get(j);
				}
				allOrders[i][4] = cost.toString();
				allOrders[i][5] = customerOrderDto.getCreatedDate();
				allOrders[i][6] = customerOrderDto.getNotificationMessage();
				allOrders[i][7] = customerOrderDto.getOrderId().toString();
				i++;
			}
			
			int ordersCount = authorizedUserSiteService.getSiteUserOrdersCount(user);
			Long lastPage = ordersCount / pageSize;
			if(ordersCount % pageSize != 0)
				lastPage++;
			
			if(endPage >= lastPage) endPage = lastPage;
			if(endPage >= 5 && (endPage - startPage) < 5) startPage = endPage -5;
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("allOrders", allOrders);
			mav.addObject("page", page);
			mav.addObject("startpage", startPage);
			mav.addObject("endpage", endPage);
			mav.setViewName("myOrders");
			return mav;
		}
		
		@RequestMapping(value = "/myorders/{orderId}", method = RequestMethod.GET)
		public ModelAndView myorder(@PathVariable("orderId") Order order) {
			
			Calendar now = new GregorianCalendar();
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			
			boolean change = false;
			if(order.getCompleteDate() != null){
				if(order.getCompleteDate().compareTo(nowDate) < 0){
					change = true;
				}
			}
			
			StationsDto stationsDto = dtosBuilder.build();
			CustomerOrderDto customerOrderDto = dtosBuilder.build(order);
			
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
			ModelAndView mav = new ModelAndView();
			mav.addObject("parts", parts);
			mav.addObject("services", services);
			mav.addObject("customerOrderDto", customerOrderDto);
			mav.addObject("stationsDto", stationsDto);
			mav.addObject("change", change);
			mav.setViewName("customer.order.data");
			
			return mav;
		}
		
		@RequestMapping(value = "/myorders/changestation", method = RequestMethod.POST)
		public ModelAndView changeServiceStation(
				@RequestParam(value = "orderId") Order order,
				@RequestParam(value = "stationId") Station station,
				Authentication auth){
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
				
			   authorizedUserSiteService.changeServiceStation(user, order, station);
			   
			   ModelAndView mav = new ModelAndView();
			   Long id = order.getOrderId();
			   mav.setViewName("redirect:/user/myorders/"+id);
			
			return mav;
		}
}