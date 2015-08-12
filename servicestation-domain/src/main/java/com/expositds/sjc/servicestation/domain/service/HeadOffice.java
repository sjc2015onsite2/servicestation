package com.expositds.sjc.servicestation.domain.service;

import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для работы с СТО в качестве головного офиса.
 * 
 * @author Alexey Suslov
 */
public interface HeadOffice {
	
	/**
	 * Метод передаёт заданную заявку заданной СТО заданному филиалу
	 * @param serviceStation СТО
	 * @param affilate филиал
	 * @param order заявка
	 */
	public void giveOrder(Station serviceStation, Affilate affilate, Order order);

	/**
	 * Метод возвращает список новых (не распределённых между филиалами) заявок заданной СТО
	 * @param serviceStation СТО
	 * @return спивок заявок
	 */
	public Set<Order> getNewOrders(Station serviceStation);

}
