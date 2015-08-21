package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class StringToPersonConverter implements Converter<String, Person> {

	@Autowired
	private Identification identification;
	
	@Override
	public Person convert(String id) {
		return identification.getPersonById(id);
	}

}
