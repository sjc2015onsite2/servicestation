package com.expositds.sjc.servicestation.domain.service;

import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для внешнего взаимоднйствия с моделью данных в области функционала 
 * неавторизированного пользователя и сайта-агрегатора.
 * 
 * @author Alexey Suslov
 */
public interface NonAuthorizedUserSite extends UserSite {

	/**
	 * Метод создаёт заказ для с указанной проблемой с указанным СТО с указанными контактными данными. 
	 * @param contact контактные данные
	 * @param problemDescription описание проблеммы
	 * @param serviceStation СТО
	 */
	public void createOrder(String contact, String problemDescription, Station serviceStation);
	
	/**
	 * Метод сохраняет нового пользователя.
	 * @param siteUser пользователь
	 */
	public void saveSiteUser(SiteUser siteUser);

}
