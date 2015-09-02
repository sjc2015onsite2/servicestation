package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.Calendar;
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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.expositds.sjc.servicestation.business.repository.dto.CeoNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.MechanicNotificationDto;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;

/**
 * Класс представляет собой заяву на ремонт.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "orders")
@NamedNativeQueries({
	@NamedNativeQuery(
		name = "callGetSiteUserOrdersProc",
		query = "call get_site_user_orders(:siteUserId, :first, :size)",
		resultClass = OrderEntity.class),
	@NamedNativeQuery(
		name = "callCustomerOrderDtoProc", 
		query = "call customer_order_dto(:orderId)",
		resultClass = CustomerOrderDto.class),
	@NamedNativeQuery(
		name = "callGetNotificationsByMechanicIdProc", 
		query = "call get_notifications_by_mechanic_id(:personId)",
		resultClass = MechanicNotificationDto.class),
	@NamedNativeQuery(
		name = "callGetNotificationsByCeoIdProc", 
		query = "call get_notifications_by_ceo_id(:personId)",
		resultClass = CeoNotificationDto.class)		
})
public class OrderEntity {
	
	/**
	 * Идентификатор заказа.
	 */
	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long orderId;
	
	/**
	 * Список запчастей и их количество, необходимый, для выполнения заявки.
	 */
	@ElementCollection
	@CollectionTable(
			name = "order_has_parts_counts",
			joinColumns = @JoinColumn(name = "order_id"))
	@MapKeyJoinColumn(name = "part_id")
	@Column(name = "count")
	private Map<PartEntity, Integer> parts;
	
	/**
	 * Список работ, услуг и их количество в заказе.
	 */
	@ElementCollection
	@CollectionTable(
			name = "orders_services_counts_costs",
			joinColumns = @JoinColumn(name = "order_id"))
	@MapKeyJoinColumn(name = "service_id")
	@Column(name = "count")
	private Map<ServiceEntity, Integer> services;
	
	/**
	 * Зафиксированный для данной заявки список цен на услуги, работы
	 */
	@ElementCollection
	@CollectionTable(
			name = "orders_services_counts_costs",
			joinColumns = @JoinColumn(name = "order_id"))
	@MapKeyJoinColumn(name = "service_id")
	@Column(name = "cost")
	private Map<ServiceEntity, Integer> orderServicesPriceList;
	
	/**
	 * Статус выполнения зааза.
	 */
	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	/**
	 * Дата создания заказа.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "order_create_date")
	private Calendar createDate;
	
	/**
	 * Дата выполнения заказа.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "order_compleate_date")
	private Calendar completeDate;
	
	/**
	 * Описание проблеммы, с которой клиент обратился в СТО.
	 */
	@Column(name = "order_problem_description")
	private String problemDescription;
	
	/**
	 * Сообщение от механика клиенту.
	 */
	@OneToOne
	@JoinColumn(name = "client_notification_id")
	private ClientNotificationEntity notification;
	
	/**
	 * Идентификатор заявки, который использует клиент и сотрудники.
	 */
	@Column(name = "client_order_id")
	private String clientOrderId;
	
	/**
	 * Контактные данные незарегестрированного пользователя.
	 */
	@Column(name = "order_contact_data")
	private String contactData;
	
	
	/**
	 * Создаёт новую заявку.
	 * 
	 * @param problemDescription описание проблеммы, с которой клиент обратился в СТО
	 * @param contactData контактные данные незарегестрированного пользователя
	 */
	public OrderEntity(String problemDescription, String contactData, Calendar createDate) {
		this.problemDescription = problemDescription;
		this.contactData = contactData;
		this.createDate = createDate;
		this.status = OrderStatus.NEW;
		this.parts = new HashMap<>();
		this.services = new HashMap<>();
		this.orderServicesPriceList = new HashMap<>();
	}
	
	/**
	 * Создаёт новую заявку.
	 * 
	 * @param problemDescription описание проблеммы, с которой клиент обратился в СТО
	 */
	public OrderEntity(String problemDescription, Calendar createDate) {
		this(problemDescription, null, createDate);
	}
	
	public OrderEntity() {
		this(null, null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		OrderEntity other = (OrderEntity) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Map<PartEntity, Integer> getParts() {
		return parts;
	}

	public void setParts(Map<PartEntity, Integer> parts) {
		this.parts = parts;
	}

	public Map<ServiceEntity, Integer> getServices() {
		return services;
	}

	public void setServices(Map<ServiceEntity, Integer> services) {
		this.services = services;
	}

	public Map<ServiceEntity, Integer> getOrderServicesPriceList() {
		return orderServicesPriceList;
	}

	public void setOrderServicesPriceList(Map<ServiceEntity, Integer> orderServicesPriceList) {
		this.orderServicesPriceList = orderServicesPriceList;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Calendar getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}

	public Calendar getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(Calendar completeDate) {
		this.completeDate = completeDate;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public ClientNotificationEntity getNotification() {
		return notification;
	}

	public void setNotification(ClientNotificationEntity notification) {
		this.notification = notification;
	}

	public String getClientOrderId() {
		return clientOrderId;
	}

	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}

	public String getContactData() {
		return contactData;
	}

	public void setContactData(String contactData) {
		this.contactData = contactData;
	}

		
	
}
