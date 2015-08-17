package com.expositds.sjc.servicestation.domain.service;

import java.util.Map;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;

/**
 * Интерфейс предоставляет набор методов для внешнего взаимоднйствия с моделью данных в области функционала 
 * авторизированного пользователя.
 * 
 * @author Alexey Suslov
 */
public interface AuthorizedUserSite extends UserSite {

	/**
	 * Метод возвращает список заявок в соответствии с станцией заданного пользователя.
	 * @param user пользователь сайта
	 * @return список заявок
	 */
	public Map<Order, Station> getOrders(SiteUser user);

	/**
	 * Метод создаёт заказ для указанного пользователя с указанной проблемой с указанным СТО.
	 * @param user пользователь сайта
	 * @param problemDescription описание проблемы
	 * @param serviceStation СТО
	 */
	public void createOrder(SiteUser user, String problemDescription, Station serviceStation);

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
	 * Метод публикует заданную оценку заданного СТО.
	 * @param serviceStation СТО
	 * @param mark оценка
	 */
	public void publicMark(Station serviceStation, Mark mark);

	/**
	 * Метод создаёт оценку с указанием в ней указанного пользователя сайта.
	 * @param user пользователь сайта
	 * @param markValue оценка
	 * @return экземплыр класса Mark
	 */
	public Mark createMark(SiteUser user, Integer markValue);

	/**
	 * Метод создаёт комментарий с указанием в ней указанного пользователя сайта.
	 * @param user пользователь сайта
	 * @param comment комментарий
	 * @param visible визимость для всех пользователй сайта
	 * @return экземпляр класса Comment
	 */
	public Comment createComment(SiteUser user, String comment, boolean visible);

	/**
	 * Метод публикует заданный комментарий о заданном механике.
	 * @param mechanic механик
	 * @param comment комментарий
	 */
	public void publicMechanicComment(Person mechanic, Comment comment);

}
