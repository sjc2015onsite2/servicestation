package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartOrderDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartOrderEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Storage;
import com.expositds.sjc.servicestation.domain.service.StoreKeeper;

/**
 * @author Alexey Suslov
 *
 */
@Transactional
public abstract class StoreKeeperImpl implements StoreKeeper {

	@Autowired
	private Storage storageService;
	
	@Autowired
	private Identification identification;
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private PartOrderDao partOrderDao;
	
	@Override
	public Set<PartOrder> getPartOrders(Affilate affilate) {
		return storageService.getPartOrders(affilate);
	}

	@Override
	public void setPartOrderStatus(PartOrder partOrder, PartOrderStatus newPartOrderStatus) {
		PartOrderEntity partOrderEntity = partOrderDao.findById(partOrder.getPartOrderId());
		
		partOrderEntity.setStatus(newPartOrderStatus);
		
		if (newPartOrderStatus.equals(PartOrderStatus.READY)) {
			Affilate affilate = identification.getAffilateByPartOrder(partOrder);
			AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
			
			Integer currentPartCountAtStore;
			Integer currentPartCountAtPartOrder;
			for (PartEntity currentPartEntity : partOrderEntity.getParts().keySet()) {
				currentPartCountAtStore = affilateEntity.getParts().get(currentPartEntity);
				currentPartCountAtPartOrder = partOrderEntity.getParts().get(currentPartEntity);
				affilateEntity.getParts().put(currentPartEntity, currentPartCountAtPartOrder + currentPartCountAtStore);
			}
		}
		
	//	partOrderDao.update(partOrderEntity);

	}
	
	@Override
	public void setPartOrderCompleteDate(PartOrder partOrder, Calendar date) {
		PartOrderEntity partOrderEntity = partOrderDao.findById(partOrder.getPartOrderId());
		
		partOrderEntity.setDate(date);
		
		partOrderDao.update(partOrderEntity);
		
	};

}
