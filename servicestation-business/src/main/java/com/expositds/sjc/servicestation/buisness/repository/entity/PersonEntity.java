package com.expositds.sjc.servicestation.buisness.repository.entity;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Класс, содержащий информацию о сотруднике.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "persons")
public class PersonEntity {
	
	/**
	 * Идентификатор сотрудника.
	 */
	@Id
	@Column(name = "person_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long personId;
	
	/**
	 * Имя сотрудника.
	 */
	@Column(name = "person_name")
	private String name;
	
	/**
	 * Список дат и величина заработной платы по дням.
	 */
	@ElementCollection
	@CollectionTable(
			name = "person_has_dates_salarys",
			joinColumns = @JoinColumn(name = "person_id"))
	@MapKeyColumn(name = "date")
	@Column(name = "salary")
	private Map<Calendar, Integer> salary;
	
	/**
	 * Создаёт нового сотрудника.
	 * 
	 * @param name имя нового сотрудника.
	 */
	public PersonEntity(String name) {
		this.name = name;
		this.salary = new TreeMap<>();
	}
	
	public PersonEntity() {
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
		PersonEntity other = (PersonEntity) obj;
		if (personId == null) {
			if (other.personId != null)
				return false;
		} else if (!personId.equals(other.personId))
			return false;
		return true;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<Calendar, Integer> getSalary() {
		return salary;
	}

	public void setSalary(Map<Calendar, Integer> salary) {
		this.salary = salary;
	}
	
}
