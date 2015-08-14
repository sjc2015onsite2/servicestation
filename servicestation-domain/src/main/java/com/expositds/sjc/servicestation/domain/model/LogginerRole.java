package com.expositds.sjc.servicestation.domain.model;

/**
 * Роли пользователя сайта-фгрегатора.
 * 
 * @author Alexey Suslov
 *
 */
public enum LogginerRole {
	
	/**
	 * Администратор сайта.
	 */
	ADMIN,
	
	/**
	 * Пользователь сайта
	 */
	USER,
	
	/**
	 * Директор.
	 */
	CEO,

	/**
	 * Бухгалтер.
	 */
	ACCOUNTANT,

	/**
	 * Механик.
	 */
	MECHANIC

}
