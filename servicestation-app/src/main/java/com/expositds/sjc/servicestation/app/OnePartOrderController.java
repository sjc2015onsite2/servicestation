package com.expositds.sjc.servicestation.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* <b>OnePartOrderController</b>
* 
* Контроллер отвечает за создание новой заявки на детали
* 
* @author Sergey Rybakov
* */

@Controller
@RequestMapping(value = "/mechanic")
public class OnePartOrderController {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/partorder/{partOrderId}", method = RequestMethod.GET)
	public ModelAndView partOrder(Authentication auth,
			@PathVariable(value = "partOrderId") PartOrder partOrder) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("parts", mechanicService.getPartsQuantity(identificationService.getAffilateByMechanic(mechanic)));
		mav.addObject("partsoforder", partOrder.getParts());
		mav.addObject("partorder", partOrder);
		mav.setViewName("one.part.order");
	return mav;
	}
	
	@RequestMapping(value = "/partorder", method = RequestMethod.POST)
	public ModelAndView addParts(Authentication auth,
			@RequestParam(value = "partOrderId") PartOrder partOrder,
			@RequestParam(value = "partId") Part part,
			@RequestParam(value = "quantity") Integer quantity) {
		
		Map <Part, Integer> partandquantity = new HashMap<>();
		partandquantity.put(part, quantity);
		mechanicService.addPartsToPartOrder(partOrder, partandquantity);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mechanic/partorder/" + partOrder.getPartOrderId());
	return mav;
	}
	
	@RequestMapping(value = "/newpartorder", method = RequestMethod.POST)
	public ModelAndView newPartOrder(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		PartOrder partOrder = mechanicService.createPartOrder(mechanic);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mechanic/partorder/" + partOrder.getPartOrderId());
	return mav;
	}
}