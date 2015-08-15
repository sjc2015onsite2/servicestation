package com.expositds.sjc.servicestation.business.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.MarkDao;
import com.expositds.sjc.servicestation.business.repository.entity.MarkEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class MarkDaoImpl extends AbstractHibernateDao<MarkEntity, Long>implements MarkDao {

}
