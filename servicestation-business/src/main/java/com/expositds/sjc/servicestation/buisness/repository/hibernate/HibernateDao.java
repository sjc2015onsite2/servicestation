package com.expositds.sjc.servicestation.buisness.repository.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;

import com.expositds.sjc.servicestation.buisness.repository.base.GenericDao;

/**
 * Данный интерфес расширяет GenericDao методами Hibernate.
 * 
 * @author Alexey Suslov
 *
 * @param <T> объект над которым происходят CRUD операции.
 * @param <PK> ключ объекта над которыми происходят операции (CRUD).
 */
public interface HibernateDao<T, PK extends Serializable> extends GenericDao<T, PK> {
	
	/**
	 * Возвращает объект соответствующие ритерию.
	 * 
	 * @param criterion критерий.
	 * @return список объекто, удовлетворяющих критерию.
	 */
	List<T> findByCriteria(Criterion criterion);
	
}
