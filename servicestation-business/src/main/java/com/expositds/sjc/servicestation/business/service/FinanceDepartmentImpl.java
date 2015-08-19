package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.FinanceDepartment;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class FinanceDepartmentImpl implements FinanceDepartment {
	
	@Autowired
	private StationDao stationDao;

	@Override
	public Set<Person> getServiceStationEmployees(Station serviceStation) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		return null;
	}

	@Override
	public Set<Person> getAffiliateMechanics(Affilate affiliate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getServiceStationReadyOrders(Station serviceStation, Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getServiceStationOrders(Station serviceStation, Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getAffiliateOrders(Affilate affiliate, Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Order> getAffiliateReadyOrders(Affilate affiliate, Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Calendar, Integer> getAffilateRent(Affilate affilate, Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Calendar, Integer> getEmployeeSalary(Person employee, Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
