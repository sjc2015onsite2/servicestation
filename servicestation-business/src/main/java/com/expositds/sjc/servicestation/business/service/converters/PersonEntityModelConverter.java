package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.domain.model.Person;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class PersonEntityModelConverter implements Converter<PersonEntity, Person> {

	@Override
	public Person convert(PersonEntity source) {
		Person person = new Person(source.getName(), source.getRole());
		person.setId(source.getId());
		person.setInfo(source.getInfo());
		return person;
	}

}
