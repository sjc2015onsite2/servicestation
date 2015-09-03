package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Класс содержит информацию о СТО.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "stations")
@NamedNativeQueries({
	@NamedNativeQuery(
		name = "callGetStationByUserIdProc",
		query = "call get_station_by_order_id(:orderId)",
		resultClass = StationEntity.class
	)
})
public class StationEntity  {
	
	/**
	 * Идентификатор станции.
	 */
	@Id
	@Column(name = "station_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long stationId;
	
	/**
	 * Список филиалов и их профилей в СТО.
	 */
	@OneToMany
	@JoinTable(
			name = "station_has_affilates_affilate_profiles",
			joinColumns = @JoinColumn(name = "station_id"),
			inverseJoinColumns = @JoinColumn(name = "affilate_profile_id"))
	@MapKeyJoinColumn(name = "affilate_id")
	private Map<AffilateEntity, AffilateProfileEntity> affilates;
	
	/**
	 * Список заявок на СТО и их принадлежность филиалам.
	 */
	@OneToMany
	@JoinTable(
			name = "station_has_orders_affilates",
			joinColumns = @JoinColumn(name = "station_id"),
			inverseJoinColumns = @JoinColumn(name = "affilate_id"))
	@MapKeyJoinColumn(name = "order_id")
	private Map<OrderEntity, AffilateEntity> orders;
	
	/**
	 * Список пользователей, работающих на СТО.
	 */
	@OneToMany
	@JoinTable(
	        name="station_persons",
	        joinColumns=@JoinColumn(name="station_id"),
	        inverseJoinColumns = @JoinColumn(name = "person_id"))
	private Set<PersonEntity> persons;
	
	/**
	 * Название СТО.
	 */
	@Column(name = "station_name")
	private String name;
	
	/**
	 * Информация о СТО.
	 */
	@Column(name = "info")
	private String info;
	
	/**
	 * Создаёт новую станцию.
	 * 
	 * @param name название СТО
	 * @param personStationId идентификатор СТО, который используют клиент и сотрудники
	 */
	public StationEntity(String name) {
		this.name = name;
		this.affilates = new HashMap<>();
		this.orders = new HashMap<>();
		this.persons = new HashSet<>();
	}
	
	public StationEntity() {
		this(null);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stationId == null) ? 0 : stationId.hashCode());
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
		StationEntity other = (StationEntity) obj;
		if (stationId == null) {
			if (other.stationId != null)
				return false;
		} else if (!stationId.equals(other.stationId))
			return false;
		return true;
	}

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	public Map<AffilateEntity, AffilateProfileEntity> getAffilates() {
		return affilates;
	}

	public void setAffilates(Map<AffilateEntity, AffilateProfileEntity> affilates) {
		this.affilates = affilates;
	}

	public Map<OrderEntity, AffilateEntity> getOrders() {
		return orders;
	}

	public void setOrders(Map<OrderEntity, AffilateEntity> orders) {
		this.orders = orders;
	}

	public Set<PersonEntity> getPersons() {
		return persons;
	}

	public void setPersons(Set<PersonEntity> persons) {
		this.persons = persons;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
