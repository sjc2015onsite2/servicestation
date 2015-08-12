package com.expositds.sjc.servicestation.domain.model;

/**
 * Класс содержит сообщение клиенту в рамках оформленной им заявки.
 * 
 * @author Alexey Suslov
 */
public class ClientNotification {
	
	/**
	 * Идентификатор сообщения клиенту.
	 */
	private Long clientNotificationId;
	
	/**
	 * Непосредственно сообщение клиенту.
	 */
	private String message = new String();
	
	/**
	 * Создаёт сообщение клиенту
	 * 
	 * @param message сообщение клиенту
	 */
	public ClientNotification(String message) {
		this.message = message;
	}
	
	public ClientNotification() {
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
		ClientNotification other = (ClientNotification) obj;
		if (clientNotificationId == null) {
			if (other.clientNotificationId != null)
				return false;
		} else if (!clientNotificationId.equals(other.clientNotificationId))
			return false;
		return true;
	}

	public String getMessage() {
		return message;
	}

	public Long getClientNotification() {
		return clientNotificationId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getClientNotificationId() {
		return clientNotificationId;
	}

	public void setClientNotificationId(Long clientNotificationId) {
		this.clientNotificationId = clientNotificationId;
	}
	
	
}
