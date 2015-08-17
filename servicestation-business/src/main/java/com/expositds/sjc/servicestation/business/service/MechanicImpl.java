package com.expositds.sjc.servicestation.business.service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.tools.BasicEntityModelObjectConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.OrderStatus;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Identification;
import com.expositds.sjc.servicestation.domain.service.Mechanic;

/**
 * @author Alexey Suslov
 *
 */
public class MechanicImpl extends StoreKeeperImpl implements Mechanic {
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private Identification identificationService;
	
	@Autowired
	private BasicEntityModelObjectConverter basicEntityModelObjectConverter;

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
	public void setOrderStatus(Order order, OrderStatus orderStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setOrderCompletionDate(Order oder, Calendar orderCopmleteDate) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Part, Integer> getPartsQuantity(Affilate affilate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Service, Integer> getServicesCost(Affilate affilate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPartOrder(Person mechanic, Map<Part, Integer> parts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createClientNotification(Order order, String notification) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPartsToOrder(Order order, Map<Part, Integer> parts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addServicesPriceListToOrder(Order order, Map<Service, Integer> servicesPriceList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addServicesToOrder(Order order, Map<Service, Integer> services) {
		// TODO Auto-generated method stub

	}

}
