package com.expositds.sjc.servicestation.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.service.Identification;


/**
 * Converts string id to Order object
 * 
 * @author Oleg Ryzhko
 *
 * @param id Order ID string.
 * 
 * @return Order object with specified ID. 
 */

@Component
public class StringToOrderConverter implements Converter<String, Order> {

	@Autowired
	private Identification identificationService;
	
	@Override
	public Order convert(String id) {
		
		return identificationService.getOrderId(id);
	}

}
