package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import com.expositds.sjc.servicestation.domain.service.Accountant;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CustomerOrdersController</b>
 * 
 * @author Sergey Rybakov
 * */


@Controller
@RequestMapping("/accountant")
public class AffiliatesController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = "/affiliates", method = RequestMethod.GET)
		public ModelAndView myorders(Authentication auth) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person accountant = identificationService.getPersonById(logginer.getId().toString());
			
			Set <Affilate> affiliates = new HashSet<>();
			affiliates = accountantService.getServiceStationAffilate(identificationService.getStationByPerson(accountant));
			
			String[][] affilData = new String [affiliates.size()][3];
			int i = 0;
			Calendar now = new GregorianCalendar();
			Calendar firstMonthDay = new GregorianCalendar();
			
			//Calendar firstMonthDay = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1);  
			for(Affilate currentaffiliat : affiliates){
				affilData[i][0] = currentaffiliat.getAffilateId().toString();
				affilData[i][1] = accountantService.getAffilateRent(currentaffiliat, firstMonthDay, now).toString();
				affilData[i][2] = accountantService.getAffilateProfit(currentaffiliat, firstMonthDay, now).toString();
				i++;
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("affilData", affilData);
			mav.setViewName("affiliates");
			return mav;
		}
}