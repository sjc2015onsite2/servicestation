package com.expositds.sjc.servicestation.buisness.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.buisness.repository.dao.StationDao;
import com.expositds.sjc.servicestation.buisness.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.buisness.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class StationDaoImpl extends AbstractHibernateDao<StationEntity, Long> implements StationDao {



}
