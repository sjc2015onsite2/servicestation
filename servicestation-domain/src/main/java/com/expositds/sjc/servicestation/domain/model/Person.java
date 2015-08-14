package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
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
	private TreeMap<Calendar, Integer> salary = new TreeMap<>();
	
	/**
	 * Создаёт нового сотрудника.
	 * 
	 * @param name имя нового сотрудника.
	 */
	public Person(String name, LogginerRole role) {
		setName(name);
		setRole(role);
	}
	
	public Person() {
		this(null, null);
	}

	public TreeMap<Calendar, Integer> getSalary() {
		return salary;
	}

	public void setSalary(TreeMap<Calendar, Integer> salary) {
		this.salary = salary;
	}
	
	
}
