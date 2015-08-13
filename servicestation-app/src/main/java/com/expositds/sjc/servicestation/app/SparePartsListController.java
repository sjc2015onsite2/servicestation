package com.expositds.sjc.servicestation.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.model.Affilate; // FIXME: Incorrect spelling (Affiliate)


/**
* <b>SparePartListController</b>
* Shows part quantity at mechaics affiliate
* 
* @author Sergey Rybakov, Oleg Ryzhko
* 
* @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Список%20запчастей">Mechanic / Spare parts</a>
* */

// TODO: Need mechanic service!
@Controller
@RequestMapping("/{stationId}/mechanic")
public class SparePartsListController {
	
	//@Autowired
	//private Mechanic mechanicService;
	
	// FIXME: Unsafe method! Mechanic can access to any service station parts.
	@RequestMapping(value = "{affiliateId}/sparepartslist", method = { RequestMethod.GET })
	public ModelAndView showListOfSpareParts(@PathVariable("stationId") Station station, @PathVariable("affiliateId") Affilate affiliate) {
	
		ModelAndView mav = new ModelAndView();
		//mav.addObject("parts", mechanicService.getPartsQuantity(affiliate));
		mav.setViewName("spare.parts.list");
	return mav;
	}
	
}