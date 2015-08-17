package com.expositds.sjc.servicestation.domain.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
	private HashMap<Part, Integer> parts = new HashMap<>();

	/**
	 * Список заявок и принадлежность к механику у филиала.
	 */
	private Map<Order, Person> orders = new HashMap<>();

	/**
	 * Список заявок на запчасти с указанием механика, который создал завку на запчасть.
	 */
	private HashMap<PartOrder, Person> partOrders = new HashMap<>();

	/**
	 * Список сотрудников (механиков) работающих в филиале.
	 */
	private HashSet<Person> persons = new HashSet<>();

	/**
	 * Список оказываемых филиалом услуг и их стоимость.
	 */
	private HashMap<Service, Integer> services = new HashMap<>();

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

	public HashMap<Part, Integer> getParts() {
		return parts;
	}

	public void setParts(HashMap<Part, Integer> parts) {
		this.parts = parts;
	}

	public Map<Order, Person> getOrders() {
		return orders;
	}

	public void setOrders(Map<Order, Person> orders) {
		this.orders = orders;
	}

	public HashMap<PartOrder, Person> getPartOrders() {
		return partOrders;
	}

	public void setPartOrders(HashMap<PartOrder, Person> partOrders) {
		this.partOrders = partOrders;
	}

	public HashSet<Person> getPersons() {
		return persons;
	}

	public void setPersons(HashSet<Person> persons) {
		this.persons = persons;
	}

	public HashMap<Service, Integer> getServices() {
		return services;
	}

	public void setServices(HashMap<Service, Integer> services) {
		this.services = services;
	}

	public String getAffilateCode() {
		return affilateCode;
	}

	public void setAffilateCode(String affilateCode) {
		this.affilateCode = affilateCode;
	}
	
}
