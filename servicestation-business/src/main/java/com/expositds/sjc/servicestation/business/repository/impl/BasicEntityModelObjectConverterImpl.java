package com.expositds.sjc.servicestation.business.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateProfileEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ClientNotificationEntity;
import com.expositds.sjc.servicestation.business.repository.entity.CommentEntity;
import com.expositds.sjc.servicestation.business.repository.entity.CredentialEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MarkEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MechanicProfileEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderStatus;
import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartOrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartOrderStatus;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteAggregatorEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteUserEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationProfileEntity;
import com.expositds.sjc.servicestation.business.repository.tools.BasicEntityModelObjectConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.AffilateProfile;
import com.expositds.sjc.servicestation.domain.model.ClientNotification;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Credential;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.MechanicProfile;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.SiteAggregator;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.model.StationProfile;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class BasicEntityModelObjectConverterImpl implements BasicEntityModelObjectConverter {

	@Override
	public Object convert(Object entity, Class<?> clazz) {
		
		if (clazz == Affilate.class) {
			AffilateEntity affilateEntity = (AffilateEntity) entity;
			Affilate affilate = new Affilate(affilateEntity.getAffilateCode());
			affilate.setAffilateId(affilateEntity.getAffilateId());
			return affilate;
		}
		
		if (clazz == AffilateProfile.class) {
			AffilateProfileEntity affialteProfileEntity = (AffilateProfileEntity) entity;
			AffilateProfile affialteProfile = new AffilateProfile();
			affialteProfile.setAffilateProfileId(affialteProfileEntity.getAffilateProfileId());
			return affialteProfile;
		}
		
		if (clazz == ClientNotification.class) {
			ClientNotificationEntity clientNotificationEntity = (ClientNotificationEntity) entity;
			ClientNotification clientNotification = new ClientNotification(clientNotificationEntity.getMessage());
			clientNotification.setClientNotificationId(clientNotificationEntity.getClientNotificationId());
			return clientNotification;
		}
		
		if (clazz == Comment.class) {
			CommentEntity commentEntity = (CommentEntity) entity;
			SiteUser siteUser = new SiteUser(commentEntity.getAuthor().getName());
			siteUser.setSiteUserId(commentEntity.getAuthor().getSiteUserId());
			Comment comment = new Comment(commentEntity.getComment(), siteUser, commentEntity.isVisible());
			comment.setCommentId(commentEntity.getCommentId());
			comment.setDate(commentEntity.getDate());
			return comment;
		}
		
		if (clazz == Credential.class) {
			CredentialEntity credentialEntity = (CredentialEntity) entity;
			Credential credential = new Credential(credentialEntity.getLogin(), credentialEntity.getPassword());
			credential.setCredentialId(credentialEntity.getCredentialId());
			return credential;
		}
		
		if (clazz == Mark.class) {
			MarkEntity markEntity = (MarkEntity) entity;
			SiteUser siteUser = new SiteUser(markEntity.getAuthor().getName());
			siteUser.setSiteUserId(markEntity.getAuthor().getSiteUserId());
			Mark mark = new Mark(markEntity.getMark(), siteUser);
			mark.setMarkId(markEntity.getMarkId());
			mark.setDate(markEntity.getDate());
			return mark;
		}
		
		if (clazz == MechanicProfile.class) {
			MechanicProfileEntity mechanicProfileEntity = (MechanicProfileEntity) entity;
			MechanicProfile mechanicProfile = new MechanicProfile();
			mechanicProfile.setMechanicPofileId(mechanicProfileEntity.getMechanicPofileId());
			return mechanicProfile;
		}
		
		if (clazz == Order.class) {
			OrderEntity orderEntity = (OrderEntity) entity;
			
			Order order = new Order();
			
			order.setOrderId(orderEntity.getOrderId());
			
			order.setClientOrderId(orderEntity.getClientOrderId());
			
			order.setCreateDate(orderEntity.getCreateDate());
			
			order.setCompleteDate(orderEntity.getCompleteDate());
			
			order.setContactData(orderEntity.getContactData());
			
			if (orderEntity.getNotification() != null) {
				ClientNotification clientNotification = new ClientNotification(orderEntity.getNotification().getMessage());
				clientNotification.setClientNotificationId(orderEntity.getNotification().getClientNotificationId());
				order.setNotification(clientNotification);
			}			
			
			order.setProblemDescription(orderEntity.getProblemDescription());
			
			order.setStatus(getModelOrderStaus(orderEntity.getStatus()));
			
			order.setOrderServicesPriceList(new HashMap<Service, Integer>());
			for (ServiceEntity currentServiceEntity : orderEntity.getOrderServicesPriceList().keySet()) {
				Service currentService = (Service) convert(currentServiceEntity, Service.class);
				Integer currentCost = orderEntity.getOrderServicesPriceList().get(currentServiceEntity);
				order.getOrderServicesPriceList().put(currentService, currentCost);
			}
			
			order.setParts(new HashMap<Part, Integer>());
			for (PartEntity currentPartEntity : orderEntity.getParts().keySet()) {
				Part currentPart = (Part) convert(currentPartEntity, Part.class);
				Integer currentCount = orderEntity.getParts().get(currentPartEntity);
				order.getParts().put(currentPart, currentCount);
			}
			
			order.setServices(new ArrayList<Service>());
			for (ServiceEntity currentServiceEntity : orderEntity.getServices()) {
				Service currentService = (Service) convert(currentServiceEntity, Service.class);
				order.getServices().add(currentService);
			}
			
			return order;
		}
		
		if (clazz == Part.class) {
			PartEntity partEntity = (PartEntity) entity;
			Part part = new Part(partEntity.getArticle(), partEntity.getName());
			part.setPartId(partEntity.getPartId());
			return part;
		}
		
		if (clazz == PartOrder.class) {
			PartOrderEntity partOrderEntity = (PartOrderEntity) entity;
			PartOrder partOrder = new PartOrder();
			partOrder.setPartOrderId(partOrderEntity.getPartOrderId());
			partOrder.setClientPartOrderId(partOrderEntity.getClientPartOrderId());
			partOrder.setDate(partOrderEntity.getDate());
			partOrder.setStatus(getModelPartOrderStatus(partOrderEntity.getStatus()));
			partOrder.setParts(new HashMap<Part, Integer>());
			for (PartEntity currentPartEntity : partOrderEntity.getParts().keySet()) {
				Part currentPart = (Part) convert(currentPartEntity, Part.class);
				Integer currentCount = partOrderEntity.getParts().get(currentPartEntity);
				partOrder.getParts().put(currentPart, currentCount);
			}
			return partOrder;
		}
		
		if (clazz == Person.class) {
			PersonEntity personEntity = (PersonEntity) entity;
			Person person = new Person(personEntity.getName());
			person.setPersonId(personEntity.getPersonId());
			return person;
		}
		
		if (clazz == Service.class) {
			ServiceEntity serviceEntity = (ServiceEntity) entity;
			Service service = new Service(serviceEntity.getArticle(), serviceEntity.getName());
			service.setServiceId(serviceEntity.getServiceId());
			return service;
		}
		
		if (clazz == SiteAggregator.class) {
			SiteAggregatorEntity siteAggregatorEntity = (SiteAggregatorEntity) entity;
			SiteAggregator siteAggregator = new SiteAggregator();
			siteAggregator.setSiteAggregatorId(siteAggregatorEntity.getSiteAggregatorId());
			return siteAggregator;
		}
		
		if (clazz == SiteUser.class) {
			SiteUserEntity siteUserEntity = (SiteUserEntity) entity;
			SiteUser siteUser = new SiteUser(siteUserEntity.getName());
			siteUser.setSiteUserId(siteUserEntity.getSiteUserId());
			return siteUser;
		}
		
		if (clazz == Station.class) {
			StationEntity stationEntity = (StationEntity) entity;
			Station station = new Station(stationEntity.getName(), stationEntity.getPersonStationId());
			station.setStationId(stationEntity.getStationId());
			return station;
		}
		
		if (clazz == StationProfile.class) {
			StationProfileEntity stationProfileEntity = (StationProfileEntity) entity;
			StationProfile stationProfile = new StationProfile();
			stationProfile.setStationProfileId(stationProfileEntity.getStationProfileId());
			return stationProfile;
		}
		
		return null;
	}
	
	private com.expositds.sjc.servicestation.domain.model.OrderStatus getModelOrderStaus(OrderStatus orderStatusEntity) {
		switch (orderStatusEntity) {
			case NEW : return com.expositds.sjc.servicestation.domain.model.OrderStatus.NEW;
			case ACCEPTED : return com.expositds.sjc.servicestation.domain.model.OrderStatus.ACCEPTED;
			case PENDING : return com.expositds.sjc.servicestation.domain.model.OrderStatus.PENDING;
			case READY : return com.expositds.sjc.servicestation.domain.model.OrderStatus.READY;
		}
		return null;
	}
	
	private com.expositds.sjc.servicestation.domain.model.PartOrderStatus getModelPartOrderStatus(PartOrderStatus partOrderStatusEntity) {
		switch (partOrderStatusEntity) {
			case PENDING : return com.expositds.sjc.servicestation.domain.model.PartOrderStatus.PENDING;
			case READY : return com.expositds.sjc.servicestation.domain.model.PartOrderStatus.READY;
		}
		return null;
	};
		
	
	
	
}
