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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Ceo;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CommentsController</b>
 * Контроллер отвечает за отображение комментариев о станции и о конкертном механике
 * и обрабатывает форму для выбора конекретного механика
 * 
 * @author Sergey Rybakov
 * */

@Controller
@RequestMapping(value = "/ceo")
public class CommentsController {
	
	@Autowired
	private AuthorizedUserSite authorizedUserSite;
	
	@Autowired
	private Ceo ceoService;
	
	@Autowired
	private Identification identificationService;

	@RequestMapping(value = "/stationcomments", method = RequestMethod.GET)
	public ModelAndView showStationComments(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person ceo = identificationService.getPersonById(logginer.getId().toString());
		
		Station station = identificationService.getStationByPerson(ceo);
		Set<Comment> stationsComments = ceoService.getServiceStationComments(station);
		
		Map<Comment,String> comments = new HashMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Comment currentcomment : stationsComments){
			comments.put(currentcomment, dateFormat.format(currentcomment.getDate().getTime()));
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("comments", comments);
		mav.setViewName("station.comments");
		return mav;
	}
	
	@RequestMapping(value = "/mechanicscomments", method = RequestMethod.GET)
	public ModelAndView showMechanicsComments(Authentication auth) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person ceo = identificationService.getPersonById(logginer.getId().toString());
		
		Station station = identificationService.getStationByPerson(ceo);
		
		Set<Person> mechanics = new HashSet<>();
		mechanics.addAll(authorizedUserSite.getServiceStationMechanics(station));

		ModelAndView mav = new ModelAndView();
		mav.addObject("mechanics", mechanics);
		mav.setViewName("mechanics.comments");
		return mav;
	}
	
	@RequestMapping(value = "/mechanicscomments", method = { RequestMethod.POST })
	public ModelAndView selestMechanic(
			Authentication auth,
			@RequestParam(value="mechanicId") Person mechanic) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		Person ceo = identificationService.getPersonById(logginer.getId().toString());
		
		Station station = identificationService.getStationByPerson(ceo);
		
		Set<Person> mechanics = new HashSet<>();
		mechanics.addAll(authorizedUserSite.getServiceStationMechanics(station));
		
		Set<Comment> mechanicsComments = authorizedUserSite.getMechanicComments(mechanic);
		
		Map<Comment,String> comments = new HashMap<>();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Comment currentcomment : mechanicsComments){
			comments.put(currentcomment, dateFormat.format(currentcomment.getDate().getTime()));
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("comments", comments);
		mav.addObject("mechanics", mechanics);
		mav.addObject("mechanicName", mechanic.getName());
		mav.setViewName("mechanics.comments");
		return mav;
	}
}
