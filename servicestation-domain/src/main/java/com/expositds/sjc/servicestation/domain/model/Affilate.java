package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Класс Affilate содержит иформацию о Person, Part, Service, PartOrder, Order.
 * 
 * @author Alexey Suslov
 */
public class Affilate {
	
	/**
	 * Идентификатор филиала.
	 */
	private Long affilateId; 
	
	/**
	 * Список запасных частей в филиале с указанием их количества.
	 */
	private Map<Part, Integer> parts;

	/**
	 * Список заявок и принадлежность к механику у филиала.
	 */
	private Map<Order, Person> orders;

	/**
	 * Список заявок на запчасти с указанием механика, который создал завку на запчасть.
	 */
	private Map<PartOrder, Person> partOrders;

	/**
	 * Список сотрудников (механиков) работающих в филиале.
	 */
	private Set<Person> persons;

	/**
	 * Список оказываемых филиалом услуг и их стоимость.
	 */
	private Map<Service, Integer> services;

	/**
	 * Код филиала.
	 */
	private String affilateCode;
	
	/**
	 * Создаёт филлиал.
	 * 
	 * @param affilateCode униальный в рамках СТО код филиала
	 */
	public Affilate(String affilateCode) {
		this.affilateCode = affilateCode;
		this.parts = new HashMap<>();
		this.orders = new HashMap<>();
		this.partOrders = new HashMap<>();
		this.persons = new HashSet<>();
		this.services = new HashMap<>();
	}
	
		public Affilate() {
		this(null);
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affilateId == null) ? 0 : affilateId.hashCode());
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
		Affilate other = (Affilate) obj;
		if (affilateId == null) {
			if (other.affilateId != null)
				return false;
		} else if (!affilateId.equals(other.affilateId))
			return false;
		return true;
	}

	public Long getAffilateId() {
		return affilateId;
	}

	public void setAffilateId(Long affilateId) {
		this.affilateId = affilateId;
	}

	public Map<Part, Integer> getParts() {
		return parts;
	}

	public void setParts(Map<Part, Integer> parts) {
		this.parts = parts;
	}

	public Map<Order, Person> getOrders() {
		return orders;
	}

	public void setOrders(Map<Order, Person> orders) {
		this.orders = orders;
	}

	public Map<PartOrder, Person> getPartOrders() {
		return partOrders;
	}

	public void setPartOrders(Map<PartOrder, Person> partOrders) {
		this.partOrders = partOrders;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	public Map<Service, Integer> getServices() {
		return services;
	}

	public void setServices(Map<Service, Integer> services) {
		this.services = services;
	}

	public String getAffilateCode() {
		return affilateCode;
	}

	public void setAffilateCode(String affilateCode) {
		this.affilateCode = affilateCode;
	}
	
}
