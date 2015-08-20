
package com.expositds.sjc.servicestation.app;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CustomerOrdersController</b>
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class CustomerOrdersController {

	@Autowired
	private AuthorizedUserSite authorizedUserSiteService;
	
	@Autowired
	private Identification identificationService;
	
	
		@RequestMapping(value = "/user/myorders", method = { RequestMethod.GET })
		public ModelAndView myorders(Authentication auth) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
			
			Map<Order, Station> orders = authorizedUserSiteService.getOrders(user);			
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("orders", orders);
			mav.setViewName("myOrders");
			return mav;
		}
	
		@RequestMapping(value = "/user/myorders/{orderId}", method = RequestMethod.GET)
		public ModelAndView myorder(
				
				@PathVariable("orderId") Order order) {
			
			Set<Station> stations = authorizedUserSiteService.getServiceStations();
			
			Station station = identificationService.gerStationByOrder(order);
			//Person mechanic = identificationService.
			ModelAndView mav = new ModelAndView();
			mav.addObject("station", station);
			mav.addObject("order", order);
			mav.addObject("stations", stations);
			mav.setViewName("customer.order.data");
			
			return mav;
		}
		
		@RequestMapping(value = "/user/myorders", method = RequestMethod.POST)
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
