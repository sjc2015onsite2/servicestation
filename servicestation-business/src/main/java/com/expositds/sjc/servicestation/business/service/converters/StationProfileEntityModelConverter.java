package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.StationProfileEntity;
import com.expositds.sjc.servicestation.domain.model.StationProfile;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class StationProfileEntityModelConverter implements Converter<StationProfileEntity, StationProfile> {

	@Override
	public StationProfile convert(StationProfileEntity source) {
		StationProfile stationProfile = new StationProfile();
		stationProfile.setStationProfileId(source.getStationProfileId());
		return stationProfile;
	}

}
