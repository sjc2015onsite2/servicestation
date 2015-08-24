package com.expositds.sjc.servicestation.domain.service;

import java.util.Calendar;
import java.util.Map;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Service;

/**
 * Интерфейс предоставляет набор методов для внешнего взаимодействия с моделью данных в области функционала механика 
 * (на данном этапе разработки расширен фунционалом кладовщика).
 * 
 * @author Alexey Suslov
 */
public interface Mechanic extends StoreKeeper {
	
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
	 * Метод меняет в заданной заявке статус на заданный.
	 * @param order заявка
	 * @param orderStatus новый статус заявки
	 */
	public void setOrderStatus(Order order, OrderStatus orderStatus);

	/**
	 * Метод устанавливает в заданной заданной заявке дату исполнения.
	 * @param oder заявка
	 * @param orderCopmleteDate дата исполнения 
	 */
	public void setOrderCompletionDate(Order order, Calendar orderCopmleteDate);

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
	 * Метод создаёт заявку на запчати с указанным списком запчастей, у указанным механиком.
	 * @param mechanic механик
	 * @param parts список запчастей с их количеством
	 */
	public void createPartOrder(Person mechanic, Map<Part, Integer> parts);

	/**
	 * Метод в заданной завяке создаёт сообщение.
	 * @param order заявка
	 * @param notification сообщение 
	 */
	public void createClientNotification(Order order, String notification);

	/**
	 * Метод добавляет к заданной заявке заданный список запчастей с указанием их количества.
	 * @param order заявка
	 * @param parts список запчастей с их количеством
	 */
	public void addPartsToOrder(Order order, Map<Part, Integer> parts);

	/**
	 * Метод добавляет в заданную заявку лист цен на услуги. Цены берутся из филиала.
	 * @param order заявка
	 * @param servicesPriceList список услуг 
	 */
	public void addServicesPriceListToOrder(Order order, Set<Service> servicesPriceList);
	
	/**
	 * Метод добавляет к заданной заявке заданный список услуг с указанием их количества.
	 * @param order заявка
	 * @param services список услуг с их количеством
	 */
	public void addServicesToOrder(Order order, Map<Service, Integer> services);
	
	/**
	 * Метод назначает заданную заявку заданному механнику в заданном филиале.
	 * @param mechanic механик
	 * @param order заявка
	 */
	public void giveOrder(Person mechanic, Order order);


	
}
