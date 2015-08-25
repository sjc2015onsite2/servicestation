package com.expositds.sjc.servicestation.business.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class StationDaoImpl extends AbstractHibernateDao<StationEntity, Long> implements StationDao {

	@Override
	public StationEntity getStationByOrderId(Long Id) {
		
		return (StationEntity) getSession().getNamedQuery("callGetStationByUserIdProc")
										   .setParameter("orderId", Id)
									       .uniqueResult();
	}

}
