package com.expositds.sjc.servicestation.domain.service;

import java.util.Map;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для взаимодействия с моделью данных в области контроля качества.
 * 
 * @author Alexey Suslov
 */
public interface QualityControl {
	
	/**
	 * Метод возвращает коментарии заданного СТО.
	 * @param seviceStation СТО
	 * @return список комментариев
	 */
	public Set<Comment> getServiceStationComments(Station seviceStation);

	/**
	 * Метод возвращает список механиков заданного СТО с персональным списком коментариев механиков.
	 * @param seviceStation СТО
	 * @return список механиков СТО с персональным списком коментариев механиков
	 */
	public Map<Person, Set<Comment>> getMechanicsComments(Station seviceStation);

	/**
	 * Метод возвращает список оценок заданного СТО.
	 * @param seviceStation СТО
	 * @return список оценок СТО
	 */
	public Set<Mark> getServiceStationMarks(Station seviceStation);

}
