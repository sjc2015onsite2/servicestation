package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class StringToAffiliateConverter implements Converter<String, Affilate> {

	@Autowired
	private Identification identification;
	
	@Override
	public Affilate convert(String id) {
		return identification.getAffilateById(id);
	}

}
