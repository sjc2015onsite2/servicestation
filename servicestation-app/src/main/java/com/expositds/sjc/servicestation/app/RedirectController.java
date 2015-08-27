package com.expositds.sjc.servicestation.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.LogginerRole;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Controller
@RequestMapping(value = "/redirect")
public class RedirectController {
	
	@Autowired
	private Identification identification;
	
	@RequestMapping(value = "")
	public String redirect(Authentication auth) {
		
		Logginer logginer = identification.getLogginerByName(auth.getName());
		
		if (logginer.getRole().equals(LogginerRole.USER)) return "redirect:/user/myorders";
		else if (logginer.getRole().equals(LogginerRole.MECHANIC)) return "redirect:/mechanic/myorders";
		else if (logginer.getRole().equals(LogginerRole.ACCOUNTANT)) return "redirect:/accountant/station";
		else if (logginer.getRole().equals(LogginerRole.CEO)) return "redirect:/ceo/station";
		return "redirect:/user/myordersyyy";
	}
	
}
