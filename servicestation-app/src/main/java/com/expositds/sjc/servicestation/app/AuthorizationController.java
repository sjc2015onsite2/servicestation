package com.expositds.sjc.servicestation.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
* <b>AuthorizationController</b>
* 
* 
* @author Sergey Rybakov
* */

@Controller
public class AuthorizationController {
 
	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSiteImpl;
	
	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public String registration() {
		
		return "Authorization";
	}
}
