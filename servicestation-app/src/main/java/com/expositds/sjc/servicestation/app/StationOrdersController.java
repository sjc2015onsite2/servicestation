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
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Accountant;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * <b>StationsOrdersController</b>
 * 
 * Контроллер отвечает за отображение списка заявок на ремонт сделанных клиентами на данную станцию
 * 
 * @author Sergey Rybakov
 * */


@Controller
public class StationOrdersController {
	
	@Autowired 
	private Accountant accountantService;
	
	@Autowired
	private Identification identificationService;
	
		@RequestMapping(value = {"/accountant/orders", "/ceo/orders"}, method = RequestMethod.GET)
		public ModelAndView showStationOrders() {
			
			ModelAndView mav = new ModelAndView();
			mav.setViewName("station.orders.list");
			return mav;
		}
		
		@RequestMapping(value = {"/accountant/orders", "/ceo/orders"}, method = RequestMethod.POST)
		public ModelAndView selectDateForOrders(
				Authentication auth,
				@RequestParam String startdate,
				@RequestParam String finishdate) throws ParseException {
			
			Logginer logginer = identificationService.getLogginerByName(auth.getName());
			Person accountant = identificationService.getPersonById(logginer.getId().toString());
			
			Calendar sDate = new GregorianCalendar();
			Calendar fDate = new GregorianCalendar();
			SimpleDateFormat sdf = (SimpleDateFormat) new SimpleDateFormat("dd.MM.yyyy", Locale.US);
			sDate.setTime(sdf.parse(startdate));
			fDate.setTime(sdf.parse(finishdate));
			
			Station station = identificationService.getStationByPerson(accountant);
			
			Set<Order> allOrders = new HashSet<>();
			allOrders.addAll(accountantService.getServiceStationOrders(station, sDate, fDate));
			
			String[][] ordersData = new String[allOrders.size()][5];
			int i = 0;
			for(Order currentOrder : allOrders){
				ordersData[i][0] = currentOrder.getOrderId().toString();
				ordersData[i][1] = currentOrder.getProblemDescription();
				ordersData[i][2] = currentOrder.getStatus().toString();
				Integer cost = new Integer(0);
				String[][] serviceRows = new String[currentOrder.getServices().size()][3];
				int j = 0;
				for(Service currentService : currentOrder.getServices().keySet()){
					serviceRows[j][0] = currentOrder.getServices().get(currentService).toString();
					serviceRows[j][1] = currentOrder.getOrderServicesPriceList().get(currentService).toString();
					serviceRows[j][2] = Integer.toString((Integer.parseInt(serviceRows[j][0]) * Integer.parseInt(serviceRows[j][1])));
					cost += Integer.parseInt(serviceRows[j][2]);
					j++;
				}
				ordersData[i][3] = cost.toString();
				String createdate = new String();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
				createdate = dateFormat.format(currentOrder.getCreateDate().getTime());
				ordersData[i][4] = createdate;
				i++;
 			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("ordersData", ordersData);
			mav.setViewName("station.orders.list");
			return mav;
		}
}