package com.expositds.sjc.servicestation.business.service;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.tools.BasicEntityModelObjectConverter;
import com.expositds.sjc.servicestation.domain.model.LogginerRole;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.PreOrder;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.ServiceStation;;

@Service
@Transactional
public class ServiceStationImpl implements ServiceStation{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private BasicEntityModelObjectConverter basicEntityModelObjectConverter;
	
	@Override
	public Order createOrder(Station serviceStation, PreOrder preOrder) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCreateDate(new GregorianCalendar());
		orderEntity.setProblemDescription(preOrder.getProblemDescription());
		orderEntity.setContactData(preOrder.getContactData());
		orderEntity.setStatus(OrderStatus.NEW);
		orderEntity.setOrderId(orderDao.save(orderEntity));
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		stationEntity.getOrders().put(orderEntity, null);
		Order order = (Order) basicEntityModelObjectConverter.convert(orderEntity, Order.class);
		stationDao.update(stationEntity);
		return order;
	}

	@Override
	public void deleteOrder(Station serviceStation, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void takeOrder(Station serviceStation, Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Person> getMechanics(Station station) {
		StationEntity stationEntity = (StationEntity) stationDao.findById(station.getStationId());
		Set<PersonEntity> personsEntiry = stationEntity.getPersons();
		Set<Person> mechanics = new HashSet<>();
		for (PersonEntity currentPersonEntity : personsEntiry) {
			if (currentPersonEntity.getRole() == LogginerRole.MECHANIC) 
				mechanics.add((Person) basicEntityModelObjectConverter.convert(currentPersonEntity, Person.class));
		}
		return mechanics;
	}

}

