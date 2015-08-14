package com.expositds.sjc.servicestation.app.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.service.Identification;


/**
 * Converts string id to Order object
 * 
 * @author Oleg Ryzhko
 *
 * @param id Affiliate ID string.
 * 
 * @return Affiliate object with specified ID. 
 */

@Component
public class StringToAffiliateConverter implements Converter<String, Affilate> {

	@Autowired
	private Identification identificationService;
	
	@Override
	public Affilate convert(String id) {
		
		return identificationService.getAffilateById(id);
	}

}
