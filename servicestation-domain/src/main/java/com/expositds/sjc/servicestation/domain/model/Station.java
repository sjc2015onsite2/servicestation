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
	 * Название СТО.
	 */
	private String name;

	/**
	 * Создаёт новую станцию.
	 * 
	 * @param name название СТО
	 * @param info информация об СТО
	 */
	public Station(String name) {
		this.name = name;
		this.affilates = new HashMap<>();
		this.orders = new HashMap<>();
		this.employees = new HashSet<>();
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
		Station other = (Station) obj;
		if (stationId == null) {
			if (other.stationId != null)
				return false;
		} else if (!stationId.equals(other.stationId))
			return false;
		return true;
	}

	public Station() {
		this(null);
	}

	public Long getStationId() {
		return stationId;
	}

	public void setStationId(Long stationId) {
		this.stationId = stationId;
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

	public Set<Person> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Person> employees) {
		this.employees = employees;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
