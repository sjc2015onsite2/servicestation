package com.expositds.sjc.servicestation.business.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Класс содержит сообщение клиенту в рамках оформленной им заявки.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "client_notifications")
public class ClientNotificationEntity {
	
	/**
	 * Идентификатор сообщения клиенту.
	 */
	@Id
	@Column(name = "client_notification_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long clientNotificationId;
	
	/**
	 * Непосредственно сообщение клиенту.
	 */
	@Column(name = "client_notification")
	private String message = new String();
	
	/**
	 * Создаёт сообщение клиенту
	 * 
	 * @param message сообщение клиенту
	 */
	public ClientNotificationEntity(String message) {
		this.message = message;
	}
	
	public ClientNotificationEntity() {
		this(null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientNotificationId == null) ? 0 : clientNotificationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientNotificationEntity other = (ClientNotificationEntity) obj;
		if (clientNotificationId == null) {
			if (other.clientNotificationId != null)
				return false;
		} else if (!clientNotificationId.equals(other.clientNotificationId))
			return false;
		return true;
	}

	public Long getClientNotificationId() {
		return clientNotificationId;
	}

	public void setClientNotificationId(Long clientNotificationId) {
		this.clientNotificationId = clientNotificationId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
