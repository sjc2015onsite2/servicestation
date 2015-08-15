package com.expositds.sjc.servicestation.business.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.MechanicProfileDao;
import com.expositds.sjc.servicestation.business.repository.entity.MechanicProfileEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class MechanicProfileDaoImpl extends AbstractHibernateDao<MechanicProfileEntity, Long>
		implements MechanicProfileDao {

}
