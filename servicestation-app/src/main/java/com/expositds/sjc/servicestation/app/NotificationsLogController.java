package com.expositds.sjc.servicestation.app;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.service.dto.NotificationDto;
import com.expositds.sjc.servicestation.business.service.dto.builders.CustomerOrderDtoBuilder;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Ceo;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;


/**
* <b>NotificationsLogController</b>
* 
* Контроллер отвечает за отбражение списка всех уведомлений сделанных конкретным механиком
* и уведомлений сделанных всеми механиками станции
* 
* @author Sergey Rybakov
* */


@Controller
public class NotificationsLogController {
	
	@Autowired
	private Mechanic mechanicService;
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private Ceo ceoService;
	
	@Autowired
	private CustomerOrderDtoBuilder customerOrderDtoBuilder;
	
	@RequestMapping(value = "/mechanic/notificationslog", method = RequestMethod.GET)
	public ModelAndView showNotificationsLog(Authentication auth) {
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		Set <Order> orders =  new HashSet<>();
		orders = mechanicService.getMechanicOrders(mechanic);
		
		Set<NotificationDto> notificationsDto = new HashSet<>();
		for(Order currentorder : orders){
			if(currentorder.getNotification() != null)
				notificationsDto.add(new NotificationDto(customerOrderDtoBuilder.build(currentorder)));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("notificationsDto", notificationsDto);
		mav.setViewName("notifications.log");
		
	return mav; 
	}
	
	@RequestMapping(value = "/ceo/notificationslog", method = RequestMethod.GET)
	public ModelAndView showCeoNotificationsLog(Authentication auth) {
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person ceo = identificationService.getPersonById(logginer.getId().toString());
		
		Station station = identificationService.getStationByPerson(ceo);
		
		Calendar now = new GregorianCalendar();
		Calendar startDate = new GregorianCalendar(2000, 1, 1);
		Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
		
		Set <Order> orders =  new HashSet<>();
		orders.addAll(ceoService.getServiceStationOrders(station, startDate, nowDate));
		
		Set<NotificationDto> notificationsDto = new HashSet<>();
		for(Order currentorder : orders){
			if(currentorder.getNotification() != null)
				notificationsDto.add(new NotificationDto(customerOrderDtoBuilder.build(currentorder)));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("notificationsDto", notificationsDto);
		mav.setViewName("ceo.notifications.log");
		
	return mav; 
	}
}