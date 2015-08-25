package com.expositds.sjc.servicestation.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteUserEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Site;

/**
 * Реализует интерфейс AuthorizedUserSite.
 * 
 * @author Rybakov Sergey
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class AuthorizedUserSiteImpl extends SiteUserImpl implements AuthorizedUserSite{

	@Autowired
	private SiteUserDao siteUserDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private Site siteService;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public Map<Order, Station> getOrders(SiteUser user) {
		Map<OrderEntity, StationEntity> ordersEntity = siteUserDao.findById(user.getId()).getOrders();
		
		Map<Order, Station> ordersModel = new HashMap<>();
		
		for (OrderEntity currentOrderEntity : ordersEntity.keySet()) {
			Order currentOrder = (Order) conversionService.convert(currentOrderEntity, Order.class);
			StationEntity currentStationEntity = ordersEntity.get(currentOrderEntity);
			Station currentStation = conversionService.convert(currentStationEntity, Station.class);
			ordersModel.put(currentOrder, currentStation);
		}
		
		return ordersModel;
	}

	@Override
	public void createOrder(SiteUser user, String problemDescription, Station serviceStation) {
		
		Order order = siteService.createOrder(problemDescription, serviceStation);
		
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		SiteUserEntity siteUserEntity = siteUserDao.findById(user.getId());
		
		siteUserEntity.getOrders().put(orderEntity, stationEntity);
		siteUserDao.update(siteUserEntity);
	}

	@Override
	public void changeServiceStation(SiteUser user, Order order, Station newServiceStation) {
		siteService.changeServiceStation(order, newServiceStation);
		
		SiteUserEntity siteUserEntity = siteUserDao.findById(user.getId());
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		StationEntity newStationEntity = stationDao.findById(newServiceStation.getStationId());
		
		siteUserEntity.getOrders().put(orderEntity, newStationEntity);
		
		siteUserDao.update(siteUserEntity);
	}

	@Override
	public void publicServiceStationComment(Station serviceStation,
			Comment comment) {
		siteService.publicServiceStationComment(serviceStation, comment);
	}

	@Override
	public void publicMark(Station serviceStation, Mark mark) {
		siteService.publicMark(serviceStation, mark);
	}

	@Override
	public Mark createMark(SiteUser user, Integer markValue) {
		return siteService.createMark(user, markValue);
	}
	
	@Override
	public Comment createComment(SiteUser user, String comment, boolean visible) {
		return siteService.createComment(user, comment, visible);
	}

	@Override
	public void publicMechanicComment(Person mechanic, Comment comment) {
		siteService.publicMechanicComment(mechanic, comment);
	}

	@Override
	public Map<Order, Station> getOrdersLimit(SiteUser user, Integer first, Integer size) {
		
		Map<Order, Station> result = new HashMap<>();
		StationEntity currentStationEntity;
		
		List<OrderEntity> ordersEntity = orderDao.getOrdersStationLimit(user.getId(), new Long(first), new Long(size));
		
		for (OrderEntity currentOrderEntity : ordersEntity) {
			currentStationEntity = stationDao.getStationByOrderId(currentOrderEntity.getOrderId());
			
			result.put(
					conversionService.convert(currentOrderEntity, Order.class),
					conversionService.convert(currentStationEntity, Station.class)
			);
		}
				
		return result;
	}

}
