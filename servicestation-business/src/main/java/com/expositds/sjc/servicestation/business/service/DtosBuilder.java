package com.expositds.sjc.servicestation.business.service;

import java.util.List;

import com.expositds.sjc.servicestation.business.repository.dto.CeoNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.MechanicNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.PartOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
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
	
	public List<MechanicNotificationDto> buildMechanicNotificationDto(Person mechanic);
	
	public List<CeoNotificationDto> buildCeoNotificationDto(Person ceo);
	
	public PartOrderDto build(PartOrder partOrder);
	
}
