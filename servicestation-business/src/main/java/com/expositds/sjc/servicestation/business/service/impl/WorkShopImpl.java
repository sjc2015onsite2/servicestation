package com.expositds.sjc.servicestation.business.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartOrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartOrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.HeadOffice;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.WorkShop;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class WorkShopImpl extends StorageImpl implements WorkShop {
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private PartOrderDao partOrderDao;
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private HeadOffice headOfficeService;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public Set<Order> getMechanicOrders(Person mechanic) {
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		PersonEntity mechanicEntity = personDao.findById(mechanic.getId());
		
		Map<OrderEntity, PersonEntity> affilateOrdersEntity = affilateEntity.getOrders();
		
		Set<Order> orders = new HashSet<>();
		
		for (OrderEntity currentOrderEntity : affilateOrdersEntity.keySet()) {
			if (affilateOrdersEntity.get(currentOrderEntity).equals(mechanicEntity))
				orders.add(conversionService.convert(currentOrderEntity, Order.class));
		}
		
		return orders;
	}

	@Override
	public Map<Part, Integer> getPartsQuantity(Affilate affilate) {
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		Map<Part, Integer> parts = new HashMap<>();
		
		for (PartEntity currentPartEntity : affilateEntity.getParts().keySet())
			parts.put(conversionService.convert(currentPartEntity, Part.class), affilateEntity.getParts().get(currentPartEntity));
	
		return parts;
	}

	@Override
	public Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> getServicesCost(Affilate affilate) {
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> services = new HashMap<>();
		
		for (ServiceEntity currentServiceEntity : affilateEntity.getServices().keySet()) {
			
			com.expositds.sjc.servicestation.domain.model.Service service = 
					conversionService.convert(currentServiceEntity, 
						com.expositds.sjc.servicestation.domain.model.Service.class);
			
			services.put(service, affilateEntity.getParts().get(currentServiceEntity));
		}
		return services;
	}

	@Override
	public void giveOrder(Person mechanic, Order order) {
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		PersonEntity mechanicEntity = personDao.findById(mechanic.getId());
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		orderEntity.setStatus(OrderStatus.ACCEPTED);
		
		affilateEntity.getOrders().put(orderEntity, mechanicEntity);
		
		headOfficeService.giveOrder(affilate, order);
		
		affilateDao.update(affilateEntity);

	}

	@Override
	public PartOrder createPartOrder(Person mechanic) {
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		PersonEntity mechanicEnity = personDao.findById(mechanic.getId());
		
		PartOrderEntity partOrderEntity = new PartOrderEntity();
		affilateEntity.getPartOrders().put(partOrderEntity, mechanicEnity);
		
		partOrderEntity.setPartOrderId(partOrderDao.save(partOrderEntity));
		affilateDao.update(affilateEntity);
		return conversionService.convert(partOrderEntity, PartOrder.class);
		
	}

	@Override
	public Set<Order> getMechanicFreeOrders(Person mechanic) {
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		Station station = identificationService.getStationByAffilate(affilate);
		
		return headOfficeService.getNewOrders(station);
	}

	@Override
	public void addPartsToPartOrder(PartOrder partOrder, Map<Part, Integer> parts) {
		PartOrderEntity partOrderEntity = partOrderDao.findById(partOrder.getPartOrderId());
		
		for (Part currentPart : parts.keySet()) 
			partOrderEntity.getParts().put(partDao.findById(currentPart.getPartId()), parts.get(currentPart));
		
		partOrderDao.save(partOrderEntity);
		
	}

}
