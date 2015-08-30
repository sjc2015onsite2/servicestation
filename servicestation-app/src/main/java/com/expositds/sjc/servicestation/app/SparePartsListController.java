package com.expositds.sjc.servicestation.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* <b>SparePartListController</b>
* 
* Контроллер отображает список всех деталей хранящихся на складе.
* 
* @author Sergey Rybakov
* */

@Controller
@RequestMapping(value = "mechanic")
public class SparePartsListController {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/spareparts", method = RequestMethod.GET)
	public ModelAndView showListOfSpareParts(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		
		Map<Part,Integer> parts = new HashMap<>();
		parts = mechanicService.getPartsQuantity(affilate);
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("parts", parts);
		mav.setViewName("spare.parts.list");
	return mav;
	}
	
	@RequestMapping(value = "/spareparts", method = RequestMethod.POST)
	public ModelAndView createPartOrder(
			Authentication auth,
			@RequestParam(value = "partId") Part part,
			@RequestParam(value = "quantity") Integer quantity) {

		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		Map<Part, Integer> order = new HashMap<>();
		order.put(part, quantity);
		
		mechanicService.createPartOrder(mechanic);
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mechanic/spareparts");
	return mav;
	}
	
	
}