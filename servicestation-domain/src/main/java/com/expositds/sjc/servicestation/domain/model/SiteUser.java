package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;

/**
 * Класс содержит информацию о пользователе сайта.
 * 
 * @author Alexey Suslov
 */
public class SiteUser extends Logginer {

	/**
	 * Список заявок пользователя сайта.
	 */
	private HashMap<Order, Station> orders = new HashMap<>();
	
	/**
	 * Создаёт нового пользователя (простого).
	 * 
	 * @param name имя
	 */
	public SiteUser(String name) {
		setName(name);
	}
	
	public SiteUser() {
		this(null);
	}

	public HashMap<Order, Station> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Order, Station> orders) {
		this.orders = orders;
	}
	
	
}
