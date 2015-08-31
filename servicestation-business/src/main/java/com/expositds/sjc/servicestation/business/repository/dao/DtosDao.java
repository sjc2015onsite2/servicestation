package com.expositds.sjc.servicestation.business.repository.dao;

import java.util.List;

import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.MechanicNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;

/**
 * Интерфейс предоставляет набор методов доя доступа к DTO.
 * 
 * @author Алексей
 *
 */
public interface DtosDao {
	
	public CustomerOrderDto getCustomerOrderDtoByOrderId(Long Id);
	
	public StationsDto getStationsDto();
	
	public List<MechanicNotificationDto> getMechanicNotificationDto(Long id);
	
}
