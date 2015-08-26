package com.expositds.sjc.servicestation.business.repository.dao;

import com.expositds.sjc.servicestation.business.repository.base.GenericDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;

/**
 * Интерфейс для работы с AffilateEntity.
 * 
 * @author Alexey Suslov
 *
 */
public interface AffilateDao extends GenericDao<AffilateEntity, Long> {
	
	public AffilateEntity getAffilateByPartOrderId(Long Id);

}
