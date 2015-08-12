package com.expositds.sjc.servicestation.app;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;

//import sjc.example.domain.model.UserPrincipal;
//import sjc.example.domain.service.UserService;



/**
 * HomeController
 * Отвечает за отображение главной страницы (www.site-agregator.com)
 * Отвечает за авторизацию пользователя обработав его данные (login, password) 
 * Обрабатывае запрос клиента на выход с профиля 
 * 
 * @author Sergey Rybakov
 * */

@Controller
@RequestMapping(value = "")
public class HomeController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSite;	
	
	@RequestMapping(value = {"/createorder", "/"}, method = { RequestMethod.GET })
	public ModelAndView createOrder() {
		
		Set<Station> stations = nonAuthorizedUserSite.getServiceStations();
		
		//nonAuthorizedUserSite.getServiceStationComments(serviceStation);
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("stations",  stations);
		mav.setViewName("createOrder");
		return mav;
	}
	
	
	
	 /*@RequestMapping(value = "/createorder", method = { RequestMethod.POST })
	public ModelAndView login(
		@RequestParam(value = "username", required=true) String username,
		@RequestParam(value = "password", required=true) String password,
		HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("createOrder");
			
		return mav;
	} 
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {

		ModelAndView model = new ModelAndView();
		
		model.setViewName("createOrder");
		session.setAttribute("user", null);
		session.invalidate();
		
		return model;
	}*/
}
