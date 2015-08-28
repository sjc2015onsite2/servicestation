package com.expositds.sjc.servicestation.business.repository.dao;

import java.util.List;

import com.expositds.sjc.servicestation.business.repository.base.GenericDao;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;

/**
 * Интерфейс для работы с OrderEntity.
 * 
 * @author Alexey Suslov
 *
 */
public interface OrderDao extends GenericDao<OrderEntity, Long> {
	
	public List<OrderEntity> getOrdersStationLimit(Long id, Long first, Long size);
	
	public Long getSiteUserOrdersCount(Long id);

}
