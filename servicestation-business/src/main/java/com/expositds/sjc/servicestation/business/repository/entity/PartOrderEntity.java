package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;

/**
 * Класс, содержащий заявку на поставку запчастей.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "part_orders")
public class PartOrderEntity {
	
	/**
	 * Идентификатор заявки на запчасть.
	 */
	@Id
	@Column(name = "part_order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long partOrderId;
	
	/**
	 * Список и количество запчастей в заказе.
	 */
	@ElementCollection
	@CollectionTable(
			name = "part_order_has_parts_counts",
			joinColumns = @JoinColumn(name = "part_order_id"))
	@MapKeyJoinColumn(name = "part_id")
	@Column(name = "count")
	private Map<PartEntity, Integer> parts;

	/**
	 * Предпологаемая дата поставки запчастей.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Calendar date;
	
	/**
	 * Статус заявки.
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private PartOrderStatus status;
	
	/**
	 * Идентификатор заявки, который использует клиент и сотрудники.
	 */
	@Column(name = "client_part_order_id")
	private String clientPartOrderId;
	
	/**
	 * Создаёт новую заявку на поставку запчастей.
	 * 
	 * @param clientPartOrderId идентификатор заявки, который использует клиент и сотрудники
	 */
	public PartOrderEntity(String clientPartOrderId) {
		this.clientPartOrderId = clientPartOrderId;
		this.date = new GregorianCalendar();
		this.parts = new HashMap<>();
		this.status = PartOrderStatus.PENDING;
	}
	
	/**
	 * Создаёт новую заявку на поставку запчастей.
	 */
	public PartOrderEntity() {
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
		PartOrderEntity other = (PartOrderEntity) obj;
		if (partOrderId == null) {
			if (other.partOrderId != null)
				return false;
		} else if (!partOrderId.equals(other.partOrderId))
			return false;
		return true;
	}

	public Long getPartOrderId() {
		return partOrderId;
	}

	public void setPartOrderId(Long partOrderId) {
		this.partOrderId = partOrderId;
	}

	public Map<PartEntity, Integer> getParts() {
		return parts;
	}

	public void setParts(Map<PartEntity, Integer> parts) {
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
	
}
