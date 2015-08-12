package com.expositds.sjc.servicestation.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Rybakov Sergey
 *
 */
@Component
public class StringToPersonConverter implements Converter<String, Person> {

	@Autowired
	private Identification identificationService;
	
	@Override
	public Person convert(String arg0) {
		return identificationService.getPersonId(arg0);
	}

}
