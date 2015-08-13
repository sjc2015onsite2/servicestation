package com.expositds.sjc.servicestation.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.expositds.sjc.servicestation.domain.model.Station;


/**
* <b>MechanicOrdersController</b>
* Shows list of orders that belongs to mechanic. Also displays list of free orders.
* 
* @author Sergey Rybakov, Oleg Ryzhko
* 
* @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Механик/Все%20заявки">Mechanic / Free orders</a>
* @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Механик/Мои%20заявки">Mechanic / My orders</a>
* */

// FIXME: Mechanic service not implemented!!! Change mapping in header!
@Controller
@RequestMapping("/{stationId}/mechanic")
public class MechanicOrdersController {
	
	@RequestMapping(value = "/myorders", method = { RequestMethod.GET })
	public String showOrdersOfMechanic(@PathVariable("stationId") Station station) {
		
	return "mechanic.orders";
	}
	
	@RequestMapping(value = "/freeorders", method = { RequestMethod.GET})
	public String showFreeOrders(@PathVariable("stationId") Station station){
		
	return "free.orders";
	}
}