package com.expositds.sjc.servicestation.business.repository.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class OrderDaoImpl extends AbstractHibernateDao<OrderEntity, Long> implements OrderDao {
	
	public Map<OrderEntity, Integer> getOrdersStationLimit(Long Id, Long first, Long size) {
		
		Session session = getSession();
		
		String stationSqlQuery = "call get_station_by_order_id(?)";
		
		@SuppressWarnings("unchecked")
		List<OrderEntity> ordersEntity = session.getNamedQuery("callGetSiteUserOrdersProc")
												.setParameter("siteUserId", Id)
												.setParameter("first", first)
												.setParameter("size", size).list();
		
		for (OrderEntity currentOrderEntity : ordersEntity) {
			StationEntity currentStationEntity = (StationEntity) session.createSQLQuery(stationSqlQuery).setParameter(0, currentOrderEntity.getOrderId()).uniqueResult();
		}
		
		return null;
		
	}

}
