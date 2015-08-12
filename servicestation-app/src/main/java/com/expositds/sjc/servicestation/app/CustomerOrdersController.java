package com.expositds.sjc.servicestation.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CustomerOrdersController</b>
 * Отвечает за отображение страницы заявок клиента (www.site-agregator.com/myorders)
 * 
 * @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Пользователь%20сайта/Мои%20заявки">Пользователь сайта / Мои заявки</a>
 * 
 * @author Sergey Rybakov, Oleg Ryzhko
 * */


@Controller
public class CustomerOrdersController {

	//@Autowired
	//private AuthorizedUserSite authorizedUserSiteService;
	
	/*@RequestMapping(value = "/myorders", method = { RequestMethod.GET })
	public ModelAndView myorders(@PathVariable("userId") SiteUser user, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("orders", authorizedUserSiteService.getOrders(user));
		mav.setViewName("myOrders");
		return mav;
	}*/
	
	@RequestMapping(value = "/myorders", method = { RequestMethod.GET })
	public String myorders() {
		
		ModelAndView mav = new ModelAndView();	
		return "myOrders";
	}
	
	
	@RequestMapping(value = "/myorders/orderId", method = { RequestMethod.GET })
	public String showCustomerOrderData() {
		
	return "customer.order.data";
	}
}