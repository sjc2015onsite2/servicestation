package com.expositds.sjc.servicestation.business.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.expositds.sjc.servicestation.business.repository.dao.PartDao;
import com.expositds.sjc.servicestation.business.repository.dao.ServiceDao;
import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.business.repository.tools.ModelEntityConverter;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Service;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class ModelEntityConverterImpl implements ModelEntityConverter {
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private ServiceDao serviceDao;

	@Override
	public Map<PartEntity, Integer> mapPartIntegerConvert(Map<Part, Integer> partMap) {
		Map<PartEntity, Integer> partEntityMap = new HashMap<>();
		
		for (Part currentPart : partMap.keySet()) {
			PartEntity currentPartEntity = partDao.findById(currentPart.getPartId());
			partEntityMap.put(currentPartEntity, partMap.get(currentPart));
		}
		
		return partEntityMap;
	}

	@Override
	public Map<ServiceEntity, Integer> mapServiceIntegerConverter(Map<Service, Integer> serviceMap) {
		Map<ServiceEntity, Integer> serviceEntityMap = new HashMap<>();
		
		for (Service currentService : serviceMap.keySet()) {
			ServiceEntity currentServiceEntity = serviceDao.findById(currentService.getServiceId());
			serviceEntityMap.put(currentServiceEntity, serviceMap.get(currentService));
		}
		
		return serviceEntityMap;
	}

	@Override
	public List<ServiceEntity> listServiceConverter(List<Service> serviceList) {
		List<ServiceEntity> serviceEntityList = new ArrayList<>();
		
		for (Service currentService : serviceList) {
			ServiceEntity currentServiceEntity = serviceDao.findById(currentService.getServiceId());
			serviceEntityList.add(currentServiceEntity);
		}
		
		return serviceEntityList;
	}

}
