package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
 
/**
 * Класс содержит информацию о пользователе сайта.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "site_users")
@PrimaryKeyJoinColumn(name = "site_user_id")
public class SiteUserEntity extends LogginerEntity{
	
	/**
	 * Список заявок пользователя сайта.
	 */
	@OneToMany
	@JoinTable(
			name = "site_user_has_orders_stations",
			joinColumns = @JoinColumn(name = "site_user_id"),
			inverseJoinColumns = @JoinColumn(name = "station_id"))
	@MapKeyJoinColumn(name = "order_id")
	private Map<OrderEntity, StationEntity> orders;

	/**
	 * Создаёт нового пользователя.
	 * 
	 * @param name имя
	 */
	public SiteUserEntity(String name) {
		setName(name);
		this.orders = new HashMap<>();
	}
	
	public SiteUserEntity() {
		this(null);
	}

	public Map<OrderEntity, StationEntity> getOrders() {
		return orders;
	}

	public void setOrders(Map<OrderEntity, StationEntity> orders) {
		this.orders = orders;
	}

	
	
}
