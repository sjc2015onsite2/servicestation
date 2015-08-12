package com.expositds.sjc.servicestation.buisness.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.buisness.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.buisness.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.buisness.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.buisness.repository.tools.BasicEntityModelObjectConverter;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;

/**
 * Реализует интерфейс AuthorizedUserSite.
 * 
 * @author Rybakov Sergey
 *
 */

@Service
@Transactional
public class AuthorizedUserSiteImpl extends SiteUserImpl implements AuthorizedUserSite{

	@Autowired
	private SiteUserDao siteUserDao;
	
	@Autowired
	private BasicEntityModelObjectConverter basicEntityModelObjectConverterTool;
	
	@Override
	public Map<Order, Station> getOrders(SiteUser user) {
		Map<OrderEntity, StationEntity> ordersEntity = siteUserDao.findById(user.getSiteUserId()).getOrders();
		
		Map<Order, Station> ordersModel = new HashMap<>();
		
		for (OrderEntity currentOrderEntity : ordersEntity.keySet()) {
			Order currentOrder = (Order) basicEntityModelObjectConverterTool.convert(currentOrderEntity, Order.class);
			StationEntity currentStationEntity = ordersEntity.get(currentOrderEntity);
			Station currentStation = (Station) basicEntityModelObjectConverterTool.convert(currentStationEntity, Station.class);
			ordersModel.put(currentOrder, currentStation);
		}
		
		return ordersModel;
	}

	@Override
	public void createOrder(SiteUser user, String problemDescription,
			Station serviceStation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeServiceStation(Order order, Station newServiceStation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publicServiceStationComment(Station serviceStation,
			Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publicMark(Station serviceStation, Mark mark) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mark createMark(SiteUser user, Integer markValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Station> getContactorServiceStations(SiteUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment createComment(SiteUser user, String comment, boolean visible) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void publicMechanicComment(Person mechanic, Comment comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Person> getContactorMechanic(SiteUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout(SiteUser user) {
		// TODO Auto-generated method stub
		
	}
}
