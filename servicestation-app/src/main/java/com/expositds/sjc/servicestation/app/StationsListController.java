package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
 *
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class StationsListController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;	
	
	
	@RequestMapping(value = "/stationslist", method = { RequestMethod.GET })
	public ModelAndView createOrder() {
		
		Set<Station> stations = nonAuthorizedUserSite.getServiceStations();
		
		Map<Long, Double> stationMarks = new HashMap<>();
		for(Station currentStation : stations){
			stationMarks.put(currentStation.getStationId(), nonAuthorizedUserSite.getAverageStationMark(currentStation));
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.addObject("stationMarks", stationMarks);
		
		mav.setViewName("stations.list");
		return mav;
	}
	
	@RequestMapping(value = "/stationscomments/{stationId}", method = { RequestMethod.GET })
	public ModelAndView stationsComments(@PathVariable("stationId") Station station) {
		
		Set<Comment> stationsComments = nonAuthorizedUserSite.getServiceStationComments(station);
		ModelAndView mav = new ModelAndView();
		
		Map<Comment,String> comments = new HashMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Comment currentcomment : stationsComments){
			
			comments.put(currentcomment, dateFormat.format(currentcomment.getDate().getTime()));
		}
		
		mav.addObject("comments", comments);
		mav.setViewName("stationsComments");
		return mav;
	}
	
	@RequestMapping(value = "/mechanicslist/{stationId}", method = { RequestMethod.GET })
	public ModelAndView stationsMechanics(@PathVariable("stationId") Station station) {
		
		Set<Person> mechanics = nonAuthorizedUserSite.getServiceStationMechanics(station);
		ModelAndView mav = new ModelAndView();
		mav.addObject("mechanicsList", mechanics);
		mav.setViewName("mechanics.list");
		return mav;
	}
	
	@RequestMapping(value = "/mechanicscomments/{personId}", method = { RequestMethod.GET })
	public ModelAndView mechanicsComments(@PathVariable("personId") Person person) {
		
		Set<Comment> mechanicsComments = nonAuthorizedUserSite.getMechanicComments(person);
		ModelAndView mav = new ModelAndView();
		mav.addObject("mechanicsComments", mechanicsComments);
		mav.setViewName("mechanicsComments");
		return mav;
	}
	
	
}