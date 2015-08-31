package com.expositds.sjc.servicestation.business.service.impl;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.CommentDao;
import com.expositds.sjc.servicestation.business.repository.dao.MarkDao;
import com.expositds.sjc.servicestation.business.repository.dao.MechanicProfileDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteAggregatorDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationProfileDao;
import com.expositds.sjc.servicestation.business.repository.entity.CommentEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MarkEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MechanicProfileEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteAggregatorEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteUserEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationProfileEntity;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.PreOrder;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.ServiceStation;
import com.expositds.sjc.servicestation.domain.service.Site;

@Service
public class SiteImpl implements Site {
	
	@Autowired
	private ServiceStation serviceStationService;
	
	@Autowired
	private SiteAggregatorDao siteAggregatorDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private StationProfileDao stationProfileDao;
	
	@Autowired
	private SiteUserDao siteUserDao;
	
	@Autowired
	private MarkDao markDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private MechanicProfileDao mechanicProfileDao;
	
	@Autowired
	private ConversionService conversionService;

	@Override
	public Order createOrder(String problemDescription, Station serviceStation) {
		PreOrder preOrder = new PreOrder(problemDescription);
		Order order = serviceStationService.createOrder(serviceStation, preOrder);
		
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		siteAggregatorEntity.getOrders().put(orderEntity, stationEntity);
		siteAggregatorDao.update(siteAggregatorEntity);
		return order;
	}

	@Override
	public void changeServiceStation(Order order, Station newServiceStation) {
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		Station oldStation = conversionService.convert(siteAggregatorEntity.getOrders().get(orderEntity), Station.class);
		
		serviceStationService.deleteOrder(oldStation, order);
		serviceStationService.takeOrder(newServiceStation, order);
		
		StationEntity newStationEntity = stationDao.findById(newServiceStation.getStationId());
		siteAggregatorEntity.getOrders().put(orderEntity, newStationEntity);
		
		siteAggregatorDao.update(siteAggregatorEntity);

	}

	@Override
	public void publicServiceStationComment(Station serviceStation, Comment comment) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		CommentEntity commentEntity = commentDao.findById(comment.getCommentId());
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		
		StationProfileEntity stationProfileEntity = siteAggregatorEntity.getStationProfiles().get(stationEntity);
		stationProfileEntity.getComments().add(commentEntity);
		
		stationProfileDao.update(stationProfileEntity);
	}

	@Override
	public void publicMechanicComment(Person mechanic, Comment comment) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		CommentEntity commentEntity = commentDao.findById(comment.getCommentId());
		PersonEntity mechanicEntity = personDao.findById(mechanic.getId());
		
		MechanicProfileEntity mechanicProfileEntity = siteAggregatorEntity.getMechanicPofiles().get(mechanicEntity);
		mechanicProfileEntity.getComments().add(commentEntity);
		
		mechanicProfileDao.update(mechanicProfileEntity);
	}

	@Override
	public Mark createMark(SiteUser user, Integer markValue) {
		SiteUserEntity siteUserEntity = siteUserDao.findById(user.getId());
		MarkEntity markEntity = new MarkEntity(markValue, siteUserEntity);
		markEntity.setDate(new GregorianCalendar());
		markEntity.setMarkId(markDao.save(markEntity));
		
		Mark mark = conversionService.convert(markEntity, Mark.class);
		return mark;
	}

	@Override
	public Comment createComment(SiteUser user, String commentString, boolean visible) {
		SiteUserEntity siteUserEntity = siteUserDao.findById(user.getId());
		CommentEntity commentEntity = new CommentEntity(commentString, siteUserEntity, visible);
		commentEntity.setDate(new GregorianCalendar());
		commentEntity.setCommentId(commentDao.save(commentEntity));
		
		Comment comment = conversionService.convert(commentEntity, Comment.class);
		return comment;
	}

	@Override
	public void publicMark(Station station, Mark mark) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		MarkEntity markEntity = markDao.findById(mark.getMarkId());
		StationEntity stationEntity = stationDao.findById(station.getStationId());
		
		StationProfileEntity stationProfileEntity = siteAggregatorEntity.getStationProfiles().get(stationEntity);
		stationProfileEntity.getMarks().add(markEntity);
		
		stationProfileDao.update(stationProfileEntity);
	}

}
