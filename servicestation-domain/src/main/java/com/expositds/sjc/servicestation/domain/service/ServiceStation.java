package com.expositds.sjc.servicestation.domain.service;

import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.PreOrder;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для работы с СТО в качестве СТО зарегестрированной на сайте-агрегаторе.
 * 
 * @author Alexey Suslov
 */
public interface ServiceStation {
	
	/**
	 * Метод создаёт заявку на заданной СТО на основании заданного предзаказа.
	 * @param serviceStation СТО
	 * @param preOrder предзаказ
	 * @return заявка
	 */
	public Order createOrder(Station serviceStation, PreOrder preOrder);

	/**
	 * Метод удаляет заданную заявку у заданного СТО
	 * @param serviceStation СТО
	 * @param order заявка
	 */
	public void deleteOrder(Station serviceStation, Order order);

	/**
	 * Метод отдаёт заданную заявку заданой СТО
	 * @param serviceStation СТО
	 * @param order заявка
	 */
	public void takeOrder(Station serviceStation, Order order);
	
	/**
	 * Метод возвращает список работающих на СТО механиков.
	 * @param station СТО
	 * @return список Person
	 */
	public Set<Person> getMechanics(Station station);

}
