package com.expositds.sjc.servicestation.domain.service;

import java.util.Map;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для работы с СТО в области контроля качества.
 * 
 * @author Alexey Suslov
 */
public interface QualityDepartment {
	
	/**
	 * Метод возвращает список оценок заданного СТО.
	 * @param seviceStation СТО
	 * @return список оценок
	 */
	public Set<Mark> getServiceStationMarks(Station seviceStation);

	/**
	 * Метод возвращает все коментарии заданного СТО.
	 * @param seviceStation СТО
	 * @return список комментариев
	 */
	public Set<Comment> getServiceStationComments(Station seviceStation);

	/**
	 * Метод возвращает список механиков заданного СТО с персональным списком всех коментариев механиков.
	 * @param seviceStation СТО
	 * @return список сотрудников и из персональными списками оценок
	 */
	public Map<Person, Set<Comment>> getMechanicsComments(Station seviceStation);

}
