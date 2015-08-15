package com.expositds.sjc.servicestation.business.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.StationProfileDao;
import com.expositds.sjc.servicestation.business.repository.entity.StationProfileEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class StationProfileDaoImpl extends AbstractHibernateDao<StationProfileEntity, Long>
		implements StationProfileDao {

}
