package com.expositds.sjc.servicestation.app;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
 * <b>CreateCommentsController</b>
 * This controller shows form to not authorized site user and fetches data from it.
 * 
 * 
 * @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Оставить%20отзыв%20о%20СТО">Site user / Leave comment about Service Station</a>
 * <p><a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Оставить%20отзыв%20о%20механике">Site user / Leave comment about mechanic</a>
 * 
 * @author Sergey Rybakov, Oleg Ryzhko
 * */


@Controller
public class CreateCommentsController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;
	
	
	@RequestMapping(value = "/createstationcomment", method = { RequestMethod.GET })
	public ModelAndView getStationCommentForm() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations", nonAuthorizedUserSite.getServiceStations());
		mav.setViewName("createStationComment");
		return mav;
	}
	
	@RequestMapping(value = "/createmechaniccomment", method = { RequestMethod.GET })
	public ModelAndView getMechanicCommentForm() {
		
		//Set<Station> stations = nonAuthorizedUserSite.getServiceStations();
		//Set<Person> mechanics = new HashSet<Person>();
		//for(Station station : stations)
		//{
			//mechanics.addAll(nonAuthorizedUserSite.getServiceStationMechanics(station));
		//}
		
		ModelAndView mav = new ModelAndView();
		//mav.addObject("mechanics", mechanics);
		mav.setViewName("createMechanicComment");
		return mav;
	}
	
	
	@RequestMapping(value = "/createstationcomment", method = { RequestMethod.POST })
	public String createstationcomment(@RequestParam String stationId, Comment comment) {


		/* TODO: Saving Comment object to DB. Save method needed in ServiceStationImpl*/
		return "redirect:/stationscomments/"+stationId;
	}
	
	@RequestMapping(value = "/createmechaniccomment", method = { RequestMethod.POST })
	public String createmechaniccomment(@RequestParam String mechanicId, Comment comment) {
		
		/* FIXME: No methods to save comment in Mechanic interface. Where comments stored?  
		 * TODO: Saving Comment object to DB. Mechanic service needed.
		 */
		return "redirect:/mechanicscomments/"+mechanicId;
	}
}