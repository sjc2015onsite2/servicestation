
package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

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
import com.expositds.sjc.servicestation.domain.model.Service;
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
@RequestMapping("/user")
public class CustomerOrdersController {

	@Autowired
	private AuthorizedUserSite authorizedUserSiteService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = "/myorders", method = RequestMethod.GET)
		public ModelAndView myorders(Authentication auth) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("orders", authorizedUserSiteService.getOrders(user));
			mav.setViewName("myOrders");
			return mav;
		}
	
		@RequestMapping(value = "/myorders/{orderId}", method = RequestMethod.GET)
		public ModelAndView myorder(
				@PathVariable("orderId") Order order) {
			
			String completedate = new String();
			String createdate = new String();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
			if(order.getCompleteDate() != null)
				completedate = dateFormat.format(order.getCompleteDate().getTime());
			createdate = dateFormat.format(order.getCreateDate().getTime());
			
			Integer cost = new Integer(0);
			
			String[][] serviceRows = new String[order.getServices().size()][4]; 
			int i = 0;
			for (Service currentService : order.getServices().keySet()) {
				serviceRows[i][0] = currentService.getName();
				serviceRows[i][1] = order.getServices().get(currentService).toString();
				serviceRows[i][2] = order.getOrderServicesPriceList().get(currentService).toString();
				serviceRows[i][3] = Integer.toString((Integer.parseInt(serviceRows[i][1]) * Integer.parseInt(serviceRows[i][2])));
				cost += Integer.parseInt(serviceRows[i][3]);
				i++;
			}
			
			boolean change = false;
			if(order.getCompleteDate() != null){
				if(order.getCompleteDate().compareTo(order.getCreateDate()) < 0){
					change = true;
				}
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("mechanic", identificationService.getMechanicByOrder(order));
			mav.addObject("station", identificationService.getStationByOrder(order));
			mav.addObject("stations", authorizedUserSiteService.getServiceStations());
			mav.addObject("partstoorder", order.getParts());
			mav.addObject("change", change); 
			mav.addObject("cost", cost); 
			mav.addObject("serviceRows", serviceRows); 
			mav.addObject("completedate", completedate);
			mav.addObject("createdate", createdate);
			mav.addObject("order", order);
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
