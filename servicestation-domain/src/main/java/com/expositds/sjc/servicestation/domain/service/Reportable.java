package com.expositds.sjc.servicestation.domain.service;

import java.util.Calendar;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для взаимодействия с моделью данных в области построения отчётов.
 * 
 * @author Alexey Suslov
 */
public interface Reportable {

	/**
	 * Метод расчитывает и возвращает прибыль заданного СТО, сформированныую по выполненым заявкам за указанный интервал дат.
	 * @param seviceStation СТО
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return прибыль за этот интервал
	 */
	public Integer getServiceStationProfit(Station seviceStation, Calendar startDate, Calendar endDate);

	/**
	 * Метод расчитывает и возвращает прибыль заданного филиала, сформированныую по выполненым заявкам за указанный интервал дат.
	 * @param affilate филиал	
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return прибыль за этот интервал
	 */
	public Integer getAffilateProfit(Affilate affilate, Calendar startDate, Calendar endDate);

	/**
	 * Метод расчитывает и возвращает затраты на аренду заданного филиала за указанный интервал дат.
	 * @param affilate филиал
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return арендная плата за этот интервал
	 */
	public Integer getAffilateRent(Affilate affilate, Calendar startDate, Calendar endDate);

	/**
	 * Метод расчитывает и возвращает затраты на аренду заданного СТО за указанный интервал дат.
	 * @param serviceStation СТО
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return арендная плата за этот интервал
	 */
	public Integer getServiceStationRent(Station serviceStation, Calendar startDate, Calendar endDate);

	/**
	 * Метод расчитывает и возвращает заработную плату механиков заданного СТО за указанный интервал дат.
	 * @param serviceStation СТО
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return набор интервалов, разбитый по периодам с указанием заработной платы за этот интервал
	 */
	public Integer getMechanicsSalary(Station serviceStation, Calendar startDate, Calendar endDate);

	/**
	 * Метод расчитывает и возвращает затраты заданного СТО (заработную плату механиков, других сотрудников, затраты на аренду) за указанный интервал дат.
	 * @param serviceStation СТО
	 * @param startDate начальная дата
	 * @param endDate конечная дата
	 * @return набор интервалов, разбитый по периодам с указанием арендной платы за этот интервал
	 */
	public Integer getServiceStationCharges(Station serviceStation, Calendar startDate, Calendar endDate);

	/**
	 * Метод возвращает все заявки заданного СТО.
	 * @param serviceStation СТО
	 * @param startDate начальная дата
	 * @param endDate конечная дата
   	 * @return список заявок
	 */
	public Set<Order> getServiceStationOrders(Station serviceStation, Calendar startDate, Calendar endDate);
	
	/**
	 * Метод возвращает список всех сотрудников заданного СТО.
	 * @param station СТО
	 * @return список сотрудников
	 */
	public Set<Person> getServiceStationEmloyees(Station station);

}
