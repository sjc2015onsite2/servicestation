package com.expositds.sjc.servicestation.business.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartOrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartOrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.tools.BasicEntityModelConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.WorkShop;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class WorkShopImpl extends StorageImpl implements WorkShop {
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private PartOrderDao partOrderDao;
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private BasicEntityModelConverter basicEntityModelObjectConverter;

	@Override
	public Set<Order> getMechanicOrders(Affilate affilate, Person mechanic) {
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		PersonEntity mechanicEntity = personDao.findById(mechanic.getId());
		
		Map<OrderEntity, PersonEntity> affilateOtdersEntity = affilateEntity.getOrders();
		
		Set<Order> orders = new HashSet<>();
		
		for (OrderEntity currentOrderEntity : affilateOtdersEntity.keySet()) {
			if (affilateOtdersEntity.get(currentOrderEntity).equals(mechanicEntity))
				orders.add((Order) basicEntityModelObjectConverter.convert(currentOrderEntity, Order.class));
		}
		
		Station station = identificationService.getStationByAffilate(affilate);
		
		StationEntity stationEntity = stationDao.findById(station.getStationId());
		
		for (OrderEntity currentOrderEntity : stationEntity.getOrders().keySet())
			if (stationEntity.getOrders().get(currentOrderEntity).getAffilateId() == 1)
				orders.add((Order) basicEntityModelObjectConverter.convert(currentOrderEntity, Order.class));
		
		return orders;
	}

	@Override
	public Map<Part, Integer> getPartsQuantity(Affilate affilate) {
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		Map<Part, Integer> parts = new HashMap<>();
		
		for (PartEntity currentPartEntity : affilateEntity.getParts().keySet())
			parts.put((Part) basicEntityModelObjectConverter.convert(currentPartEntity, Part.class), affilateEntity.getParts().get(currentPartEntity));
	
		return parts;
	}

	@Override
	public Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> getServicesCost(Affilate affilate) {
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		Map<com.expositds.sjc.servicestation.domain.model.Service, Integer> services = new HashMap<>();
		
		for (ServiceEntity currentServiceEntity : affilateEntity.getServices().keySet()) {
			
			com.expositds.sjc.servicestation.domain.model.Service service = 
					(com.expositds.sjc.servicestation.domain.model.Service) 
						basicEntityModelObjectConverter.convert(currentServiceEntity, 
							com.expositds.sjc.servicestation.domain.model.Service.class);
			
			services.put(service, affilateEntity.getParts().get(currentServiceEntity));
		}
		return services;
	}

	@Override
	public void giveOrder(Affilate affilate, Person mechanic, Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createPartOrder(Person mechanic, Map<Part, Integer> parts) {
		Affilate affilate = identificationService.getAffilateByMechanic(mechanic);
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		PersonEntity mechanicEntity = personDao.findById(mechanic.getId());
		PartOrderEntity partOrderEntity = new PartOrderEntity();
		
		for (Part currentPart : parts.keySet()) {
			PartEntity currentPartEntity = partDao.findById(currentPart.getPartId());
			partOrderEntity.getParts().put(currentPartEntity, parts.get(currentPart));
		}
		
		affilateEntity.getPartOrders().put(partOrderEntity, mechanicEntity);
		
		partOrderDao.save(partOrderEntity);
		affilateDao.update(affilateEntity);
	}

}
