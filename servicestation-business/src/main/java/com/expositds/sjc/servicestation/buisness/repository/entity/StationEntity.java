package com.expositds.sjc.servicestation.buisness.repository.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
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
	 * Список сотрудников СТО с их должностями.
	 */
	@ElementCollection
	@CollectionTable(
	        name="station_has_persons_positions",
	        joinColumns=@JoinColumn(name="station_id"))
	@MapKeyJoinColumn(name = "person_id")
	@Column(name = "position")
	@Enumerated(EnumType.STRING)
	private Map<PersonEntity, Position> employees;
	
	/**
	 * Список мандатов и соответствующих им (мандатам) пользователей, работающих на СТО.
	 */
	@OneToMany
	@JoinTable(
	        name="station_has_credentials_persons",
	        joinColumns=@JoinColumn(name="station_id"),
	        inverseJoinColumns = @JoinColumn(name = "person_id"))
	@MapKeyJoinColumn(name = "credential_id")
	private Map<CredentialEntity, PersonEntity> persons;
	
	/**
	 * Список логинов на СТО.
	 */
	@ElementCollection
	@CollectionTable(
	        name="station_has_logins",
	        joinColumns=@JoinColumn(name="station_id"))
	@Column(name="login")
	private Set<String> logins;
	
	/**
	 * Название СТО.
	 */
	@Column(name = "station_name")
	private String name;
	
	/**
	 * Идентификатор СТО, который используют клиент и сотрудники.
	 */
	@Column(name = "person_station_id")
	private String personStationId;

	/**
	 * Создаёт новую станцию.
	 * 
	 * @param name название СТО
	 * @param personStationId идентификатор СТО, который используют клиент и сотрудники
	 */
	public StationEntity(String name, String personStationId) {
		this.name = name;
		this.personStationId = personStationId;
		this.affilates = new HashMap<>();
		this.orders = new HashMap<>();
		this.employees = new HashMap<>();
		this.persons = new HashMap<>();
		this.logins = new HashSet<>();
	}
	
	public StationEntity() {
		this(null, null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personStationId == null) ? 0 : personStationId.hashCode());
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
		if (personStationId == null) {
			if (other.personStationId != null)
				return false;
		} else if (!personStationId.equals(other.personStationId))
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

	public Map<PersonEntity, Position> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<PersonEntity, Position> employees) {
		this.employees = employees;
	}

	public Map<CredentialEntity, PersonEntity> getPersons() {
		return persons;
	}

	public void setPersons(Map<CredentialEntity, PersonEntity> persons) {
		this.persons = persons;
	}

	public Set<String> getLogins() {
		return logins;
	}

	public void setLogins(Set<String> logins) {
		this.logins = logins;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPersonStationId() {
		return personStationId;
	}

	public void setPersonStationId(String personStationId) {
		this.personStationId = personStationId;
	}

		
}
