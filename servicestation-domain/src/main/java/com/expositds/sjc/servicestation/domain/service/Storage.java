package com.expositds.sjc.servicestation.domain.service;

import java.util.Calendar;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;

/**
 * Интерфейс предоставляет набор методов для взаимодействия с филиалом в области склада запчастей.
 * 
 * @author Alexey Suslov
 */
public interface Storage {

	/**
	 * Метод в заданной заяве на запчасть меняет статус на заданный.
	 * @param partOrder заявка на запчасть
	 * @param newPartOrderStatus новый статус
	 */
	public void setPartOrderStatus(PartOrder partOrder, PartOrderStatus newPartOrderStatus);

	/**
	 * Метод возвращает список заявок на запчасти заданного филиала.
	 * @param affilate филиал
	 * @return список заявок на запчасти
	 */
	public Set<PartOrder> getPartOrders(Affilate affilate);
	
	/**
	 * Метод устанавливает дату поставки запчастей из PartOrder.
	 * @param partOrder заявка на запчасти
	 * @param date дата предпологаемой поставки
	 */
	public void setPartOrderCompleteDate(PartOrder partOrder, Calendar date);

}
