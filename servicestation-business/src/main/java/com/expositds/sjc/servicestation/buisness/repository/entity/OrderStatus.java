package com.expositds.sjc.servicestation.buisness.repository.entity;

/**
 * Статусы выполнения заявки.
 * 
 * @author Alexey Suslov
 */
public enum OrderStatus {
	
	/**
	 * Новая заявка, еще не распределена среди механиков.
	 */
	NEW,
	
	/**
	 * Ожидает запчастей.
	 */
	PENDING,

	/**
	 * Готова.
	 */
	READY,

	/**
	 * Принята механиком, в работе.
	 */
	ACCEPTED

}
