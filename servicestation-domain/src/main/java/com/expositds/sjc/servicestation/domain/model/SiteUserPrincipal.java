package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;

/**
 * Базовый пользователь сайта-агрегатора
 * 
 * @author Alexey Suslov
 *
 */
public abstract class SiteUserPrincipal {

	/**
	 * Идентификатор пользователя сайта.
	 */
	private Long siteUserId;
	
	/**
	 * Список заявок пользователя сайта.
	 */
	private HashMap<Order, Station> orders = new HashMap<>();

	/**
	 * Имя пользователя
	 */
	private String name;
	
	/**
	 * Роль пользователя.
	 */
	private SiteUserRole role;

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
		SiteUserPrincipal other = (SiteUserPrincipal) obj;
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

	public HashMap<Order, Station> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Order, Station> orders) {
		this.orders = orders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SiteUserRole getRole() {
		return role;
	}

	public void setRole(SiteUserRole role) {
		this.role = role;
	}
	
	
	
}
