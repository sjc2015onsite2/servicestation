package com.expositds.sjc.servicestation.app;

import java.util.Map;
import java.util.Set;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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





@Controller
@RequestMapping(value = "")
public class CreateOrderController {

	@Autowired
	private AuthorizedUserSite authorizedUserSite;
	
	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;
	
	@Autowired
	private Identification identificationService;
	
	@RequestMapping(value = {"/createorder", "/"}, method = { RequestMethod.GET })
	public ModelAndView createOrder() {
		
		Set<Station> stations = authorizedUserSite.getServiceStations();
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.setViewName("createOrder");
		return mav;
	}
	
	@RequestMapping(value = "/createorder", method = RequestMethod.POST)
	public String createOrder(
			@RequestParam(value = "stationId", required = true) Station station,
			@RequestParam(required = true) String problem,
			Authentication auth,
			@RequestParam(required = true) String contacts){
		nonAuthorizedUserSite.createOrder(contacts, problem, station);
		
		return "redirect:/createorder";
	}
	
	@RequestMapping(value = "/createorder/user", method = RequestMethod.POST)
	public ModelAndView createOrder(
			@RequestParam(value = "stationId", required = true) Station station,
			@RequestParam(required = true) String problem,
			Authentication auth){
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());

		authorizedUserSite.createOrder(user, problem, station);
		Map<Order, Station> orders = authorizedUserSite.getOrders(user);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("orders", orders);
		mav.setViewName("myOrders");
		return mav;
	}
	
	
	
	
}
