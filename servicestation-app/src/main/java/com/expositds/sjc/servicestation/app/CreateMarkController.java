package com.expositds.sjc.servicestation.app;

import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CreateMarkController</b>
 * 
 * Shows form for mark creating and gets data from it.
 * 
 * @author Sergey Rybakov
 * */


@Controller
@RequestMapping(value = "/user")
public class CreateMarkController {

	@Autowired
	private AuthorizedUserSite authorizedUserSite;
	
	@Autowired
	private Identification identificationService;
	
	@RequestMapping(value = "/createmark", method = RequestMethod.GET)
	public ModelAndView getForm() {
		
		Set<Station> stations = authorizedUserSite.getServiceStations();
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.setViewName("createMark");
		return mav;
		
	}
	
	@RequestMapping(value = "/createmark", method = RequestMethod.POST )
	public String createMark(
			@RequestParam(value = "stationId", required = true) Station station,
			Authentication auth,
			@RequestParam(required = true) Integer markValue) {
		
		Logginer logginer = identificationService.getLogginerByName(auth.getName());
		SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
		
		authorizedUserSite.publicMark(station, authorizedUserSite.createMark(user, markValue));
		
		return "redirect:/stationslist";
	}
}
