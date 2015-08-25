package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс содержит информацию о пользователе сайта.
 * 
 * @author Alexey Suslov
 */
public class SiteUser extends Logginer {

	/**
	 * Список заявок пользователя сайта.
	 */
	private Map<Order, Station> orders;
	
	/**
	 * Создаёт нового пользователя (простого).
	 * 
	 * @param name имя
	 */
	public SiteUser(String name, LogginerRole role) {
		setName(name);
		setRole(role);
		this.orders = new HashMap<>();
	}
	
	public SiteUser() {
		this(null, null);
	}

	public Map<Order, Station> getOrders() {
		return orders;
	}

	public void setOrders(Map<Order, Station> orders) {
		this.orders = orders;
	}
	
	
}
