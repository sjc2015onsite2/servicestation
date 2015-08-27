package com.expositds.sjc.servicestation.business.service.dto.builders.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.dto.CustomerOrderDtoDao;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.service.dto.builders.CustomerOrderDtoBuilder;
import com.expositds.sjc.servicestation.domain.model.Order;

/**
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class CustomerOrderDtoBuilderImpl implements CustomerOrderDtoBuilder {

	@Autowired
	private CustomerOrderDtoDao customerOrderDtoDao;
	
	@Override
	public CustomerOrderDto build(Order order) {
		return customerOrderDtoDao.getCustomerOrderDtoByOrderId(order.getOrderId());
	}
		
		
}
