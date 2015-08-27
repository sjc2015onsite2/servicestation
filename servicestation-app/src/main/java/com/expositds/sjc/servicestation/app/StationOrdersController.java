package com.expositds.sjc.servicestation.app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Accountant;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>CustomerOrdersController</b>
 * 
 * @author Sergey Rybakov
 * */


@Controller
@RequestMapping("/accountant")
public class StationOrdersController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = "/orders", method = RequestMethod.GET)
		public ModelAndView showStationOrders() {
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("station.orders.list");
			return mav;
		}
		
		@RequestMapping(value = "/orders", method = RequestMethod.POST)
		public ModelAndView selectDateForOrders(
				Authentication auth,
				@RequestParam String startdate,
				@RequestParam String finishdate) throws ParseException {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person accountant = identificationService.getPersonById(logginer.getId().toString());
			
			Calendar sDate = new GregorianCalendar();//Calendar.getInstance();
			Calendar fDate = new GregorianCalendar();//.getInstance();
			SimpleDateFormat sdf = (SimpleDateFormat) new SimpleDateFormat("dd.MM.yyyy", Locale.US);
			sDate.setTime(sdf.parse(startdate));
			fDate.setTime(sdf.parse(finishdate));
			
			Station station = identificationService.getStationByPerson(accountant);
			
			Set<Order> allOrders = new HashSet<>();
			allOrders.addAll(accountantService.getServiceStationOrders(station, sDate, fDate));
			
			String[][] ordersData = new String[allOrders.size()][4];
			int i = 0;
			//int cost = 0;
			for(Order currentOrder : allOrders){
				ordersData[i][0] = currentOrder.getOrderId().toString();
				ordersData[i][1] = currentOrder.getProblemDescription();
				ordersData[i][2] = currentOrder.getStatus().toString();
				String createdate = new String();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				createdate = dateFormat.format(currentOrder.getCreateDate().getTime());
				ordersData[i][3] = createdate;
				i++;
 			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("ordersData", ordersData);
			mav.setViewName("station.orders.list");
			return mav;
		}
}