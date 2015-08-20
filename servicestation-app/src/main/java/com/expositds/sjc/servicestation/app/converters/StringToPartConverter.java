package com.expositds.sjc.servicestation.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Rybakov Sergey
 *
 */
@Component
public class StringToPartConverter implements Converter<String, Part> {

	@Autowired
	private Identification identificationService;
	
	@Override
	public Part convert(String arg0) {
		return identificationService.getPartId(arg0);
	}
}
