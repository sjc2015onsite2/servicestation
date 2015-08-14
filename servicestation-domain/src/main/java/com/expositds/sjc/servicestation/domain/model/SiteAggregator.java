package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Класс представляет собой хранилище состояния сайта агрегатора. Этот класс имеет только один экземпляр.
 *
 * @author Alexey Suslov
 */
public class SiteAggregator {
	
	/**
	 * Идентификатор сайта-аггрегатора.
	 */
	private Long siteAggregatorId;
	
	/**
	 * Список пользователей, зарегистрированных на сайте.
	 */
	private Set<SiteUser> siteUsers = new HashSet<>();
	
	/**
	 * Список логинов на сайте
	 */
	private Set<String> logins = new HashSet<>();

	/**
	 * Список механиков (Person) и их профилей на сайте.
	 */
	private Map<Person, MechanicProfile> mechanicPofiles = new HashMap<>();

	/**
	 * Список СТО и их профилей, зарегистрированных на сайте.
	 */
	private Map<Station, StationProfile> stationProfiles = new HashMap<>();

	/**
	 * Список заявок клиентов и СТО, которым они (заявки) были переданы на исполнение.
	 */
	private Map<Order, Station> orders = new HashMap<>();
	
		public Map<Person, MechanicProfile> getMechanicPofiles() {
		return mechanicPofiles;
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((siteAggregatorId == null) ? 0 : siteAggregatorId.hashCode());
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
		SiteAggregator other = (SiteAggregator) obj;
		if (siteAggregatorId == null) {
			if (other.siteAggregatorId != null)
				return false;
		} else if (!siteAggregatorId.equals(other.siteAggregatorId))
			return false;
		return true;
	}

	public void setMechanicPofiles(HashMap<Person, MechanicProfile> mechanicPofiles) {
		this.mechanicPofiles = mechanicPofiles;
	}

	public void setLogins(HashSet<String> logins) {
		this.logins = logins;
	}

	public Long getSiteAggregatorId() {
		return siteAggregatorId;
	}

	public void setSiteAggregatorId(Long siteAggregatorId) {
		this.siteAggregatorId = siteAggregatorId;
	}

	public Set<SiteUser> getSiteUsers() {
		return siteUsers;
	}

	public void setSiteUsers(Set<SiteUser> siteUsers) {
		this.siteUsers = siteUsers;
	}

	public Set<String> getLogins() {
		return logins;
	}

	public void setLogins(Set<String> logins) {
		this.logins = logins;
	}

	public Map<Station, StationProfile> getStationProfiles() {
		return stationProfiles;
	}

	public void setStationProfiles(Map<Station, StationProfile> stationProfiles) {
		this.stationProfiles = stationProfiles;
	}

	public Map<Order, Station> getOrders() {
		return orders;
	}

	public void setOrders(Map<Order, Station> orders) {
		this.orders = orders;
	}

	public void setMechanicPofiles(Map<Person, MechanicProfile> mechanicPofiles) {
		this.mechanicPofiles = mechanicPofiles;
	}
	
	
	
}
