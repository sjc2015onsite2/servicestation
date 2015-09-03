package com.expositds.sjc.servicestation.app;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
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
 * Контроллер отвечает за отображение информации о прибыли и расходах на станции и на выбранном филиале
 * за текущий месяц и 12 предыдущих
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class DynamicController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = {"/accountant/dynamic", "/ceo/dynamic"}, method = RequestMethod.GET)
		public ModelAndView showAffilatesData(Authentication auth) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person person = identificationService.getPersonById(logginer.getId().toString());
			
			Station station = identificationService.getStationByPerson(person);
			
			
			Calendar now = new GregorianCalendar();
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			Calendar firstDayOfMonth = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
			
			firstDayOfMonth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
			
			String[][] stationData = new String[11][3];
			for(int i = 0, g = 1, j = 0 ; i <= 10; i++, g++, j++){
				Calendar firstDay = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
				firstDay.add(Calendar.MONTH, -g);
				Calendar lastDay = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
				lastDay.add(Calendar.MONTH, -j);
				lastDay.add(Calendar.DAY_OF_MONTH, -1);
				stationData[i][0] = firstDay.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US).toString();
				stationData[i][1] = accountantService.getServiceStationCharges(station, firstDay, lastDay).toString();
				stationData[i][2] = accountantService.getServiceStationProfit(station, firstDay, lastDay).toString();
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("stationData", stationData);
			mav.addObject("currentStationCharges", accountantService.getServiceStationCharges(station, firstDayOfMonth, nowDate));
			mav.addObject("currentStationProfit", accountantService.getServiceStationProfit(station, firstDayOfMonth, nowDate));
			mav.addObject("affiliates", accountantService.getServiceStationAffilate(station));
			mav.setViewName("dynamic");
			return mav;
		}
		
		@RequestMapping(value = {"/accountant/dynamic", "/ceo/dynamic"}, method = RequestMethod.POST)
		public ModelAndView selectAffilatesDate(
				Authentication auth,
				@RequestParam(value="affilateId") Affilate affilate) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person person = identificationService.getPersonById(logginer.getId().toString());
			
			Station station = identificationService.getStationByPerson(person);
			
			Calendar now = new GregorianCalendar();
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			Calendar firstDayOfMonth = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
			
			firstDayOfMonth.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
			
			String[][] stationData = new String[11][3];
			for(int i = 0, g = 1, j = 0 ; i <= 10; i++, g++, j++){
				Calendar firstDay = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
				firstDay.add(Calendar.MONTH, -g);
				Calendar lastDay = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
				lastDay.add(Calendar.MONTH, -j);
				lastDay.add(Calendar.DAY_OF_MONTH, -1);
				stationData[i][0] = firstDay.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US).toString();
				stationData[i][1] = accountantService.getServiceStationCharges(station, firstDay, lastDay).toString();
				stationData[i][2] = accountantService.getServiceStationProfit(station, firstDay, lastDay).toString();
			}
			
			String[][] affiliateData = new String[11][3];
			for(int i = 0, g = 1, j = 0 ; i <= 10; i++, g++, j++){
				Calendar firstDay = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
				firstDay.add(Calendar.MONTH, -g);
				Calendar lastDay = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);
				lastDay.add(Calendar.MONTH, -j);
				lastDay.add(Calendar.DAY_OF_MONTH, -1);
				affiliateData[i][0] = firstDay.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US).toString();
				affiliateData[i][1] = accountantService.getAffilateRent(affilate, firstDay, lastDay).toString();
				affiliateData[i][2] = accountantService.getAffilateProfit(affilate, firstDay, lastDay).toString();
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("affiliateName", affilate.getAffilateCode());
			mav.addObject("stationData", stationData);
			mav.addObject("affiliateData", affiliateData);
			mav.addObject("affiliates", accountantService.getServiceStationAffilate(station));
			mav.addObject("currentStationCharges", accountantService.getServiceStationCharges(station, firstDayOfMonth, nowDate));
			mav.addObject("currentStationProfit", accountantService.getServiceStationProfit(station, firstDayOfMonth, nowDate));
			mav.addObject("currentAffiliateCharges", accountantService.getAffilateRent(affilate, firstDayOfMonth, nowDate));
			mav.addObject("currentAffiliateProfit", accountantService.getAffilateProfit(affilate, firstDayOfMonth, nowDate));
			mav.setViewName("dynamic");
			return mav;
		}
}