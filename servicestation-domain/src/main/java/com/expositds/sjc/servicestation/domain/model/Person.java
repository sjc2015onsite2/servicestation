package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
import java.util.TreeMap;

/**
 * Класс, содержащий информацию о сотруднике.
 * 
 * @author Alexey Suslov
 */
public class Person {
	
	/**
	 * Идентификатор сотрудника.
	 */
	private Long personId;
	
	/**
	 * Имя сотрудника.
	 */
	private String name;
	
	/**
	 * Список дат и величина заработной платы по дням.
	 */
	private TreeMap<Calendar, Integer> salary = new TreeMap<>();
	
	/**
	 * Создаёт нового сотрудника.
	 * 
	 * @param name имя нового сотрудника.
	 */
	public Person(String name) {
		this.name = name;
	}
	
	public Person() {
		this(null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personId == null) ? 0 : personId.hashCode());
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
		Person other = (Person) obj;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}

	public TreeMap<Calendar, Integer> getSalary() {
		return salary;
	}

	public void setSalary(TreeMap<Calendar, Integer> salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
