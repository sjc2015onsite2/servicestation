package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Класс, содержащий заявку на поставку запчастей.
 * 
 * @author Alexey Suslov
 */
public class PartOrder {
	
	/**
	 * Идентификатор заявки на запчасть.
	 */
	private Long partOrderId;
	
	/**
	 * Список и количество запчастей в заказе.
	 */
	private HashMap<Part, Integer> parts = new HashMap<>();

	/**
	 * Предпологаемая дата поставки запчастей.
	 */
	private Calendar date;
	
	/**
	 * Статус заявки.
	 */
	private PartOrderStatus status;
	
	/**
	 * Идентификатор заявки, который использует клиент и сотрудники.
	 */
	private String clientPartOrderId;
	
	/**
	 * Создаёт новую заявку на поставку запчастей.
	 * 
	 * @param clientPartOrderId идентификатор заявки, который использует клиент и сотрудники
	 */
	public PartOrder(String clientPartOrderId) {
		this.clientPartOrderId = clientPartOrderId;
		this.date = new GregorianCalendar();
	}
	
	/**
	 * Создаёт новую заявку на поставку запчастей.
	 */
	public PartOrder() {
		this(null);
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partOrderId == null) ? 0 : partOrderId.hashCode());
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
		PartOrder other = (PartOrder) obj;
		if (partOrderId == null) {
			if (other.partOrderId != null)
				return false;
		} else if (!partOrderId.equals(other.partOrderId))
			return false;
		return true;
	}

	public HashMap<Part, Integer> getParts() {
		return parts;
	}

	public void setParts(HashMap<Part, Integer> parts) {
		this.parts = parts;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public PartOrderStatus getStatus() {
		return status;
	}

	public void setStatus(PartOrderStatus status) {
		this.status = status;
	}

	public String getClientPartOrderId() {
		return clientPartOrderId;
	}

	public void setClientPartOrderId(String clientPartOrderId) {
		this.clientPartOrderId = clientPartOrderId;
	}

	public Long getPartOrderId() {
		return partOrderId;
	}

	public void setPartOrderId(Long partOrderId) {
		this.partOrderId = partOrderId;
	}
	
	
}
