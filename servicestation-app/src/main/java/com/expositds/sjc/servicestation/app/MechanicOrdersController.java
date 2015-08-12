package com.expositds.sjc.servicestation.app;

//import java.util.Map;
//import java.util.Set;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;


/**
*
* 
* @author Sergey Rybakov
* */

@Controller
@RequestMapping("/stationId/mechanic")

public class MechanicOrdersController {
	
	@RequestMapping(value = "/myorders", method = { RequestMethod.GET })
	public String showOrdersOfMechanic() {
		
	return "mechanic.orders";
	}
	
	@RequestMapping(value = "/freeorders", method = { RequestMethod.GET})
	public String showFreeOrders(){
		
	return "free.orders";
	}
}