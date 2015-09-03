package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Ceo;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>MarksController</b>
 * 
 * 
 * @author Sergey Rybakov
 * */


@Controller
@RequestMapping("/ceo")
public class MarksController {
	
		@Autowired
		private Identification identificationService;
	
		@Autowired
		private Ceo ceoService;
	
		@RequestMapping(value = "/marks", method = RequestMethod.GET)
		public ModelAndView showMarks(Authentication auth) {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person ceo = identificationService.getPersonById(logginer.getId().toString());
			
			Set<Mark> marks = new HashSet<>();
			Station station = identificationService.getStationByPerson(ceo);
			marks.addAll(ceoService.getServiceStationMarks(station));
			Map<Mark,String> marksanddate = new HashMap<>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			for(Mark currentMark : marks){
				marksanddate.put(currentMark, dateFormat.format(currentMark.getDate().getTime()));
			}
			
			int mark = 0; int i = 0;
			for(Mark currentMark : marks){
				mark += currentMark.getMark();
				i++;
			}
			mark = mark / i;
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("mark", mark);
			mav.addObject("marksanddate", marksanddate);
			mav.setViewName("marks");
			return mav;
		}
}