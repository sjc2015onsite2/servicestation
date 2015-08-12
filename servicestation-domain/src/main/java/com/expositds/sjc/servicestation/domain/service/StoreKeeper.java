package com.expositds.sjc.servicestation.domain.service;

import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;

/**
 * Интерфейс предоставляет набор методов для внешнего взаимодействия с моделью данных в области функционала кладовщика.
 * 
 * @author Alxey Suslov
 */
public interface StoreKeeper {
	
	/**
	 * Метод возвращает список заявок на запчасти заданного филиала.
	 * @param affilate филиал
	 * @return список заявок на запчасти
	 */
	public Set<PartOrder> getPartOrders(Affilate affilate);

	/**
	 * Метод в заданной заяве на запчасть меняет статус на заданный.
	 * @param partOrder заявка на запчасть
	 * @param newPartOrderStatus новый статус
	 */
	public void setPartOrderStatus(PartOrder partOrder, PartOrderStatus newPartOrderStatus);

}
