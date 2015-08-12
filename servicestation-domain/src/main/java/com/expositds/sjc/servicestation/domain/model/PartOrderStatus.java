package com.expositds.sjc.servicestation.domain.model;

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
