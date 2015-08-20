package com.expositds.sjc.servicestation.app;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.expositds.sjc.servicestation.domain.model.LogginerRole;

/**
 * @author Alexey Suslov
 *
 */
@Controller
@RequestMapping(value = "/redirect")
public class RedirectController {
	
	@RequestMapping(value = "")
	public String redirect(Authentication auth) {
		
		Collection<? extends GrantedAuthority> authRole = auth.getAuthorities();
		String userRole = "ROLE_" + LogginerRole.USER.toString();
		
		if (authRole.contains(userRole)) return "redirect:/user/myorders";
		else if (auth.getAuthorities().contains("ROLE" + LogginerRole.MECHANIC.toString())) return "redirect:/mechanic/myorders";
		return "redirect:/user/myordersyyy";
	}
	
}
