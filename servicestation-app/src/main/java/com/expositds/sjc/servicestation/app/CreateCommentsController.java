package com.expositds.sjc.servicestation.app;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * CreateCommentsController
 * 

 * @author Sergey Rybakov
*/
@Controller
public class CreateCommentsController {

	@Autowired
	private AuthorizedUserSite authorizedUserSite;
	
	@Autowired
	private Identification identificationService;
	
	@RequestMapping(value = "/user/createstationcomment", method = { RequestMethod.GET })
	public ModelAndView createStationComment() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations", authorizedUserSite.getServiceStations());
		mav.setViewName("createStationComment");
		return mav;
	}
	
	@RequestMapping(value = "/user/createstationcomment", method = RequestMethod.POST )
	public ModelAndView createStationComment(
			@RequestParam(value = "stationId", required = true) Station station,
			Authentication auth,
			@RequestParam(required = true) String comment,
			@RequestParam String notvisible){
		
		boolean visible = true;
		if(notvisible.equals("yes")){
			visible = false;
		}
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
		
		authorizedUserSite.publicServiceStationComment(station, authorizedUserSite.createComment(user, comment, visible));
		
		Set<Comment> stationsComments = authorizedUserSite.getServiceStationComments(station);
		ModelAndView mav = new ModelAndView();
		mav.addObject("stationsComments", stationsComments);
		Long id = station.getStationId();
		mav.setViewName("redirect:/stationscomments/" + id);
		return mav;
	}
	
	@RequestMapping(value = "/user/createmechaniccomment", method = { RequestMethod.GET })
	public ModelAndView createMechanicComment() {
		
		Set<Station> stations = authorizedUserSite.getServiceStations();
		Set<Person> mechanics = new HashSet<>();
		
		for(Station currentstation : stations) {
			Set<Person> currentPersons = authorizedUserSite.getServiceStationMechanics(currentstation);
			mechanics.addAll(currentPersons);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("mechanics", mechanics);
		mav.setViewName("createMechanicComment");
		return mav;
	}
	
	@RequestMapping(value = "/user/createmechaniccomment", method = RequestMethod.POST )
	public ModelAndView createMechanicComment(
			@RequestParam(value = "mechanicId", required = true) Person mechanic,
			Authentication auth,
			@RequestParam(required = true) String comment,
			@RequestParam String notvisible){
		
		boolean visible = true;
		if(notvisible.equals("yes")){
			visible = false;
		}
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
		
		authorizedUserSite.publicMechanicComment(mechanic, authorizedUserSite.createComment(user, comment, visible));
		
		Set<Comment> mechanicsComments = authorizedUserSite.getMechanicComments(mechanic);
		ModelAndView mav = new ModelAndView();
		mav.addObject("mechanicsComments", mechanicsComments);
		Long id = mechanic.getId();
		mav.setViewName("redirect:/mechanicscomments/" + id);
		return mav;
	}
}