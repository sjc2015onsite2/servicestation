package com.expositds.sjc.servicestation.business.repository.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Алексей
 *
 */
@Entity
public class MechanicNotificationDto {
	
	@Id
	@Column(name = "order_id")
	private String orderId;
	
	@Column(name = "client_notification")
	private String message;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
