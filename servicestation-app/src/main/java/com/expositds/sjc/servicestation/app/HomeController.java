/*package com.expositds.sjc.servicestation.app;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

//import sjc.example.domain.model.UserPrincipal;
//import sjc.example.domain.service.UserService;





@Controller
@RequestMapping(value = "")
public class HomeController {

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
	
	
	
	
}*/
