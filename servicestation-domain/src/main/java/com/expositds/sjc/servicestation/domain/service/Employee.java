package com.expositds.sjc.servicestation.domain.service;

import java.util.Calendar;
import java.util.Map;

import com.expositds.sjc.servicestation.domain.model.Person;

/**
 * Интерфей предоставляет набор методов для взаимодейстрия финансовых структур с данными сотрудников СТО.
 * 
 * @author Alexey Suslov
 */
public interface Employee {

	/**
	 * Метод возвращает имя заданного сотрудника.
	 * @param employee сотрудник
	 * @return имя
	 */
	public String getName(Person employee);
	
	/**
	 * Метод возвращает заработную плату заданного сотрудника за указанный интервал, с указанным периодом.
	 * 
	 * @param employee сотрудник
	 * @param startDate дата начала запрашивамых данных
	 * @param endDate дата окончания запрашиваемых данных
	 * @return набор дат, с указанием заработной платы за этот интервал
	 */
	public Map<Calendar, Integer> getPersonSalary(Person employee, Calendar startDate, Calendar endDate);

}
