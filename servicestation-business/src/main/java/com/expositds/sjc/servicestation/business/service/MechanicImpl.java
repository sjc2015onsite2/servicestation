package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.ClientNotificationDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.entity.ClientNotificationEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.tools.ModelEntityConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.Mechanic;
import com.expositds.sjc.servicestation.domain.service.WorkShop;

/**
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class MechanicImpl extends StoreKeeperImpl implements Mechanic {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ClientNotificationDao clientNotificationDao;
	
	@Autowired
	private WorkShop workShopService;
	
	@Autowired
	private ModelEntityConverter modelEntityConverterTool;
	
	@Override
	public Set<Order> getMechanicOrders(Affilate affilate, Person mechanic) {
		return workShopService.getMechanicOrders(affilate, mechanic);
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
	public void createPartOrder(Person mechanic, Map<Part, Integer> parts) {
		workShopService.createPartOrder(mechanic, parts);
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
	public void addPartsToOrder(Order order, Map<Part, Integer> parts) {
		
		for (Part currentPart : parts.keySet()) {
			if (order.getParts().containsKey(currentPart)) 
				order.getParts().put(currentPart, order.getParts().get(currentPart) + parts.get(currentPart));
			else order.getParts().put(currentPart, parts.get(currentPart));
		}
		
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		orderEntity.setParts(modelEntityConverterTool.mapPartIntegerConvert(parts));
		
		orderDao.update(orderEntity);
		
	}

	@Override
	public void addServicesPriceListToOrder(Order order, Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> servicesPriceList) {
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		orderEntity.getOrderServicesPriceList().
			putAll(modelEntityConverterTool.mapServiceIntegerConverter(servicesPriceList));
		
		orderDao.update(orderEntity);
	
	}

	@Override
	public void addServicesToOrder(Order order, Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> services) {
		
		for (com.expositds.sjc.servicestation.domain.model.Service currentService : services.keySet()) 
			for (int i = 0; i < services.get(currentService); i++) 
				order.getServices().add(currentService);
		
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		orderEntity.setServices(modelEntityConverterTool.listServiceConverter(order.getServices()));
		
		orderDao.update(orderEntity);
	}

}
