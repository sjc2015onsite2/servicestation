package com.expositds.sjc.servicestation.buisness.repository.base;

import java.io.Serializable;
import java.util.List;

/**
 * Интерфейс содеожит базовые методы (CRUD) для работы со слоем persistance.
 * 
 * @author Alexey Suslov
 *
 * @param <T> объект над которым происходят CRUD операции.
 * @param <PK> ключ объекта над которыми происходят операции (CRUD).
 */
public interface GenericDao<T, PK extends Serializable> {
	
	/**
	 * Сохраняет объект в хранилище
	 * 
	 * @param obj сохраняемый объект.
	 * @return индентификатор объекта (ключ).
	 */
	PK save(T obj);
	
	/**
	 * Сохраняет изменённый объект в хранилище
	 * 
	 * @param obj изменённый объект.
	 */
	void update(T obj);
	
	/**
	 * Возвращает все объекты указанного типа.
	 * 
	 * @return список объектов заданного типа.
	 */
	List<T> findAll();
	
	/**
	 * Возвращает объект указанного типа по заданному ключу.
	 * 
	 * @param id
	 * @return
	 */
	T findById(PK id);
	
	/**
	 * Удаляет указанный обект по заданному ключу.
	 * 
	 * @param id ключ удаляемого объекта.
	 */
	void delete(PK id);
	
	/**
	 * Удаляет заданный объект.
	 * 
	 * @param persistentObject заданный объект.
	 */
	void delete(T persistentObject);

}
