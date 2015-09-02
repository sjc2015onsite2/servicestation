package com.expositds.sjc.servicestation.business.repository.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Alexey Suslov
 *
 */
@Entity
public class CeoNotificationDto {
	
	@Id
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name = "name")
	private String mechanicName;
	
	@Column(name = "client_notification")
	private String message;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMechanicName() {
		return mechanicName;
	}

	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
