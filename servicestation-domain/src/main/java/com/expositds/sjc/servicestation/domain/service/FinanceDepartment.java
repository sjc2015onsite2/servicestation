package com.expositds.sjc.servicestation.domain.service;

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
	 * Метод возвращает список всех заявок заданной СТО.
	 * @param serviceStation СТО
	 * @return список заявок
	 */
	public Set<Order> getServiceStationOrders(Station serviceStation);

	/**
	 * Метод возвращает список всех заявок заданного филиала.
	 * @param affiliate филиал
	 * @return список заявок
	 */
	public Set<Order> getAffiliateOrders(Affilate affiliate);

}
