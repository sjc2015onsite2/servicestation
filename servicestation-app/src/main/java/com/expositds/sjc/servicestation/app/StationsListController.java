package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
 *<b>StationsListController</b>
 * 
 * Контроллер отображает список станций, механиков каждой станции 
 * и коментрарии о каждой станции и механике
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class StationsListController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;	
	
	
	@RequestMapping(value = "/stationslist", method = RequestMethod.GET)
	public ModelAndView createOrder() {
		
		Set<Station> stations = nonAuthorizedUserSite.getServiceStations();
		
		Map<Long, Double> stationMarks = new HashMap<>();
		for(Station currentStation : stations){
			double newmark = nonAuthorizedUserSite.getAverageStationMark(currentStation);
			if(!Double.isNaN(newmark))
				newmark = new BigDecimal(nonAuthorizedUserSite.getAverageStationMark(currentStation)).setScale(1, RoundingMode.UP).doubleValue();
			
			stationMarks.put(currentStation.getStationId(), newmark);
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.addObject("stationMarks", stationMarks);
		
		mav.setViewName("stations.list");
		return mav;
	}
	
	@RequestMapping(value = "/stationscomments/{stationId}", method = RequestMethod.GET)
	public ModelAndView stationsComments(@PathVariable("stationId") Station station) {
		
		Set<Comment> stationsComments = nonAuthorizedUserSite.getServiceStationComments(station);
		ModelAndView mav = new ModelAndView();
		
		Map<Comment,String> comments = new TreeMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Comment currentcomment : stationsComments){
			comments.put(currentcomment, dateFormat.format(currentcomment.getDate().getTime()));
		}
		mav.addObject("comments", comments);
		mav.addObject("stationName", station.getName());
		mav.setViewName("stationsComments");
		return mav;
	}
	
	@RequestMapping(value = "/mechanicslist/{stationId}", method = RequestMethod.GET)
	public ModelAndView stationsMechanics(@PathVariable("stationId") Station station) {
		
		Set<Person> mechanics = nonAuthorizedUserSite.getServiceStationMechanics(station);
		ModelAndView mav = new ModelAndView();
		mav.addObject("stationName", station.getName());
		mav.addObject("mechanicsList", mechanics);
		mav.setViewName("mechanics.list");
		return mav;
	}
	
	@RequestMapping(value = "/mechanicscomments/{personId}", method = RequestMethod.GET)
	public ModelAndView mechanicsComments(@PathVariable("personId") Person person) {
		
		Set<Comment> mechanicsComments = nonAuthorizedUserSite.getMechanicComments(person);
		
		Map<Comment,String> comments = new TreeMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for(Comment currentcomment : mechanicsComments){
			comments.put(currentcomment, dateFormat.format(currentcomment.getDate().getTime()));
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mechanicName", person.getName());
		mav.addObject("comments", comments);
		mav.setViewName("mechanicsComments");
		return mav;
	}
	
	
}