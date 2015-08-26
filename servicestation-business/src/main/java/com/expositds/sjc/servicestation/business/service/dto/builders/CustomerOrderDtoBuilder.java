package com.expositds.sjc.servicestation.business.service.dto.builders;

import java.util.Map;

import com.expositds.sjc.servicestation.business.service.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.domain.model.Order;

/**
 * Инерфейс содержит методы для создания dto.
 * 
 * @author Alexey Suslov
 *
 */
public interface CustomerOrderDtoBuilder {
	
	public void setOrder(Order order);
	
	public CustomerOrderDto build();
	
	public String getOrderId();
	
	public String getStationName();
	
	public String getMechanicName();
	
	public String getProblemDescription();
	
	public String getOrderStatus();
	
	public String[][] getServiceRows();
	
	public Map<String, String> getPartsNamesAndQuantity();
	
	public String getOrderCost();
	
	public String getCompletedDate();
	
	public String getCreatedDate();
	
	public String getNotificationMessage();
	
	public Map<String, String> getStationsIdAndNames();

}
