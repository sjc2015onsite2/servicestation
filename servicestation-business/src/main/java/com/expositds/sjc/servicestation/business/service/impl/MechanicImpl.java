package com.expositds.sjc.servicestation.business.service.impl;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.ClientNotificationDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartDao;
import com.expositds.sjc.servicestation.business.repository.dao.ServiceDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ClientNotificationEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.domain.exception.PartLimitException;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;
import com.expositds.sjc.servicestation.domain.service.WorkShop;

/**
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class MechanicImpl extends StoreKeeperImpl implements Mechanic {
	
	final static Logger logger = Logger.getLogger(MechanicImpl.class);
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private ClientNotificationDao clientNotificationDao;
	
	@Autowired
	private WorkShop workShopService;
	
	@Autowired
	private Identification identification;
	
	@Override
	public Set<Order> getMechanicOrders(Person mechanic) {
		return workShopService.getMechanicOrders(mechanic);
	}

	@Override
	public void setOrderStatus(Order order, OrderStatus orderStatus) {
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		orderEntity.setStatus(orderStatus);
		orderDao.update(orderEntity);
	}

	@Override
	public void setOrderCompletionDate(Order order, Calendar orderCopmleteDate) {
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		orderEntity.setCompleteDate(orderCopmleteDate);
		orderDao.update(orderEntity);
	}

	@Override
	public Map<Part, Integer> getPartsQuantity(Affilate affilate) {
		return workShopService.getPartsQuantity(affilate);
	}

	@Override
	public Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> getServicesCost(Affilate affilate) {
		return workShopService.getServicesCost(affilate);
	}

	@Override
	public PartOrder createPartOrder(Person mechanic) {
		return workShopService.createPartOrder(mechanic);
	}

	@Override
	public void createClientNotification(Order order, String notification) {
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		ClientNotificationEntity clientNotificationEntity = new ClientNotificationEntity(notification);
		orderEntity.setNotification(clientNotificationEntity);
		
		clientNotificationDao.save(clientNotificationEntity);
		orderDao.update(orderEntity);
	}

	@Override
	public void addPartsToOrder(Order order, Map<Part, Integer> parts) throws PartLimitException {
		
		Affilate affilate = identification.getAffilateByOrder(order);
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		
		for (Part currentPart : parts.keySet()) {
			PartEntity currentPartEntity = partDao.findById(currentPart.getPartId());
			
			if (affilateEntity.getParts().get(currentPartEntity) - parts.get(currentPart) < 0) {
				PartLimitException ex = new PartLimitException();
				logger.error("Part limit", ex);
				throw new PartLimitException();
			}
				
			if (orderEntity.getParts().containsKey(currentPartEntity)) 
				orderEntity.getParts().put(currentPartEntity, orderEntity.getParts().get(currentPartEntity) + parts.get(currentPart));
			else orderEntity.getParts().put(currentPartEntity, parts.get(currentPart));
			
			
			affilateEntity.getParts().put(currentPartEntity, affilateEntity.getParts().get(currentPartEntity) - parts.get(currentPart));
		}
		
		orderDao.update(orderEntity);
		affilateDao.update(affilateEntity);
		
	}

	@Override
	public void addServicesPriceListToOrder(Order order, Set<com.expositds.sjc.servicestation.domain.model.Service> servicesPriceList) {
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		Affilate affilate = identification.getAffilateByOrder(order);
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		
		for (com.expositds.sjc.servicestation.domain.model.Service currentService : servicesPriceList) {
			ServiceEntity currentServiceEntity = serviceDao.findById(currentService.getServiceId());
			orderEntity.getOrderServicesPriceList().put(serviceDao.findById(currentService.getServiceId()), affilateEntity.getServices().get(currentServiceEntity));
		}	
		orderDao.update(orderEntity);
	}

	@Override
	public void addServicesToOrder(Order order, Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> services) {
		
		addServicesPriceListToOrder(order, services.keySet());
		
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		for (com.expositds.sjc.servicestation.domain.model.Service currentService : services.keySet()) 
			if (orderEntity.getServices().containsKey(serviceDao.findById(currentService.getServiceId())))
				orderEntity.getServices().put(serviceDao.findById(currentService.getServiceId()), order.getServices().get(currentService) + services.get(currentService));
			else orderEntity.getServices().put(serviceDao.findById(currentService.getServiceId()), services.get(currentService));
		
			
		
		orderDao.update(orderEntity);
	}

	@Override
	public void giveOrder(Person mechanic, Order order) {
		workShopService.giveOrder(mechanic, order);
		
	}

	@Override
	public Set<Order> getMechanicFreeOrders(Person mechanic) {
		return workShopService.getMechanicFreeOrders(mechanic);
	}

	@Override
	public void addPartsToPartOrder(PartOrder partOrder, Map<Part, Integer> parts) {
		workShopService.addPartsToPartOrder(partOrder, parts);
		
	}

}
