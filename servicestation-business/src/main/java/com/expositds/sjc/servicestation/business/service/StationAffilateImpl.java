package com.expositds.sjc.servicestation.business.service;

import java.util.Set;

import org.springframework.stereotype.Service;

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

	@Override
	public void deleteOrder(Affilate affilate, Order order) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<Person> getAffiliateMechanics(Affilate affiliate) {
		// TODO Auto-generated method stub
		return null;
	}

}
