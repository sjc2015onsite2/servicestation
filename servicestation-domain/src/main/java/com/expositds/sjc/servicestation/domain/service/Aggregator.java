package com.expositds.sjc.servicestation.domain.service;

import java.util.Map;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет методы для работы с сайтом в области взаимодействия с СТО
 * 
 * @author Alexey Suslov
 */
public interface Aggregator {
	
	/**
	 * Метод возвращает все коментарии заданного СТО.
	 * @param seviceStation СТО
	 * @return список комментариев
	 */
	public Set<Comment> getServiceStationAllComments(Station seviceStation);

	/**
	 * Метод возвращает список механиков заданного СТО с персональным списком всех коментариев механиков.
	 * @param serviceStation СТО
	 * @return список механиков заданного СТО с персональным списком всех коментариев механиков
	 */
	public Map<Person, Set<Comment>> getMechanicsAllComments(Station serviceStation);

	/**
	 * Метод возвращает список оценок заданного СТО.
	 * @param seviceStation СТО
	 * @return список оценок заданного СТО
	 */
	public Set<Mark> getServiceStationMarks(Station seviceStation);

}
