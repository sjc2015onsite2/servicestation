package com.expositds.sjc.servicestation.domain.service;

import java.util.Calendar;
import java.util.Map;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Person;

/**
 * Интерфейс предоставляет набор методов для взаимодействия с моделью данных в области построения отчётов и ввода первичной информации.
 * 
 * @author Alexey Suslov
 */
public interface Financial extends Reportable {
	
	/**
	 * Устанавливает арендную плату заданому филиалу в заданую дату. Устанавливается дневная арендная плата.
	 * @param affilate филиал
	 * @param rentValue величина арендной платы в день
	 */
	public void setAffilateRent(Affilate affilate, Map<Calendar, Integer> rentValue);

	/**
	 * Устанавливает заработную плату заданому сотруднику в заданную дату. Устанавливается дневная заработная плата.
	 * @param employee сотрудник
	 * @param salaryValue величина зароботной платы в день
	 */
	public void setSalary(Person employee, Map<Calendar, Integer> salaryValue);

}
