package com.expositds.sjc.servicestation.business.repository.dao.dto;

import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;

/**
 * Интерфейс для работы с CustomerOrderDto.
 * 
 * @author Alexey Suslov
 *
 */
public interface CustomerOrderDtoDao {
	
	public CustomerOrderDto getCustomerOrderDtoByOrderId(Long Id);

}
