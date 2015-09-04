package com.expositds.sjc.servicestation.app;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.business.repository.dto.PartOrderDto;
import com.expositds.sjc.servicestation.business.service.DtosBuilder;
import com.expositds.sjc.servicestation.domain.model.Affilate; 
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* <b>OrderOfPartsController</b>
* 
* Контроллер отображает список заявок на детали сделанных всеми механиками станции
* 
* @author Sergey Rybakov
* */

@Controller
@RequestMapping(value = "/mechanic")
public class OrdersOfPartsControler {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private Mechanic mechanicService;
	
	@Autowired
	private DtosBuilder dtosBuilder;
	
	@RequestMapping(value = "/partsorders", method = RequestMethod.GET)
	public ModelAndView showListOfPartsOrders(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		
		Set<PartOrderDto> partOrdersDto = new TreeSet<>();
		partOrdersDto.addAll(dtosBuilder.build(mechanic));
		
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("partOrdersDto", partOrdersDto);
		mav.addObject("partOrderStatuses", PartOrderStatus.values());
		mav.setViewName("parts.orders.list");
	return mav;
	}
	
	@RequestMapping(value = "/partsorders", method = RequestMethod.POST)
	public ModelAndView changeStatusOfPartsOrder(
			@RequestParam(value = "orderId") PartOrder partOrder) {
		PartOrderStatus partOrderStatus = PartOrderStatus.READY;
		mechanicService.setPartOrderStatus(partOrder, partOrderStatus);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mechanic/partsorders");
	return mav;
	}
}