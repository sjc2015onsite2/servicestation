package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;
import java.util.HashSet;
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
	private HashMap<Affilate, AffilateProfile> affilates = new HashMap<>();
	
	/**
	 * Список заявок на СТО и их принадлежность филиалам.
	 */
	private HashMap<Order, Affilate> orders = new HashMap<>();
	
	/**
	 * Список сотрудников СТО.
	 */
	private Set<Person> employees = new HashSet<>();
	
	/**
	 * Список логинов на СТО
	 */
	private HashSet<String> logins = new HashSet<>();
	
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
	}
	
	public Station() {
		this(null, null);
	}

	public HashMap<Affilate, AffilateProfile> getAffilates() {
		return affilates;
	}

	public void setAffilates(HashMap<Affilate, AffilateProfile> affilates) {
		this.affilates = affilates;
	}

	public HashMap<Order, Affilate> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Order, Affilate> orders) {
		this.orders = orders;
	}

	public HashSet<String> getLogins() {
		return logins;
	}

	public void setLogins(HashSet<String> logins) {
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
