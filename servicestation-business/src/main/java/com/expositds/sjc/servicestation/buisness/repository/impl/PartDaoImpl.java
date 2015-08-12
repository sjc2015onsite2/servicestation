package com.expositds.sjc.servicestation.buisness.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.buisness.repository.dao.PartDao;
import com.expositds.sjc.servicestation.buisness.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.buisness.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class PartDaoImpl extends AbstractHibernateDao<PartEntity, Long> implements PartDao {
	
}
