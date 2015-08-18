package com.expositds.sjc.servicestation.business.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.tools.EntityModelConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.HeadOffice;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class HeadOfficeImpl implements HeadOffice {
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private EntityModelConverter entityModelConverterTool;

	@Override
	public void giveOrder(Station serviceStation, Affilate affilate, Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Order> getNewOrders(Station serviceStation) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		Set<Order> orders = new HashSet<>();
		
		for (OrderEntity currentOrderEntity : stationEntity.getOrders().keySet())
			if (stationEntity.getOrders().get(currentOrderEntity).getAffilateId() == 1)
				orders.add((Order) entityModelConverterTool.convert(currentOrderEntity, Order.class));
		
		return orders;
	}

}
