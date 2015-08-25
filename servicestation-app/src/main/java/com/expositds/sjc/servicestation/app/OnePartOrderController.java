package com.expositds.sjc.servicestation.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Affilate; 
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* <b>SparePartListController</b>
* 
* @author Sergey Rybakov
* */

@Controller
public class OnePartOrderController {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/mechanic/partsorders/{partorderId}", method = RequestMethod.GET)
	public ModelAndView showListOfSpareParts(Authentication auth) {
		
		
		
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("one.part.order");
	return mav;
	}
}