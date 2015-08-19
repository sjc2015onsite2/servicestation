package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateProfileEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.tools.EntityModelConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.FinanceDepartment;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.StationAffilate;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class FinanceDepartmentImpl implements FinanceDepartment {
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private StationAffilate stationAffilate;
	
	@Autowired
	private EntityModelConverter entityModelConverter;
	
	@Autowired
	private Identification identification;

	@Override
	public Set<Person> getServiceStationEmployees(Station serviceStation) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		Set<Person> employees = new HashSet<>();
		
		for (PersonEntity currentEmployeeEntity : stationEntity.getPersons())
			employees.add((Person) entityModelConverter.convert(currentEmployeeEntity, Person.class));
		
		return employees;
	}

	@Override
	public Set<Person> getAffiliateMechanics(Affilate affiliate) {
		return stationAffilate.getAffiliateMechanics(affiliate);
	}

	@Override
	public Set<Order> getServiceStationReadyOrders(Station serviceStation, Calendar startDate, Calendar endDate) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		
		Set<Order> readyOrders = new HashSet<>();
		
		for (OrderEntity currentOrderEntity : stationEntity.getOrders().keySet())
			if (currentOrderEntity.getStatus().equals(OrderStatus.READY) &&
					currentOrderEntity.getCompleteDate().compareTo(startDate) >= 0 &&
					currentOrderEntity.getCompleteDate().compareTo(endDate) <= 0)
				readyOrders.add((Order) entityModelConverter.convert(currentOrderEntity, Order.class));
		
		return readyOrders;
	}

	@Override
	public Set<Order> getServiceStationOrders(Station serviceStation, Calendar startDate, Calendar endDate) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		
		Set<Order> orders = new HashSet<>();
		
		for (OrderEntity currentOrderEntity : stationEntity.getOrders().keySet())
			if (currentOrderEntity.getCompleteDate().compareTo(startDate) >= 0 &&
					currentOrderEntity.getCompleteDate().compareTo(endDate) <= 0)
				orders.add((Order) entityModelConverter.convert(currentOrderEntity, Order.class));
		
		return orders;
	}

	@Override
	public Set<Order> getAffiliateOrders(Affilate affiliate, Calendar startDate, Calendar endDate) {
		return stationAffilate.getAffiliateOrders(affiliate, startDate, endDate);
	}

	@Override
	public Set<Order> getAffiliateReadyOrders(Affilate affiliate, Calendar startDate, Calendar endDate) {
		return stationAffilate.getAffiliateReadyOrders(affiliate, startDate, endDate);
	}

	@Override
	public Map<Calendar, Integer> getAffilateRent(Affilate affilate, Calendar startDate, Calendar endDate) {
		Station station = identification.getStationByAffilate(affilate);
		StationEntity stationEntity = stationDao.findById(station.getStationId());
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		AffilateProfileEntity affilateProfileEntity = stationEntity.getAffilates().get(affilateEntity);
		
		Map<Calendar, Integer> rent = new TreeMap<>();
		
		for (Calendar currentDate : affilateProfileEntity.getRent().keySet())
			if (currentDate.compareTo(startDate) >= 0 &&
					currentDate.compareTo(endDate) <= 0)
				rent.put(currentDate, affilateProfileEntity.getRent().get(currentDate));
		
		return rent;
	}

	@Override
	public Map<Calendar, Integer> getEmployeeSalary(Person employee, Calendar startDate, Calendar endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
