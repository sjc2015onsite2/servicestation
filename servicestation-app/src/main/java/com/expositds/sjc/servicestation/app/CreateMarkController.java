package com.expositds.sjc.servicestation.app;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
 * <b>CreateMarkController</b>
 * 
 * Shows form for mark creating and gets data from it.
 * 
 * @author Sergey Rybakov, Oleg Ryzhko
 * 
 * @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Поставить%20оценку%20СТО">Site user/ Rate service station</a>
 * */


@Controller
public class CreateMarkController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;
	
	@RequestMapping(value = "/createmark", method = { RequestMethod.GET })
	public ModelAndView getForm() {
		
		Set<Station> stations = nonAuthorizedUserSite.getServiceStations();
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.setViewName("createMark");
		return mav;
		
	}
	
	@RequestMapping(value = "/createmark", method = { RequestMethod.POST })
	public String createMark(@RequestParam("stationId") Station station, Mark mark) {
		
		/* TODO: Saving Mark object to DB. Save method needed in NonAuthorizedUserSiteImpl (ServiceStationImpl)
		 * 
		 * nonAuthorizedUserSite.createMark(station, mark)???
		 * */
		return "redirect:/stationslist";
	}
	
	
	
}
