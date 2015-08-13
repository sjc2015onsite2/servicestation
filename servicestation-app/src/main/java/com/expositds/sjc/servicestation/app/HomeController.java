package com.expositds.sjc.servicestation.app;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.PreOrder;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.ServiceStation;


/**
 * <b>HomeController</b> 
 * Shows site main page. Responsible for user data processing (login, password) and logout request handling.
 * 
 * @author Sergey Rybakov, Oleg Ryzhko
 * 
 * @see <a href=
 *      "https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Оформление%20заявки">
 *      Site user/ Main page</a>
 */

@Controller
public class HomeController {

	@Autowired
	private NonAuthorizedUserSite nonAuthorizedUserSiteService;
	
	@Autowired
	private ServiceStation serviceStationService;

	@RequestMapping(value = { "/createorder", "/" }, method = { RequestMethod.GET })
	public ModelAndView getForm() {

		Set<Station> stations = nonAuthorizedUserSiteService.getServiceStations();

		ModelAndView mav = new ModelAndView();
		mav.addObject("stations", stations);
		mav.setViewName("createOrder");
		return mav;
	}

	@RequestMapping(value = "/login", method = { RequestMethod.POST }) //FIXME: Change mapping in customerHeader.jsp file
	public ModelAndView login(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password, Order order, HttpServletRequest request,
			HttpSession session) {

		ModelAndView mav = new ModelAndView();
		SiteUser user = nonAuthorizedUserSiteService.getUser(username, password);
		if (user.equals(null))
			mav.setViewName("loginError"); // FIXME: !!!Page not exist
		else {
			session.setAttribute("user", user);

			mav.addObject("user", user);
			mav.addObject("order", order); // XXX: Save form data before login and then restore it.
			mav.setViewName("createOrder");
		}
		return mav;
	}

	@RequestMapping(value = "/createOrder", method = { RequestMethod.POST })
	public String createOrder(@RequestParam(value = "stationId", required = true) Station station, PreOrder order)
	{
		
		if(!order.equals(null)) serviceStationService.createOrder(station, order);
		
		return "createOrder";
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("createOrder");
		session.setAttribute("user", null);
		session.invalidate();

		return mav;
	}
}