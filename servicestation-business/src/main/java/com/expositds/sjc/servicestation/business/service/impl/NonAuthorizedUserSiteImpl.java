package com.expositds.sjc.servicestation.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteAggregatorDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteAggregatorEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteUserEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.PreOrder;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.NonAuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.ServiceStation;

/**
 * Реализует интерфейс NonAuthorizedUserSite.
 * 
 * @author Alexey Suslov
 * @author Rybakov Sergey
 */
@Service
@Transactional
public class NonAuthorizedUserSiteImpl extends SiteUserImpl implements NonAuthorizedUserSite {
	
	@Autowired
	private SiteAggregatorDao siteAggregatorDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private SiteUserDao siteUserDao;
	
	@Autowired
	private ServiceStation serviceStationService;

	@Override
	public void createOrder(String contact, String problemDescription, Station serviceStation) {
		
		// генерируем PreOrdeder
		PreOrder preOrder = new PreOrder(problemDescription, contact);
		
		// отправляем PreOrder на ServiceStation
		Order order = serviceStationService.createOrder(serviceStation, preOrder);
		
		// по полученому от ServiceStation созданому Order воссоздаём OrderEntity
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		// воссоздаём SiteAggregatorEntity
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		
		// воссоздаём ServiceStationEntity
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		
		// помещаем orederEntity в коллекцию
		siteAggregatorEntity.getOrders().put(orderEntity, stationEntity);
		
		// сохраняемся
		siteAggregatorDao.update(siteAggregatorEntity);
	}
	
	@Override
	public void saveSiteUser(SiteUser siteUser) {
		SiteUserEntity siteUserEntity = new SiteUserEntity(siteUser.getName(), siteUser.getRole());
		siteUserEntity.setLogin(siteUser.getLogin());
		siteUserEntity.setPassword(siteUser.getPassword());
		siteUserEntity.setRole(siteUser.getRole());
		siteUserDao.save(siteUserEntity);
	}
	
}
