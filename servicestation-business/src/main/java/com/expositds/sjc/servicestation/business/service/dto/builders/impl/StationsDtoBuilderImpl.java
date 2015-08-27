package com.expositds.sjc.servicestation.business.service.dto.builders.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.dto.StationsDtoDao;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;
import com.expositds.sjc.servicestation.business.service.dto.builders.StationsDtoBuilder;

/**
 * @author Алексей
 *
 */
@Service
@Transactional
public class StationsDtoBuilderImpl implements StationsDtoBuilder {
	
	@Autowired
	private StationsDtoDao stationsDtoDao;

	@Override
	public StationsDto build() {
		return stationsDtoDao.getStationsDto();
	}

}
