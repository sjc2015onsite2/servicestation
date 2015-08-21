package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.SiteUserEntity;
import com.expositds.sjc.servicestation.domain.model.SiteUser;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class SiteUserEntityModelConverter implements Converter<SiteUserEntity, SiteUser> {

	@Override
	public SiteUser convert(SiteUserEntity source) {
		SiteUser siteUser = new SiteUser(source.getName(), source.getRole());
		siteUser.setId(source.getId());
		return siteUser;
	}

}
