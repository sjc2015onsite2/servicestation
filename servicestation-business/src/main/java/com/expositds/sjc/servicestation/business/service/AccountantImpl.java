package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.AffilateProfileDao;
import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateProfileEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Accountant;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class AccountantImpl extends ReportableImpl implements Accountant {
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private AffilateProfileDao affilateProfileDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private Identification identification;

	@Override
	public void setAffilateRent(Affilate affilate, Map<Calendar, Integer> rentValue) {
		Station station = identification.getStationByAffilate(affilate);
		StationEntity stationEntity = stationDao.findById(station.getStationId());
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		AffilateProfileEntity affilateProfileEntity = stationEntity.getAffilates().get(affilateEntity);
		
		affilateProfileEntity.getRent().putAll(rentValue);
		
		affilateProfileDao.update(affilateProfileEntity);
		
	}

	@Override
	public void setSalary(Person employee, Map<Calendar, Integer> salaryValue) {
		PersonEntity personEntity = personDao.findById(employee.getId());
		
		personEntity.getSalary().putAll(salaryValue);
		
		personDao.update(personEntity);
		
	}

	

}
