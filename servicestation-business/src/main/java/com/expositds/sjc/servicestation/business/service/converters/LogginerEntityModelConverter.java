package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.LogginerEntity;
import com.expositds.sjc.servicestation.domain.model.Logginer;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class LogginerEntityModelConverter implements Converter<LogginerEntity, Logginer> {

	@Override
	public Logginer convert(LogginerEntity source) {
		Logginer logginer = new Logginer();
		logginer.setId(source.getId());
		logginer.setName(source.getName());
		logginer.setLogin(source.getLogin());
		logginer.setPassword(source.getPassword());
		logginer.setRole(source.getRole());
		return logginer;
	}

}
