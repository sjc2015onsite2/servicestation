package com.expositds.sjc.servicestation.business.service;

import java.util.List;

import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.MechanicNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;

/**
 * Инерфейс содержит методы для создания dto.
 * 
 * @author Alexey Suslov
 *
 */
public interface DtosBuilder {
	
	public CustomerOrderDto build(Order order);
	
	public StationsDto build();
	
	public List<MechanicNotificationDto> build(Person mechanic);
	
}
