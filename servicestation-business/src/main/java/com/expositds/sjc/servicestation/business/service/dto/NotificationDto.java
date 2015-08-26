package com.expositds.sjc.servicestation.business.service.dto;

import com.expositds.sjc.servicestation.domain.model.Order;

public class NotificationDto {

	private String orderId;
	
	private String message;
	
	public NotificationDto(Order order){
		this.orderId = order.getOrderId().toString();
		this.message = order.getNotification().getMessage().toString();
	}

	public String getOrderId() {
		return orderId;
	}

	public String getMessage() {
		return message;
	}
	
}
