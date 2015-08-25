package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.LogginerRole;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.FinanceDepartment;
import com.expositds.sjc.servicestation.domain.service.Reportable;

/**
 * @author Alexey Suslov
 *
 */
@Transactional
public abstract class ReportableImpl implements Reportable {
	
	@Autowired
	private FinanceDepartment financeDepartment;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private ConversionService conversionService;

	@Override
	public Integer getServiceStationProfit(Station seviceStation, Calendar startDate, Calendar endDate) {
		Set<Order> readyOrders = financeDepartment.getServiceStationReadyOrders(seviceStation, startDate, endDate);
		
		Integer profit = 0;
		
		for (Order currentOrder : readyOrders) 
			for (Service currentService : currentOrder.getServices().keySet()) 
				profit += (currentOrder.getOrderServicesPriceList().get(currentService) * 
						currentOrder.getServices().get(currentService));
		
		return profit;
	}

	@Override
	public Integer getAffilateProfit(Affilate affilate, Calendar startDate, Calendar endDate) {
		Set<Order> readyOrders = financeDepartment.getAffiliateReadyOrders(affilate, startDate, endDate);
		
		Integer profit = 0;
		
		for (Order currentOrder : readyOrders) 
			for (Service currentService : currentOrder.getServices().keySet()) 
				profit += (currentOrder.getOrderServicesPriceList().get(currentService) * 
						currentOrder.getServices().get(currentService));
		
		return profit;
	}

	@Override
	public Integer getAffilateRent(Affilate affilate, Calendar startDate, Calendar endDate) {
		Map<Calendar, Integer> dateRent = financeDepartment.getAffilateRent(affilate, startDate, endDate);
		
		Integer rent = 0;
		
		for (Calendar currentDate : dateRent.keySet())
			rent += dateRent.get(currentDate);
		
		return rent;
	}

	@Override
	public Integer getServiceStationRent(Station serviceStation, Calendar startDate, Calendar endDate) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		
		Integer rent = 0;
		
		for (AffilateEntity currentAffilateEntity : stationEntity.getAffilates().keySet())
			rent += getAffilateRent(
					conversionService.convert(currentAffilateEntity, Affilate.class), 
					startDate, 
					endDate);
		
		return rent;
	}

	@Override
	public Integer getMechanicsSalary(Station serviceStation, Calendar startDate, Calendar endDate) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		
		Integer salary = 0;
		
		for (PersonEntity currentEmployeeEntity : stationEntity.getPersons())
			if (currentEmployeeEntity.getRole().equals(LogginerRole.MECHANIC)) {
				Map<Calendar, Integer> mechanicSalary = 
						financeDepartment.getEmployeeSalary(
								conversionService.convert(currentEmployeeEntity, Person.class), 
								startDate, 
								endDate);
				for (Calendar currentDate : mechanicSalary.keySet())
					salary += mechanicSalary.get(currentDate);
			}
				
		return salary;
	}

	@Override
	public Integer getServiceStationCharges(Station serviceStation, Calendar startDate, Calendar endDate) {
		
		Integer charges = 0;
		
		charges += getServiceStationRent(serviceStation, startDate, endDate);
		
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		for (PersonEntity currentEmployeeEntity : stationEntity.getPersons()) {
			Map<Calendar, Integer> employeeSalary = 
					financeDepartment.getEmployeeSalary(
							conversionService.convert(currentEmployeeEntity, Person.class), 
							startDate, 
							endDate);
			for (Calendar currentDate : employeeSalary.keySet())
				charges += employeeSalary.get(currentDate);
		}
		
		return charges;
	}

	@Override
	public Set<Order> getServiceStationOrders(Station serviceStation, Calendar startDate, Calendar endDate) {
		return financeDepartment.getServiceStationOrders(serviceStation, startDate, endDate);
	}
	
	@Override
	public Set<Person> getServiceStationEmloyees(Station station) {
		StationEntity stationEntity = stationDao.findById(station.getStationId());
		
		Set<Person> result = new HashSet<>();
		
		for (PersonEntity currentPersonEntity : stationEntity.getPersons())
			result.add(conversionService.convert(currentPersonEntity, Person.class));
		
		return result;
	}

}
