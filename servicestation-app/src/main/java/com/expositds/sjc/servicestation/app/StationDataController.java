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

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Accountant;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CustomerOrdersController</b>
 * 
 * @author Sergey Rybakov
 * */


@Controller
@RequestMapping("/accountant")
public class StationDataController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = "/station", method = RequestMethod.GET)
		public ModelAndView showStationData() {
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("station");
			return mav;
		}
		
		@RequestMapping(value = "/station", method = RequestMethod.POST)
		public ModelAndView selectDate(
				Authentication auth,
				@RequestParam String startdate,
				@RequestParam String finishdate) throws ParseException {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person accountant = identificationService.getPersonById(logginer.getId().toString());
			
			Station station = identificationService.getStationByPerson(accountant);
			
			Calendar sDate = Calendar.getInstance();
			Calendar fDate = Calendar.getInstance();
			SimpleDateFormat sdf = (SimpleDateFormat) new SimpleDateFormat("dd.MM.yyyy", Locale.US);
			sDate.setTime(sdf.parse(startdate));
			fDate.setTime(sdf.parse(finishdate));
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("profit", accountantService.getServiceStationProfit(station, sDate, fDate));
			mav.addObject("expenses", accountantService.getServiceStationCharges(station, sDate, fDate));
			mav.setViewName("station");
			return mav;
		}
}