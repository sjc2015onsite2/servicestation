package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.app.dto.PartOrderDto;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;
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
public class OrdersOfPartsControler {
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private Mechanic mechanicService;
	
	@RequestMapping(value = "/mechanic/partsorders", method = RequestMethod.GET)
	public ModelAndView showListOfPartsOrders(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		Affilate affiliate = identificationService.getAffilateByMechanic(mechanic);
		
		Set<PartOrder> partsorders = new HashSet<>();
		partsorders = mechanicService.getPartOrders(affiliate);
		
		Set<PartOrderDto> partOrdersDto = new TreeSet<>();
		
		for (PartOrder currentorder : partsorders){
			partOrdersDto.add(new PartOrderDto(currentorder));
		}
	
		ModelAndView mav = new ModelAndView();
		mav.addObject("partOrdersDto", partOrdersDto);
		mav.addObject("partOrderStatuses", PartOrderStatus.values());
		mav.setViewName("parts.orders.list");
	return mav;
	}
	
	@RequestMapping(value = "/mechanic/partsorders", method = RequestMethod.POST)
	public ModelAndView changeStatusOfPartsOrder(
			@RequestParam(value = "orderId") PartOrder partOrder) {
		PartOrderStatus partOrderStatus = PartOrderStatus.READY;
		mechanicService.setPartOrderStatus(partOrder, partOrderStatus);
		
	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/mechanic/partsorders");
	return mav;
	}
}