package com.expositds.sjc.servicestation.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Rybakov Sergey
 *
 */
@Component
public class StringToServiceConverter implements Converter<String, Service> {

	@Autowired
	private Identification identificationService;
	
	@Override
	public Service convert(String arg0) {
		return identificationService.getServiceId(arg0);
	}

}