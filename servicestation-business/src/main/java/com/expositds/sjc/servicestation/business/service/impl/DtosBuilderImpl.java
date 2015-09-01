package com.expositds.sjc.servicestation.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.DtosDao;
import com.expositds.sjc.servicestation.business.repository.dto.CeoNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.MechanicNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.PartOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;
import com.expositds.sjc.servicestation.business.service.DtosBuilder;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;

/**
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class DtosBuilderImpl implements DtosBuilder {

	@Autowired
	private DtosDao dtosDao;
	
	@Override
	public CustomerOrderDto build(Order order) {
		return dtosDao.getCustomerOrderDtoByOrderId(order.getOrderId());
	}

	@Override
	public StationsDto build() {
		return dtosDao.getStationsDto();
	}

	@Override
	public List<MechanicNotificationDto> buildMechanicNotificationDto(Person mechanic) {
		return dtosDao.getMechanicNotificationDto(mechanic.getId());
	}

	@Override
	public List<CeoNotificationDto> buildCeoNotificationDto(Person ceo) {
		return dtosDao.getCeoNotificationDto(ceo.getId());
	}

	@Override
	public PartOrderDto build(PartOrder partOrder) {
		return dtosDao.getPartOrderDto(partOrder.getPartOrderId());
	}
		
		
}
