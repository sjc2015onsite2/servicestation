package com.expositds.sjc.servicestation.app;

import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

/**
 * CreateMarkController
 * Отвечает за отображение страницы с формой оценки (www.site-agregator.com/createmark)
 * Обрабатывает оценку
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class CreateMarkController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;
	
	@RequestMapping(value = "/createmark", method = { RequestMethod.GET })
	public ModelAndView createMark() {
		
		Set<Station> stations = nonAuthorizedUserSite.getServiceStations();
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.setViewName("createMark");
		return mav;
	}
	
	
	
}