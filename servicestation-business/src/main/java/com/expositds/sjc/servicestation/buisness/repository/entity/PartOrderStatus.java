package com.expositds.sjc.servicestation.buisness.repository.entity;

/**
 * Статусы заявки на поставку запчастей.
 * 
 * @author Alexey Suslov
 */
public enum PartOrderStatus {

	/**
	 * Заявка в ожидании поставки.
	 */
	PENDING,

	/**
	 * Заявка выполнена.
	 */
	READY

}
