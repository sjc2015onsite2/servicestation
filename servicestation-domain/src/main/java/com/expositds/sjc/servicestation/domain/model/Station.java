package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Класс содержит информацию о СТО.
 * 
 * @author Alexey Suslov
 */
public class Station  {
	
	/**
	 * Идентификатор станции.
	 */
	private Long stationId;
	
	/**
	 * Список филиалов и их профилей в СТО.
	 */
	private Map<Affilate, AffilateProfile> affilates;
	
	/**
	 * Список заявок на СТО и их принадлежность филиалам.
	 */
	private Map<Order, Affilate> orders;
	
	/**
	 * Список сотрудников СТО.
	 */
	private Set<Person> employees;
	
	/**
	 * Список логинов на СТО
	 */
	private Set<String> logins;
	
	/**
	 * Название СТО.
	 */
	private String name;
	
	/**
	 * Идентификатор СТО, который используют клиент и сотрудники.
	 */
	private String personStationId;

	/**
	 * Создаёт новую станцию.
	 * 
	 * @param name название СТО
	 * @param personStationId идентификатор СТО, который используют клиент и сотрудники
	 */
	public Station(String name, String personStationId) {
		this.name = name;
		this.personStationId = personStationId;
		this.affilates = new HashMap<>();
		this.orders = new HashMap<>();
		this.employees = new HashSet<>();
		this.logins = new HashSet<>();
	}
	
	public Station() {
		this(null, null);
	}

	public Map<Affilate, AffilateProfile> getAffilates() {
		return affilates;
	}

	public void setAffilates(Map<Affilate, AffilateProfile> affilates) {
		this.affilates = affilates;
	}

	public Map<Order, Affilate> getOrders() {
		return orders;
	}

	public void setOrders(Map<Order, Affilate> orders) {
		this.orders = orders;
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

	public String getPersonStationId() {
		return personStationId;
	}

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}

	public Set<Person> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Person> employees) {
		this.employees = employees;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPersonStationId(String personStationId) {
		this.personStationId = personStationId;
	}
	
	
	
}
