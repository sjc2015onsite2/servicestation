package com.expositds.sjc.servicestation.business.repository.impl;

import java.util.Map;

import org.hibernate.Session;
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
	
	public Map<OrderEntity, Integer> getOrdersByPage(Long Id, Long page, Long size) {
		
		String hql = ""
		
		return null;
		
	}

}
