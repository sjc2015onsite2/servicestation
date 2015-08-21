package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.MechanicProfileEntity;
import com.expositds.sjc.servicestation.domain.model.MechanicProfile;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class MechanicProfileEntityModelConverter implements Converter<MechanicProfileEntity, MechanicProfile> {

	@Override
	public MechanicProfile convert(MechanicProfileEntity source) {
		MechanicProfile mechanicProfile = new MechanicProfile();
		mechanicProfile.setMechanicPofileId(source.getMechanicPofileId());
		return mechanicProfile;
	}

}
