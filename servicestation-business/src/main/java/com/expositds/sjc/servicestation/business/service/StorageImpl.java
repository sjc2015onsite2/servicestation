package com.expositds.sjc.servicestation.business.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartOrderEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.service.Storage;

/**
 * @author Alexey Suslov
 *
 */
public abstract class StorageImpl implements Storage {
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private ConversionService entityModelConverter;

	@Override
	public Set<PartOrder> getPartOrders(Affilate affilate) {
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		Set<PartOrderEntity> partOrdersEntity = new HashSet<>();
		Set<PartOrder> partOrders = new HashSet<>();

		partOrdersEntity = affilateEntity.getPartOrders().keySet();
		
		for (PartOrderEntity currentPartOrderEntity : partOrdersEntity)
			partOrders.add(entityModelConverter.convert(currentPartOrderEntity, PartOrder.class));
		
		return partOrders;
	}

}
