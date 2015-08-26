
package com.expositds.sjc.servicestation.app;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.app.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CustomerOrdersController</b>
 * 
 * @author Sergey Rybakov, Oleg Ryzhko
 * */


@Controller
@RequestMapping("/user")
public class CustomerOrdersController {

	@Autowired
	private AuthorizedUserSite authorizedUserSiteService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = "/myorders", method = RequestMethod.GET)
		public ModelAndView myorders(@RequestParam(value = "page", required = false) Long page,
									 Authentication auth) {
			
			if(page==null) page = 1L;
			Long pageSize = 3L;
			
			Long startPage = page;
			Long endPage = page + 9;
		
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("orders", authorizedUserSiteService.getOrdersLimit(user, (page-1)*pageSize+1, pageSize));
			mav.addObject("page", page);
			mav.addObject("startpage", startPage);
			mav.addObject("endpage", endPage);
			mav.setViewName("myOrders");
			return mav;
		}
		
		@RequestMapping(value = "/myorders/{orderId}", method = RequestMethod.GET)
		public ModelAndView myorder(@PathVariable("orderId") Order order) {
			
			boolean change = false;
			if(order.getCompleteDate() != null){
				if(order.getCompleteDate().compareTo(order.getCreateDate()) < 0){
					change = true;
				}
			}
			
			CustomerOrderDto customerOrderDto = new CustomerOrderDto.Builder(order).build();
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("customerOrderDto", customerOrderDto);
			mav.addObject("change", change); ;
			mav.setViewName("customer.order.data");
			
			return mav;
		}
		
		@RequestMapping(value = "/myorders/changestation", method = RequestMethod.POST)
		public ModelAndView changeServiceStation(
				@RequestParam(value = "orderId") Order order,
				@RequestParam(value = "stationId") Station station,
				Authentication auth){
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			SiteUser user = identificationService.getSiteUserById(logginer.getId().toString());
				
			   authorizedUserSiteService.changeServiceStation(user, order, station);
			   
			   ModelAndView mav = new ModelAndView();
			   Long id = order.getOrderId();
			   mav.setViewName("redirect:/user/myorders/"+id);
			
			return mav;
		}
}
