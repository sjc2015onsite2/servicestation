package com.expositds.sjc.servicestation.business.repository.dao;

import com.expositds.sjc.servicestation.business.repository.base.GenericDao;
import com.expositds.sjc.servicestation.business.repository.entity.LogginerEntity;

/**
 * Метод для работы с Logginer.
 * 
 * @author Alexey Suslov
 *
 */
public interface LogginerDao extends GenericDao<LogginerEntity, Long> {
	
	LogginerEntity findByName(String name);

}
