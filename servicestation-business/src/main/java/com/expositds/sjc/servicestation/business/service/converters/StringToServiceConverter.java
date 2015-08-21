package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class StringToServiceConverter implements Converter<String, Service> {
	
	@Autowired
	private Identification identification;
	
	@Override
	public Service convert(String id) {
		return identification.getServiceById(id);
	}

}
