package com.expositds.sjc.servicestation.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Accountant;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b></b>
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class AffilatesProfitDataController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = {"/accountant/affiliatesdata", "/ceo/affiliatesdata"}, method = RequestMethod.GET)
		public ModelAndView showAffilatesData(Authentication auth) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person person = identificationService.getPersonById(logginer.getId().toString());
			
			Station station = identificationService.getStationByPerson(person);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("affiliates", accountantService.getServiceStationAffilate(station));
			mav.setViewName("affiliates.data");
			return mav;
		}
		
		@RequestMapping(value = {"/accountant/affiliatesdata", "/ceo/affiliatesdata"}, method = RequestMethod.POST)
		public ModelAndView selectAffilatesDate(
				Authentication auth,
				@RequestParam(value="affilateId") Affilate affilate,
				@RequestParam String startdate,
				@RequestParam String finishdate) throws ParseException {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person person = identificationService.getPersonById(logginer.getId().toString());
			
			Station station = identificationService.getStationByPerson(person);
			
			Calendar sDate = Calendar.getInstance();
			Calendar fDate = Calendar.getInstance();
			SimpleDateFormat sdf = (SimpleDateFormat) new SimpleDateFormat("dd.MM.yyyy", Locale.US);
			sDate.setTime(sdf.parse(startdate));
			fDate.setTime(sdf.parse(finishdate));
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("affiliates", accountantService.getServiceStationAffilate(station));
			mav.addObject("profit", accountantService.getAffilateProfit(affilate, sDate, fDate));
			mav.addObject("expenses", accountantService.getAffilateRent(affilate, sDate, fDate));
			mav.setViewName("affiliates.data");
			return mav;
		}
}