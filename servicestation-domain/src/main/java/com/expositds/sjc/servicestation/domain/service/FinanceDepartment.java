package com.expositds.sjc.servicestation.domain.service;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для работы с СТО в области финансов.
 * 
 * @author Alexey Suslov
 */
public interface FinanceDepartment {
	
	/**
	 * Метод возвращает список всех сотрудников заданной СТО.
	 * @param serviceStation СТО
	 * @return список сотрудников
	 */
	public Set<Person> getServiceStationEmployees(Station serviceStation);

	/**
	 * Метод возвращает список всех механиков заданного филиала.
	 * @param affiliate филиал
	 * @return список сотрудников
	 */
	public Set<Person> getAffiliateMechanics(Affilate affiliate);

	/**
	 * Метод возвращает список выполненых заявок заданной СТО.
	 * @param serviceStation СТО
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return список заявок
	 */
	public Set<Order> getServiceStationReadyOrders(Station serviceStation, Calendar startDate, Calendar endDate);

	/**
	 * Метод возвращает список всех заявок заданной СТО.
	 * @param serviceStation СТО
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return список заявок
	 */
	public Set<Order> getServiceStationOrders(Station serviceStation, Calendar startDate, Calendar endDate);
	
	/**
	 * Метод возвращает список всех заявок заданного филиала.
	 * @param affiliate филиал
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return список заявок
	 */
	public Set<Order> getAffiliateOrders(Affilate affiliate, Calendar startDate, Calendar endDate);
	
	/**
	 * Метод возвращает список готовых заявок заданного филиала.
	 * @param affiliate филиал
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return список заявок
	 */
	public Set<Order> getAffiliateReadyOrders(Affilate affiliate, Calendar startDate, Calendar endDate);
	
	/**
	 * Метод возвращает затраты на аренду заданного филиала за указанный интервал дат.
	 * @param affilate филиал
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return арендная плата за этот интервал
	 */
	public Map<Calendar, Integer> getAffilateRent(Affilate affilate, Calendar startDate, Calendar endDate);

	/**
	 * Метод возвращает зарплату заданного сотрудника за указанный интервал дат.
	 * @param employee сотрудник
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return зарлата за этот интервал
	 */
	public Map<Calendar, Integer> getEmployeeSalary(Person employee, Calendar startDate, Calendar endDate);


}
