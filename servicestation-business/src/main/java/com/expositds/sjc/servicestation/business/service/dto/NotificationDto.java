package com.expositds.sjc.servicestation.business.service.dto;

import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
/**
 * 
 * @author Rybakov Sergey
 *
 */

public class NotificationDto {

	private String orderId;
	
	private String message;
	
	private String machanicName;
	
	public NotificationDto(CustomerOrderDto customerOrderDto){
		this.orderId = customerOrderDto.getOrderId().toString();
		this.machanicName = customerOrderDto.getMechanicName();
		this.message = customerOrderDto.getNotificationMessage();
	}

	public String getOrderId() {
		return orderId;
	}

	public String getMessage() {
		return message;
	}

	public String getMachanicName() {
		return machanicName;
	}

}
