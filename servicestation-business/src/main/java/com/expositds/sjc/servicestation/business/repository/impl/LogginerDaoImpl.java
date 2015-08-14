package com.expositds.sjc.servicestation.business.repository.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.LogginerDao;
import com.expositds.sjc.servicestation.business.repository.entity.LogginerEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

@Repository
public class LogginerDaoImpl extends AbstractHibernateDao<LogginerEntity, Long> implements LogginerDao {

	@Override
	public LogginerEntity findByName(String name) {
		Criteria cr = getSession()
				.createCriteria(LogginerEntity.class, "logginers")
				.add(Restrictions.like("login", name));
		return (LogginerEntity) cr.uniqueResult();
	}

	
}
