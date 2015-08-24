package com.expositds.sjc.servicestation.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.model.Affilate; // FIXME: Incorrect spelling (Affiliate)
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* <b>SparePartListController</b>
* 
* @author Sergey Rybakov
* */

@Controller
public class OrdersOfPartsControler {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/mechanic/partsorders", method = RequestMethod.GET)
	public ModelAndView showListOfSpareParts(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		Affilate affiliate = identificationService.getAffilateByMechanic(mechanic);
		Set<PartOrder> partsorders = new HashSet<>();
		
		
		partsorders = mechanicService.getPartOrders(affiliate);
		
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("partsorders", mechanicService.getPartOrders(affiliate));
		mav.setViewName("parts.orders.list");
	return mav;
	}
	
	
}