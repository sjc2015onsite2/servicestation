package com.expositds.sjc.servicestation.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class StringToStationConverter implements Converter<String, Station> {

	@Autowired
	private Identification identificationService;
	
	@Override
	public Station convert(String arg0) {
		return identificationService.getStationById(arg0);
	}

}
