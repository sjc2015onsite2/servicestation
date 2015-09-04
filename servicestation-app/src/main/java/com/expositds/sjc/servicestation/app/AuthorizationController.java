package com.expositds.sjc.servicestation.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* <b>AuthorizationController</b>
* 
* 
* @author Sergey Rybakov
* */

@Controller
public class AuthorizationController {
 
	@RequestMapping(value = "/authorization", method = RequestMethod.GET)
	public String registration() {
		
		return "Authorization";
	}
	
	@RequestMapping(value = "/login/failure", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "dsjkfhdskjfhdskjfhjds");
		return "Authorization";

	}
}
