package com.expositds.sjc.servicestation.app;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.business.repository.dto.CeoNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.MechanicNotificationDto;
import com.expositds.sjc.servicestation.business.service.DtosBuilder;
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
	private Identification identificationService;
	
	@Autowired
	private Ceo ceoService;
	
	@Autowired
	private DtosBuilder dtosBuilder;
	
	@RequestMapping(value = "/mechanic/notificationslog", method = RequestMethod.GET)
	public ModelAndView showNotificationsLog(Authentication auth) {
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person mechanic = identificationService.getPersonById(logginer.getId().toString());
		
		
		
		Set<MechanicNotificationDto> notificationsDto = new TreeSet<>();
		notificationsDto.addAll(dtosBuilder.buildMechanicNotificationDto(mechanic));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("notificationsDto", notificationsDto);
		mav.setViewName("notifications.log");
		
	return mav; 
	}
	
	@RequestMapping(value = "/ceo/notificationslog", method = RequestMethod.GET)
	public ModelAndView showCeoNotificationsLog(Authentication auth) {
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person ceo = identificationService.getPersonById(logginer.getId().toString());
		
		
		
		List<CeoNotificationDto> notificationsDto = dtosBuilder.buildCeoNotificationDto(ceo);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("notificationsDto", notificationsDto);
		mav.setViewName("ceo.notifications.log");
		
	return mav; 
	}
}