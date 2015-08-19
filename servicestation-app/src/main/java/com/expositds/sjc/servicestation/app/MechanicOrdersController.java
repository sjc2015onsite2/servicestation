package com.expositds.sjc.servicestation.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expositds.sjc.servicestation.domain.model.Station;


/**
* <b>MechanicOrdersController</b>
* 
* @author Sergey Rybakov
* 
* */

@Controller
@RequestMapping("/mechanic")
public class MechanicOrdersController {
	
	@RequestMapping(value = "/myorders", method = RequestMethod.GET)
	public String showOrdersOfMechanic() {
		
	return "mechanic.orders";
	}
	
	@RequestMapping(value = "/freeorders", method = RequestMethod.GET)
	public String showFreeOrders(){
		
	return "free.orders";
	}
}