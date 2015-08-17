package com.expositds.sjc.servicestation.app;

import java.util.HashSet;
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
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
 * <b>CreateCommentsController</b>
 * 

 * @author Sergey Rybakov
*/

@Controller
public class CreateCommentsController {

	@Autowired
	private AuthorizedUserSite authorizedUserSite;
	
	@Autowired
	private Identification identificationService;
	
	@RequestMapping(value = "/createstationcomment", method = { RequestMethod.GET })
	public ModelAndView createStationComment() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations", authorizedUserSite.getServiceStations());
		mav.setViewName("createStationComment");
		return mav;
	}
	
	@RequestMapping(value = "/createstationcomment", method = RequestMethod.POST )
	public String createStationComment(
			@RequestParam(value = "stationId", required = true) Station station,
			Authentication auth,
			@RequestParam(required = true) String comment,
			@RequestParam String notvisible){
		
		boolean visible = true;
		if(notvisible == "yes"){
			visible = false;
		}
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
		
		authorizedUserSite.publicServiceStationComment(station, authorizedUserSite.createComment(user, comment, visible));
		
		return "redirect:/createstationcomment";
	}
}