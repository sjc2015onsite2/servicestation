package com.expositds.sjc.servicestation.app;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.app.validator.RegistrationValidator;
import com.expositds.sjc.servicestation.domain.model.LogginerRole;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;


@Controller
public class RegistrationController {
 
	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSiteImpl;
	
	@RequestMapping(value = "/newcustomer", method = RequestMethod.POST)
	public String createOrder(
			@Valid @ModelAttribute SiteUser siteUser, 
			BindingResult result, Model model) {
		
		RegistrationValidator registrationValidator = new RegistrationValidator();
		registrationValidator.validate(siteUser, result);
		
		siteUser.setRole(LogginerRole.USER);
		
		String view = "createOrder";
		
		if (result.hasErrors()) {
			view = "base.error";
		} else {
			if (siteUser != null) {
				nonAuthorizedUserSiteImpl.saveSiteUser(siteUser);			
				model.addAttribute("stations", nonAuthorizedUserSiteImpl.getServiceStations());
			}
			model.asMap().remove("siteUser");
		}
		return view;
	}
}
