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
	public List<OrderEntity> getOrdersStationLimit(Long id, Long first, Long size) {
		
		return getSession().getNamedQuery("callGetSiteUserOrdersProc")
						   .setParameter("siteUserId", id)
						   .setParameter("first", first)
	    				   .setParameter("size", size).list();
	}

	@Override
	public Integer getSiteUserOrdersCount(Long id) {
		
		String query = "set @count = 0;"
				+ "call get_site_user_orders_count(:id, @count);"
				+ "select @count;";
		
		return (Integer) getSession().
							createSQLQuery(query).
							setParameter("id", id).
							uniqueResult();
	}

}
