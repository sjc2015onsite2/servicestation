package com.expositds.sjc.servicestation.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.expositds.sjc.servicestation.domain.model.Order;

/**
* <b>Order Data Controller</b>
* Allows to get/set <b>order</b> data from <b>mechanic</b> dashboard.
* 
* @author Sergey Rybakov, Oleg Ryzhko
* 
* @see <a href="https://bitbucket.org/sjc2015onsite2/service-station-domain/wiki/RU/Пользовательский%20интерфейс/Механик/Заявка%20на%20ремонт">Mechanic / Order Details</a>
* */

@Controller
@RequestMapping("/{stationId}/mechanic") /* XXX: What the purpose of "stationId" parameter in URI?*/
public class ChangeOrderDataController {
	
	@RequestMapping(value = "/myorders/{orderId}", method = { RequestMethod.GET }) /* FIXME:  Unsafe method! Mechanic can access foreign orders */
	public ModelAndView getOrderData(@PathVariable("orderId") Order order) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("order", order);
		mav.setViewName("change.order.data");
		
	return mav;
	}
	
	@RequestMapping(value = "/myorders/{orderId}", method = { RequestMethod.POST }) /* FIXME:  Unsafe method! Mechanic can access foreign orders */
	public String setOrderData(Order updatedOrder) {
		
		
		/* TODO: Saving Order object to DB. Mechanic service needed*/
		return "redirect:/myorders/"+updatedOrder.getOrderId().toString();
		}
	
}