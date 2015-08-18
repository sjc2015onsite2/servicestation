package com.expositds.sjc.servicestation.business.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.tools.BasicEntityModelConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.service.StationAffilate;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class StationAffilateImpl implements StationAffilate {
	
	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private BasicEntityModelConverter entityModelObjectConverter;

	@Override
	public void deleteOrder(Affilate affilate, Order order) {
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		affilateEntity.getOrders().remove(orderEntity);
		
		affilateDao.update(affilateEntity);

	}

	@Override
	public Set<Person> getAffiliateMechanics(Affilate affiliate) {
		AffilateEntity affilateEntity = affilateDao.findById(affiliate.getAffilateId());
		Set<PersonEntity> mechanicsEntity = affilateEntity.getPersons();
		
		Set<Person> mechanics = new HashSet<>();
		for (PersonEntity currentMechanicEntity : mechanicsEntity) {
			mechanics.add((Person) entityModelObjectConverter.convert(currentMechanicEntity, Person.class));
		}
		
		return mechanics;
	}

}
