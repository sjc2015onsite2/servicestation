package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class StringToSiteUserConverter implements Converter<String, SiteUser> {

	@Autowired
	private Identification identification;
	
	@Override
	public SiteUser convert(String id) {
		return identification.getSiteUserById(id);
	}

}