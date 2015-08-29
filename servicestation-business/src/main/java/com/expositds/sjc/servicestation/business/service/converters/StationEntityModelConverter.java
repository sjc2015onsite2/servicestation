package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Station;

@Component
public class StationEntityModelConverter implements Converter<StationEntity, Station> {

	@Override
	public Station convert(StationEntity source) {
		Station station = new Station(source.getName());
		station.setStationId(source.getStationId());
		return station;
	}

}
