package com.expositds.sjc.servicestation.domain.service;

import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.PartOrder;

/**
 * Интерфейс предоставляет набор методов для взаимодействия с филиалом в области склада запчастей.
 * 
 * @author Alexey Suslov
 */
public interface Storage {

	/**
	 * Метод возвращает список заявок на запчасти заданного филиала.
	 * @param affilate филиал
	 * @return список заявок на запчасти
	 */
	public Set<PartOrder> getPartOrders(Affilate affilate);

}
