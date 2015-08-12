package com.expositds.sjc.servicestation.domain.service;

import java.util.Map;

import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Position;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для внешнего взаимоднйствия с моделью данных в области функционала 
 * неавторизированного пользователя и СТО.
 * 
 * @author Alexey Suslov
 */
public interface NonAuthrizedPersonStation {
	
	/**
	 * Метод возвращает сотрудника и его должность заданного СТО по заданному логину и заданному паролю.
	 * @param serviceStation СТО
	 * @param login логин
	 * @param password пароль
	 * @return список из одного сотрудника и его должности
	 */
	public Map<Person, Position> getPerson(Station serviceStation, String login, String password);

}
