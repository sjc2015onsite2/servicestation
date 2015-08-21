package com.expositds.sjc.servicestation.business.service;

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
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.HeadOffice;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class HeadOfficeImpl implements HeadOffice {
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ConversionService conversionService;
	
	@Autowired
	private Identification identificationService;

	@Override
	public void giveOrder(Affilate affilate, Order order) {
		Station station = identificationService.getStationByAffilate(affilate);
		
		StationEntity stationEntity = stationDao.findById(station.getStationId());
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		stationEntity.getOrders().put(orderEntity, affilateEntity);
		
		stationDao.update(stationEntity);

	}

	@Override
	public Set<Order> getNewOrders(Station serviceStation) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		Set<Order> orders = new HashSet<>();
		
		for (OrderEntity currentOrderEntity : stationEntity.getOrders().keySet())
			if (stationEntity.getOrders().get(currentOrderEntity).getAffilateId() == 1)
				orders.add(conversionService.convert(currentOrderEntity, Order.class));
		
		return orders;
	}

}
