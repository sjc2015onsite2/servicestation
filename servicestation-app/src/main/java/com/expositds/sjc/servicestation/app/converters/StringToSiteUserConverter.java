package com.expositds.sjc.servicestation.app.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Oleg Ryzhko
 *
 */

@Component
public class StringToSiteUserConverter implements Converter<String, SiteUser> {

	@Autowired
	private Identification identificationService;
	
	@Override
	public SiteUser convert(String arg0) {
		return identificationService.getSiteUserById(arg0);
	}

}