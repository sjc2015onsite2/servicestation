package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class StringToOrderConverter implements Converter<String, Order> {

	@Autowired
	private Identification identification;
	
	@Override
	public Order convert(String id) {
		
		return identification.getOrderId(id);
		
	}

}
