package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс представляет собой заяву на ремонт.
 * 
 * @author Alexey Suslov
 */
public class Order {
	
	/**
	 * Идентификатор заказа.
	 */
	private Long orderId;
	
	/**
	 * Список запчастей их количство, необходимый, для выполнения заявки.
	 */
	private HashMap<Part, Integer> parts = new HashMap<>();
	
	/**
	 * Список работ, услуг и их количество в заказе.
	 */
	private Map<Service, Integer> services = new HashMap<>();
	
	/**
	 * Зафиксированный для данной заявки список цен на услуги, работы
	 */
	private HashMap<Service, Integer> orderServicesPriceList = new HashMap<>();
	
	/**
	 * Статус выполнения зааза.
	 */
	private OrderStatus status;
	
	/**
	 * Дата создания заказа.
	 */
	private Calendar createDate;
	
	/**
	 * Дата выполнения заказа.
	 */
	private Calendar completeDate;
	
	/**
	 * Описание проблеммы, с которой клиент обратился в СТО.
	 */
	private String problemDescription;
	
	/**
	 * Сообщение от механика клиенту.
	 */
	private ClientNotification notification;
	
	/**
	 * Идентификатор заявки, который использует клиент и сотрудники.
	 */
	private String clientOrderId;
	
	/**
	 * Контактные данные незарегестрированного пользователя.
	 */
	private String contactData;
	
	/**
	 * Создаёт новую заявку.
	 * 
	 * @param problemDescription описание проблеммы, с которой клиент обратился в СТО
	 * @param clientOrderId идентификатор заявки, который использует клиент и сотрудники
	 * @param contactData контактные данные незарегестрированного пользователя
	 */
	public Order(String problemDescription, String clientOrderId, String contactData) {
		this.problemDescription = problemDescription;
		this.clientOrderId = clientOrderId;
		this.contactData = contactData;
		this.status = OrderStatus.NEW;
		this.createDate = new GregorianCalendar();
	}
	
	/**
	 * Создаёт новую заявку.
	 * 
	 * @param problemDescription описание проблеммы, с которой клиент обратился в СТО
	 * @param clientOrderId идентификатор заявки, который использует клиент и сотрудники
	 */
	public Order(String problemDescription, String clientOrderId) {
		this(problemDescription, clientOrderId, null);
	}
	
	/**
	 * Создаёт новую заявку.
	 * 
	 * @param problemDescription описание проблеммы, с которой клиент обратился в СТО
	 */
	public Order(String problemDescription) {
		this(problemDescription, null);
	}
	
	public Order() {
		this(null);
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
		Order other = (Order) obj;
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

	public HashMap<Part, Integer> getParts() {
		return parts;
	}

	public void setParts(HashMap<Part, Integer> parts) {
		this.parts = parts;
	}
	
	

	public Map<Service, Integer> getServices() {
		return services;
	}

	public void setServices(Map<Service, Integer> services) {
		this.services = services;
	}

	public HashMap<Service, Integer> getOrderServicesPriceList() {
		return orderServicesPriceList;
	}

	public void setOrderServicesPriceList(HashMap<Service, Integer> orderServicesPriceList) {
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

	public ClientNotification getNotification() {
		return notification;
	}

	public void setNotification(ClientNotification notification) {
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
