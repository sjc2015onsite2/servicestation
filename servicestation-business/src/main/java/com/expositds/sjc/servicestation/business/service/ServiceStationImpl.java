package com.expositds.sjc.servicestation.business.service;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.LogginerRole;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.PreOrder;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.ServiceStation;
import com.expositds.sjc.servicestation.domain.service.StationAffilate;;

@Service
public class ServiceStationImpl implements ServiceStation{

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private StationAffilate stationAffilateService;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public Order createOrder(Station serviceStation, PreOrder preOrder) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCreateDate(new GregorianCalendar());
		orderEntity.setProblemDescription(preOrder.getProblemDescription());
		orderEntity.setContactData(preOrder.getContactData());
		orderEntity.setStatus(OrderStatus.NEW);
		orderEntity.setOrderId(orderDao.save(orderEntity));
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		AffilateEntity nullAffilateEntity = affilateDao.findById(1L);
		stationEntity.getOrders().put(orderEntity, nullAffilateEntity);
		Order order = (Order) conversionService.convert(orderEntity, Order.class);
		stationDao.update(stationEntity);
		return order;
	}

	@Override
	public void deleteOrder(Station serviceStation, Order order) {
		
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		AffilateEntity affilateEntity = stationEntity.getOrders().get(orderEntity);	
		Affilate affilate = (Affilate) conversionService.convert(affilateEntity, Affilate.class);
		stationAffilateService.deleteOrder(affilate, order);
		
		orderEntity.setCompleteDate(null);
		orderEntity.setCreateDate(new GregorianCalendar());
		orderEntity.setNotification(null);
		orderEntity.getParts().clear();
		orderEntity.getServices().clear();
		orderEntity.getOrderServicesPriceList().clear();
		orderEntity.setStatus(OrderStatus.NEW);
		orderDao.update(orderEntity);
		
		stationEntity.getOrders().remove(orderEntity);
		stationDao.update(stationEntity);
		
	}

	@Override
	public void takeOrder(Station serviceStation, Order order) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		AffilateEntity nullAffilate = affilateDao.findById(1L);
		
		stationEntity.getOrders().put(orderEntity, nullAffilate);
		stationDao.update(stationEntity);
	}

	@Override
	public Set<Person> getMechanics(Station station) {
		StationEntity stationEntity = (StationEntity) stationDao.findById(station.getStationId());
		Set<PersonEntity> personsEntiry = stationEntity.getPersons();
		Set<Person> mechanics = new HashSet<>();
		for (PersonEntity currentPersonEntity : personsEntiry) {
			if (currentPersonEntity.getRole().equals(LogginerRole.MECHANIC)) 
				mechanics.add((Person) conversionService.convert(currentPersonEntity, Person.class));
		}
		return mechanics;
	}

}

