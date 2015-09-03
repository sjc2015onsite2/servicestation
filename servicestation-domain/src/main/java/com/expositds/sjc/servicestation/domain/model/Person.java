package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс, содержащий информацию о сотруднике.
 * 
 * @author Alexey Suslov
 */
public class Person extends Logginer {
	
	/**
	 * Список дат и величина заработной платы по дням.
	 */
	private Map<Calendar, Integer> salary;
	
	/**
	 * Информация о механике.
	 */
	private String info;
	
	/**
	 * Создаёт нового сотрудника.
	 * 
	 * @param name имя нового сотрудника.
	 */
	public Person(String name, LogginerRole role) {
		setName(name);
		setRole(role);
		this.salary = new TreeMap<>();
	}
	
	public Person() {
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
