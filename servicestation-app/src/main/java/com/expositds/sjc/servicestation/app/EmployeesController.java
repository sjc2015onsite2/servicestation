package com.expositds.sjc.servicestation.app;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.Accountant;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>EmployeesController</b>
 *  
 * Контроллер отвечает за отображение списка сотрудников и их з/п 
 * позволяет менять любому сотруднику з/п
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class EmployeesController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = {"/accountant/employees", "/ceo/employees"}, method = RequestMethod.GET)
		public ModelAndView showEmployeesData(Authentication auth) {
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person accountant = identificationService.getPersonById(logginer.getId().toString());
			
			Set<Person> employees = new HashSet<>();
			employees.addAll(accountantService.getServiceStationEmloyees(identificationService.getStationByPerson(accountant)));
			
			String[][] personsData = new String[employees.size()][5];
			int i = 0;
			Calendar now = new GregorianCalendar();
			Calendar nowDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			Calendar yesterDate = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));
			yesterDate.add(Calendar.DAY_OF_MONTH, -1);
			for(Person currentPerson : employees){
				personsData[i][0] = currentPerson.getName();
				personsData[i][1] = currentPerson.getRole().toString();
				personsData[i][2] = accountantService.getEmployeeSalary(currentPerson, nowDate, nowDate).toString();
				personsData[i][3] = currentPerson.getId().toString();
				personsData[i][4] = accountantService.getEmployeeSalary(currentPerson, yesterDate, yesterDate).toString();
				i++;
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("personsData", personsData);
			mav.setViewName("employees");
			return mav;
		}
		
		@RequestMapping(value = {"/accountant/employees", "/ceo/employees"}, method = RequestMethod.POST)
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