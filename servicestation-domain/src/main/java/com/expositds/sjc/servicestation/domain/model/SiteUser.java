package com.expositds.sjc.servicestation.domain.model;
 
/**
 * Класс содержит информацию о пользователе сайта.
 * 
 * @author Alexey Suslov
 */
public class SiteUser extends SiteUserPrincipal {

	/**
	 * Создаёт нового пользователя (простого).
	 * 
	 * @param name имя
	 */
	public SiteUser(String name) {
		setName(name);
	}
	
	public SiteUser() {
		this(null);
	}
	
	
	
}
