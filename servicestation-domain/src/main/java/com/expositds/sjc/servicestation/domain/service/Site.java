package com.expositds.sjc.servicestation.domain.service;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для взаимодействия пользователя сайта и сайта-агрегатора.
 * 
 * @author Alexey Suslov
 */
public interface Site {
	
	/**
	 * Метод создаёт заказ для с указанной проблемой с указанным СТО.
	 * @param problemDescription описание проблеммы
	 * @param serviceStation СТО
	 * @return заявка
	 */
	public Order createOrder(String problemDescription, Station serviceStation);

	/**
	 * Метод меняет СТО для выполнения заявки.
	 * @param order заявка
	 * @param newServiceStation новая СТО 
	 */
	public void changeServiceStation(Order order, Station newServiceStation);

	/**
	 * Метод публикует заданный комментарий о заданном СТО.
	 * @param serviceStation СТО
	 * @param comment комментарий
	 */
	public void publicServiceStationComment(Station serviceStation, Comment comment);
	
	/**
	 * Метод публикует заданный комментарий о заданном механике.
	 * @param mechanic механик
	 * @param comment комментарий
	 */
	public void publicMechanicComment(Person mechanic, Comment comment);

	/**
	 * Метод создаёт оценку с указанием в ней указанного пользователя сайта.
	 * @param user пользователь сайта
	 * @param markValue оценка
	 * @return экземплыр класса Mark
	 */
	public Mark createMark(SiteUser user, Integer markValue);
	
	/**
	 * Метод создаёт комментарий с указанием в нем указанного пользователя сайта.
	 * @param user пользователь сайта
	 * @param comment комментарий
	 * @param visible виден ли комментарий всем посетителям сайта
	 * @return экземпляр класса Comment
	 */
	public Comment createComment(SiteUser user, String comment, boolean visible);
	
	/**
	 * Метод публикует оценку о станции.
	 * @param station СТО
	 * @param mark оценка
	 */
	public void publicMark(Station station, Mark mark);
	
}
