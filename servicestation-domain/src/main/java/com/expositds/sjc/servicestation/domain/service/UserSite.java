package com.expositds.sjc.servicestation.domain.service;

import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Данный интерфейс предоставляет как авторизованному так и неавторизованному пользователям сайта набор методов для работы с сайтом.
 * 
 * @author Alexey Suslov
 */
public interface UserSite {

	/**
	 * Метод возвращает список комментариев о заданном механике.
	 * @param mechanic механик
	 * @return список комментариев
	 */
	public Set<Comment> getMechanicComments(Person mechanic);

	/**
	 * Метод возвращает список оценок о заданной СТО.
	 * @param serviceStation СТО
	 * @return список оценок
	 */
	public Set<Mark> getServiceStationMark(Station serviceStation);

	/**
	 * Метод возвращает список СТО.
	 * @return список СТО
	 */
	public Set<Station> getServiceStations();

	/**
	 * Метод возвращает список механиков заданной СТО.
	 * @param serviceStation СТО
	 * @return список механиков
	 */
	public Set<Person> getServiceStationMechanics(Station serviceStation);

	/**
	 * Метод возвращает список отзывов о заданной СТО.
	 * @param serviceStation СТО
	 * @return списоу отзывов
	 */
	public Set<Comment> getServiceStationComments(Station serviceStation);

}
