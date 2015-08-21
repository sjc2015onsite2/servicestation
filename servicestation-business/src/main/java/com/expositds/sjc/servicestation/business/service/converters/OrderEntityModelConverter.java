package com.expositds.sjc.servicestation.business.service.converters;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.domain.model.ClientNotification;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Service;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class OrderEntityModelConverter implements Converter<OrderEntity, Order> {
	
	private PartEntityModelConverter partEntityModelConverter = new PartEntityModelConverter();
	
	private ServiceEntityModelConverter serviceEntityModelConverter = new ServiceEntityModelConverter();

	@Override
	public Order convert(OrderEntity source) {
		Order order = new Order();
		
		order.setOrderId(source.getOrderId());
		
		order.setClientOrderId(source.getClientOrderId());
		
		order.setCreateDate(source.getCreateDate());
		
		order.setCompleteDate(source.getCompleteDate());
		
		order.setContactData(source.getContactData());
		
		if (source.getNotification() != null) {
			ClientNotification clientNotification = new ClientNotification(source.getNotification().getMessage());
			clientNotification.setClientNotificationId(source.getNotification().getClientNotificationId());
			order.setNotification(clientNotification);
		}			
		
		order.setProblemDescription(source.getProblemDescription());
		
		order.setStatus(source.getStatus());
		
		order.setOrderServicesPriceList(new HashMap<Service, Integer>());
		for (ServiceEntity currentServiceEntity : source.getOrderServicesPriceList().keySet()) {
			Service currentService = serviceEntityModelConverter.convert(currentServiceEntity);
			Integer currentCost = source.getOrderServicesPriceList().get(currentServiceEntity);
			order.getOrderServicesPriceList().put(currentService, currentCost);
		}
		
		order.setParts(new HashMap<Part, Integer>());
		for (PartEntity currentPartEntity : source.getParts().keySet()) {
			Part currentPart = partEntityModelConverter.convert(currentPartEntity);
			Integer currentCount = source.getParts().get(currentPartEntity);
			order.getParts().put(currentPart, currentCount);
		}
		
		order.setServices(new ArrayList<Service>());
		for (ServiceEntity currentServiceEntity : source.getServices()) {
			Service currentService = serviceEntityModelConverter.convert(currentServiceEntity);
			order.getServices().add(currentService);
		}
		
		return order;
	}

}
