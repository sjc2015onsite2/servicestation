package com.expositds.sjc.servicestation.app;

import java.util.HashSet;
import java.util.Set;

import javax.management.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.business.service.dto.NotificationDto;
import com.expositds.sjc.servicestation.domain.model.ClientNotification;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* 
* @author Sergey Rybakov
* */


@Controller
public class NotificationsLogController {
	
	@Autowired
	private Mechanic mechanicService;
	
	@Autowired
	private Identification identificationService;
	
	@RequestMapping(value = "/mechanic/notificationslog", method = RequestMethod.GET)
	public ModelAndView showNotificationsLog(Authentication auth) {
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		Set <Order> orders =  new HashSet<>();
		orders = mechanicService.getMechanicOrders(mechanic);
		
		Set<NotificationDto> notificationsDto = new HashSet<>();
		for(Order currentorder : orders){
			if(currentorder.getNotification() != null)
				notificationsDto.add(new NotificationDto(currentorder));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("notificationsDto", notificationsDto);
		mav.setViewName("notifications.log");
		
	return mav; 
	}
	
}