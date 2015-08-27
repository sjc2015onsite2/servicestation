package com.expositds.sjc.servicestation.business.repository.impl.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.dto.StationsDtoDao;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;

@Repository
public class StationsDtoDaoImpl implements StationsDtoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public StationsDto getStationsDto() {
		return (StationsDto) getSession().get(StationsDto.class, 1L);
	}

}
