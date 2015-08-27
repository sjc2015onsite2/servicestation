package com.expositds.sjc.servicestation.business.service.dto.builders;

import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.domain.model.Order;

/**
 * Инерфейс содержит методы для создания dto.
 * 
 * @author Alexey Suslov
 *
 */
public interface CustomerOrderDtoBuilder {
	
	public CustomerOrderDto build(Order order);
	
}
