package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.AffilateProfileEntity;
import com.expositds.sjc.servicestation.domain.model.AffilateProfile;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class AffilateProfileEntityModelConverter implements Converter<AffilateProfileEntity, AffilateProfile> {

	@Override
	public AffilateProfile convert(AffilateProfileEntity source) {
		AffilateProfile affialteProfile = new AffilateProfile();
		affialteProfile.setAffilateProfileId(source.getAffilateProfileId());
		return affialteProfile;
	}

}
