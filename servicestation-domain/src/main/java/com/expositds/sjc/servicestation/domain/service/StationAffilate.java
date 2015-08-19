package com.expositds.sjc.servicestation.domain.service;

import java.util.Calendar;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;

/**
 * Интерфейс предоставляет набор методов для взаимодействия с филиалом в области филиала СТО.
 * 
 * @author Alexey Suslov
 */
public interface StationAffilate {

	/**
	 * Метод удаляет заданную заявку из заданного филиала.
	 * @param affilate филиал
	 * @param order заявка
	 */
	public void deleteOrder(Affilate affilate, Order order);

	/**
	 * Метод возвращает список всех механиков заданного филиала.
	 * @param affiliate филиал
	 * @return список сотрудников
	 */
	public Set<Person> getAffiliateMechanics(Affilate affiliate);
	
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

}
