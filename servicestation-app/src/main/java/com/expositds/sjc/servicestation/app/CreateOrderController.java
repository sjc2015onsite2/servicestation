package com.expositds.sjc.servicestation.app;

import java.util.Map;
import java.util.Set;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;





@Controller
@RequestMapping(value = "")
public class CreateOrderController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;
	
	@RequestMapping(value = {"/createorder", "/"}, method = { RequestMethod.GET })
	public ModelAndView createOrder() {
		
		Set<Station> stations = nonAuthorizedUserSite.getServiceStations();
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.setViewName("createOrder");
		return mav;
	}
	
	@RequestMapping(value = {"/createorder", "/"}, method = RequestMethod.POST)
	public String createOrder(
			@RequestParam(value = "stationId", required = true) Station station,
			@RequestParam(required = true) String problem,
			@RequestParam(required = true) String contacts){
		
		nonAuthorizedUserSite.createOrder(contacts, problem, station);
		
		return "redirect:/createorder";
	}
	
	
	
	
}
