package com.expositds.sjc.servicestation.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
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
 * <b>StationDataController</b>
 * 
 * Контроллер отвечает за отображение информации о прибыли и расходах станции
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class StationDataController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = {"/accountant/station", "/ceo/station"}, method = RequestMethod.GET)
		public ModelAndView showStationData(Authentication auth) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person person = identificationService.getPersonById(logginer.getId().toString());
			
			Station station = identificationService.getStationByPerson(person);
			
			Calendar now = new GregorianCalendar();
			Calendar firstDayOfLastMonth = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
			firstDayOfLastMonth.add(Calendar.MONTH, -1);
			Calendar lastDayOfLastMonth = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
			lastDayOfLastMonth.add(Calendar.DAY_OF_MONTH, -1);
			Calendar firstDayOfCurrentMonth = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("lustMonthProfit", accountantService.getServiceStationProfit(station, firstDayOfLastMonth, lastDayOfLastMonth));
			mav.addObject("lustMonthExpenses", accountantService.getServiceStationCharges(station, firstDayOfLastMonth, lastDayOfLastMonth));
			mav.addObject("currentMonthProfit", accountantService.getServiceStationProfit(station, firstDayOfCurrentMonth, nowDate));
			mav.addObject("currentMonthExpenses", accountantService.getServiceStationCharges(station, firstDayOfCurrentMonth, nowDate));
			mav.setViewName("station");
			return mav;
		}
		
		@RequestMapping(value = {"/accountant/stationdata", "/ceo/stationdata"}, method = RequestMethod.POST)
		public ModelAndView selectDate(
				Authentication auth,
				@RequestParam String startdate,
				@RequestParam String finishdate) throws ParseException {
			
			Calendar now = new GregorianCalendar();
			Calendar firstDayOfCurrentMonth = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person person = identificationService.getPersonById(logginer.getId().toString());
			
			Station station = identificationService.getStationByPerson(person);
			
			Calendar sDate = Calendar.getInstance();
			Calendar fDate = Calendar.getInstance();
			SimpleDateFormat sdf = (SimpleDateFormat) new SimpleDateFormat("dd.MM.yyyy", Locale.US);
			sDate.setTime(sdf.parse(startdate));
			fDate.setTime(sdf.parse(finishdate));
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("profit", accountantService.getServiceStationProfit(station, sDate, fDate));
			mav.addObject("expenses", accountantService.getServiceStationCharges(station, sDate, fDate));
			mav.addObject("currentMonthProfit", accountantService.getServiceStationProfit(station, firstDayOfCurrentMonth, nowDate));
			mav.addObject("currentMonthExpenses", accountantService.getServiceStationCharges(station, firstDayOfCurrentMonth, nowDate));
			mav.setViewName("station");
			return mav;
		}
}