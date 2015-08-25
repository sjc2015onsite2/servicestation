package com.expositds.sjc.servicestation.domain.service;

import java.util.Map;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Service;

/**
 * Интерфейс предоставляет набор методов для взаимодействия с филиалом в области ремонтной мастерской.
 * 
 * @author Alexey Suslov
 */
public interface WorkShop {
	
	/**
	 * Метод возвращает список доступных для работы заданному механику заявок.
	 * @param mechanic механик
	 * @return список заявок
	 */
	public Set<Order> getMechanicOrders(Person mechanic);
	
	/**
	 * Метод возвращает список новых доступных для работы заданному механику заявок.
	 * @param mechanic
	 * @return
	 */
	public Set<Order> getMechanicFreeOrders(Person mechanic);

	/**
	 * Метод возвращает список запчастей с их количеством в заданном филиале.
	 * @param affilate филиал
	 * @return список запчастей с количеством
	 */
	public Map<Part, Integer> getPartsQuantity(Affilate affilate);

	/**
	 * Метод возвращает список услуг с их ценой в заданном филиале.
	 * @param affilate филиал
	 * @return список услуг с их ценой
	 */
	public Map<Service, Integer> getServicesCost(Affilate affilate);

	/**
	 * Метод назначает заданную заявку заданному механнику в заданном филиале.
	 * @param mechanic механик
	 * @param order заявка
	 */
	public void giveOrder(Person mechanic, Order order);

	/**
	 * Метод создаёт заявку на запчати  у указанным механиком.
	 * @param mechanic механик
	 * @param parts список запчастей с их количеством
	 * @return внось сщзданную заявку
	 */
	public PartOrder createPartOrder(Person mechanic);
	
	/**
	 * Метод добавляетв указанную заявку на запчасти запчасти.
	 * @param partOrder заявка на запчасти
	 * @param parts запчасти
	 */
	public void addPartsToPartOrder(PartOrder partOrder, Map<Part, Integer> parts);

}
