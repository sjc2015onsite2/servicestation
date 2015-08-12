package com.expositds.sjc.servicestation.buisness.repository.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
 * Класс представляет собой хранилище состояния сайта агрегатора. Этот класс имеет только один экземпляр.
 *
 * @author Alexey Suslov
 */
@Entity
@Table(name = "site_aggregators")
public class SiteAggregatorEntity {
	
	/**
	 * Идентификатор сайта-аггрегатора.
	 */
	@Id
	@Column(name = "site_aggregator_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long siteAggregatorId;
	
	/**
	 * Список мандатов и соответствующих пользователей, зарегистрированных на сайте.
	 */
	@OneToMany
	@JoinTable(
			name = "site_aggregator_has_credentials_site_users",
			joinColumns = @JoinColumn(name = "site_aggregator_id"),
			inverseJoinColumns = @JoinColumn(name = "site_user_id"))
	@MapKeyJoinColumn(name = "credential_id")
	private Map<CredentialEntity, SiteUserEntity> siteUsers;
	
	/**
	 * Список логинов на сайте
	 */
	@ElementCollection
	@CollectionTable(
			name = "site_aggregator_has_logins",
			joinColumns = @JoinColumn(name = "site_aggregator_id"))
	@Column(name = "login")
	private Set<String> logins;

	/**
	 * Список механиков (Person) и их профилей на сайте.
	 */
	@OneToMany
	@JoinTable(
			name = "site_aggregator_has_persons_mechanic_profiles",
			joinColumns = @JoinColumn(name = "site_aggregator_id"),
			inverseJoinColumns = @JoinColumn(name = "mechanic_profile_id"))
	@MapKeyJoinColumn(name = "person_id")
	private Map<PersonEntity, MechanicProfileEntity> mechanicPofiles;

	/**
	 * Список СТО и их профилей, зарегистрированных на сайте.
	 */
	@OneToMany
	@JoinTable(
			name = "site_aggregator_has_stations_station_profiles",
			joinColumns = @JoinColumn(name = "site_aggregator_id"),
			inverseJoinColumns = @JoinColumn(name = "station_profile_id"))
	@MapKeyJoinColumn(name = "station_id")
	private Map<StationEntity, StationProfileEntity> stationProfiles;

	/**
	 * Список заявок клиентов и СТО, которым они (заявки) были переданы на исполнение.
	 */
	@OneToMany
	@JoinTable(
			name = "site_aggregator_has_orders_stations",
			joinColumns = @JoinColumn(name = "site_aggregator_id"),
			inverseJoinColumns = @JoinColumn(name = "station_id"))
	@MapKeyJoinColumn(name = "order_id")
	private Map<OrderEntity, StationEntity> orders;
	
	/**
	 * Создаёт новый сайт агрегатор.
	 */
	public SiteAggregatorEntity() {
		this.siteUsers = new HashMap<>();
		this.logins = new HashSet<>();
		this.mechanicPofiles = new HashMap<>();
		this.stationProfiles = new HashMap<>();
		this.orders = new HashMap<>();
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
		SiteAggregatorEntity other = (SiteAggregatorEntity) obj;
		if (siteAggregatorId == null) {
			if (other.siteAggregatorId != null)
				return false;
		} else if (!siteAggregatorId.equals(other.siteAggregatorId))
			return false;
		return true;
	}



	public Long getSiteAggregatorId() {
		return siteAggregatorId;
	}

	public void setSiteAggregatorId(Long siteAggregatorId) {
		this.siteAggregatorId = siteAggregatorId;
	}

	public Map<CredentialEntity, SiteUserEntity> getSiteUsers() {
		return siteUsers;
	}

	public void setSiteUsers(Map<CredentialEntity, SiteUserEntity> siteUsers) {
		this.siteUsers = siteUsers;
	}

	public Set<String> getLogins() {
		return logins;
	}

	public void setLogins(Set<String> logins) {
		this.logins = logins;
	}

	public Map<PersonEntity, MechanicProfileEntity> getMechanicPofiles() {
		return mechanicPofiles;
	}

	public void setMechanicPofiles(Map<PersonEntity, MechanicProfileEntity> mechanicPofiles) {
		this.mechanicPofiles = mechanicPofiles;
	}

	public Map<StationEntity, StationProfileEntity> getStationProfiles() {
		return stationProfiles;
	}

	public void setStationProfiles(Map<StationEntity, StationProfileEntity> stationProfiles) {
		this.stationProfiles = stationProfiles;
	}

	public Map<OrderEntity, StationEntity> getOrders() {
		return orders;
	}

	public void setOrders(Map<OrderEntity, StationEntity> orders) {
		this.orders = orders;
	}

	
	
}
