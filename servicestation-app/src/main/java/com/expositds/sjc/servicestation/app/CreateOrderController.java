package com.expositds.sjc.servicestation.app;

import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
 * <b>CreateOrderController</b>
 * 
 * Koнтроллер отвечает за создание заявки на ремонт авторизованным и не авторизованным пользователем
 * 
 * @author Sergey Rybakov
 * */

@Controller
@RequestMapping(value = "")
public class CreateOrderController {

	@Autowired
	private AuthorizedUserSite authorizedUserSite;
	
	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;
	
	@Autowired
	private Identification identificationService;
	
	@RequestMapping(value = {"/createorder", "/", "/user/createorder"}, method = RequestMethod.GET)
	public String createOrder(Model model) {
		
		Order defoultOrder = new Order();
		defoultOrder.setProblemDescription("Problem");
		defoultOrder.setContactData("(99)999 99 99");
		
		Set<Station> stations = authorizedUserSite.getServiceStations();
		
		model.addAttribute("stations",  stations);
		model.addAttribute("order", defoultOrder);
		
		return "createOrder";
	}
	
	@RequestMapping(value = "/createorder", method = RequestMethod.POST)
	public String createOrder(
			@RequestParam(value = "stationId", required = true) Station station,
			Authentication auth,
			@Valid @ModelAttribute Order order,
			BindingResult result,
			Model model){
		
		Set<Station> stations = authorizedUserSite.getServiceStations();
		model.addAttribute("stations",  stations);
		
		if (result.hasErrors()) 
			return "createOrder";
		
		nonAuthorizedUserSite.createOrder(order.getContactData(), order.getProblemDescription(), station);
		return "orderCreated";
	}
	
	@RequestMapping(value = "/user/createorder", method = RequestMethod.POST)
	public ModelAndView createOrder(
			@RequestParam(value = "stationId") Station station,
			@Valid @ModelAttribute Order order,
			BindingResult result,
			Authentication auth,
			Model model){		
		
		Set<Station> stations = authorizedUserSite.getServiceStations();
		model.addAttribute("stations",  stations);
		
		ModelAndView mav = new ModelAndView();
		if (result.hasFieldErrors("problemDescription")) {
			mav.setViewName("createOrder");
			return mav;
		}
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
		
		authorizedUserSite.createOrder(user, order.getProblemDescription(), station);
		Map<Order, Station> orders = authorizedUserSite.getOrders(user);
		
		mav.addObject("orders", orders);
		mav.setViewName("redirect:/user/myorders");
		return mav;
	}
}
