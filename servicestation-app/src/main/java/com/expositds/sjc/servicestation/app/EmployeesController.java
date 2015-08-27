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
public class EmployeesController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = "/employees", method = RequestMethod.GET)
		public ModelAndView showEmployeesData(Authentication auth) {
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person accountant = identificationService.getPersonById(logginer.getId().toString());
			
			Set<Person> employees = new HashSet<>();
			employees.addAll(accountantService.getServiceStationEmloyees(identificationService.getStationByPerson(accountant)));
			
			String[][] personsData = new String[employees.size()][4];
			int i = 0;
			Calendar now = new GregorianCalendar();
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			for(Person currentPerson : employees){
				personsData[i][0] = currentPerson.getName();
				personsData[i][1] = currentPerson.getRole().toString();
				personsData[i][2] = accountantService.getEmployeeSalary(currentPerson, nowDate, nowDate).toString();
				personsData[i][3] = currentPerson.getId().toString();
				i++;
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("personsData", personsData);
			mav.setViewName("employees");
			return mav;
		}
		
		@RequestMapping(value = "/employees", method = RequestMethod.POST)
		public ModelAndView changeSalary(Authentication auth,
				@RequestParam(value="personId") Person person,
				@RequestParam Integer newsalary) {
			
			Calendar now = new GregorianCalendar();
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			Map<Calendar, Integer> dateAndRent = new HashMap<>();
			dateAndRent.put(nowDate, newsalary);
			accountantService.setSalary(person, dateAndRent);
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/accountant/employees");
			return mav;
		}
}