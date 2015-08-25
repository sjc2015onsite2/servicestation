package com.expositds.sjc.servicestation.business.repository.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class OrderDaoImpl extends AbstractHibernateDao<OrderEntity, Long> implements OrderDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrderEntity> getOrdersStationLimit(Long Id, Long first, Long size) {
		
		return getSession().getNamedQuery("callGetSiteUserOrdersProc")
						   .setParameter("siteUserId", Id)
						   .setParameter("first", first)
	    				   .setParameter("size", size).list();
	}

}
