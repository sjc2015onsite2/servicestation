package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.Set;

import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;
import com.expositds.sjc.servicestation.domain.service.Storage;

public abstract class StorageImpl implements Storage {

	@Override
	public void setPartOrderStatus(PartOrder partOrder, PartOrderStatus newPartOrderStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<PartOrder> getPartOrders(Affilate affilate) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setPartOrderCompleteDate(PartOrder partOrder, Calendar date) {
		// TODO Auto-generated method stub
		
	}

}
