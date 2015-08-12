package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class SiteUserEntity {
	
	/**
	 * Идентификатор пользователя сайта.
	 */
	@Id
	@Column(name = "site_user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long siteUserId;
	
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
	 * Имя пользователя
	 */
	@Column(name = "site_user_name")
	private String name;

	/**
	 * Создаёт нового пользователя.
	 * 
	 * @param name имя
	 */
	public SiteUserEntity(String name) {
		this.name = name;
		this.orders = new HashMap<>();
	}
	
	public SiteUserEntity() {
		this(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((siteUserId == null) ? 0 : siteUserId.hashCode());
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
		SiteUserEntity other = (SiteUserEntity) obj;
		if (siteUserId == null) {
			if (other.siteUserId != null)
				return false;
		} else if (!siteUserId.equals(other.siteUserId))
			return false;
		return true;
	}

	public Long getSiteUserId() {
		return siteUserId;
	}

	public void setSiteUserId(Long siteUserId) {
		this.siteUserId = siteUserId;
	}

	public Map<OrderEntity, StationEntity> getOrders() {
		return orders;
	}

	public void setOrders(Map<OrderEntity, StationEntity> orders) {
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
