package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
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
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
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
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/myorders", method = RequestMethod.GET)
	public ModelAndView showOrdersOfMechanic(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonId(logginer.getId().toString());
		Set<Order> myorders = mechanicService.getMechanicOrders(mechanic);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("myorders", myorders);
		mav.setViewName("mechanic.orders");
	return mav;
	}
	
	@RequestMapping(value = "/myorders", method = RequestMethod.POST)
	public ModelAndView pickUp(@RequestParam Order order) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("order", order);
		mav.setViewName("change.order.data");
	return mav;
	}
	
	@RequestMapping(value = "/freeorders", method = RequestMethod.GET)
	public ModelAndView showFreeOrders(Authentication auth){
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonId(logginer.getId().toString());
		
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
	
	@RequestMapping(value = "/freeorders/{orderId}", method = RequestMethod.GET)
	public ModelAndView freeOrder(@PathVariable("orderId") Order order){
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("order", order);
		mav.setViewName("change.order.data");
		return mav;
	}
}