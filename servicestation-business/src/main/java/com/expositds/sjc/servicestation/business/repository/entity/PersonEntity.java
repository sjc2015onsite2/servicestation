package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.expositds.sjc.servicestation.domain.model.LogginerRole;

/**
 * Класс, содержащий информацию о сотруднике.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "persons")
@PrimaryKeyJoinColumn(name = "person_id")
public class PersonEntity extends LogginerEntity{
	
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
	 * Информация о механике.
	 */
	@Column(name = "info")
	private String info;
	
	/**
	 * Создаёт нового сотрудника.
	 * 
	 * @param name имя нового сотрудника.
	 */
	public PersonEntity(String name, LogginerRole role) {
		setName(name);
		setRole(role);
		this.salary = new TreeMap<>();
	}
	
	public PersonEntity() {
		this(null, null);
	}

	public Map<Calendar, Integer> getSalary() {
		return salary;
	}

	public void setSalary(Map<Calendar, Integer> salary) {
		this.salary = salary;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
}
