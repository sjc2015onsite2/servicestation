package com.expositds.sjc.servicestation.business.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.AffilateProfileDao;
import com.expositds.sjc.servicestation.business.repository.dao.ClientNotificationDao;
import com.expositds.sjc.servicestation.business.repository.dao.CommentDao;
import com.expositds.sjc.servicestation.business.repository.dao.LogginerDao;
import com.expositds.sjc.servicestation.business.repository.dao.MarkDao;
import com.expositds.sjc.servicestation.business.repository.dao.MechanicProfileDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartOrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.dao.ServiceDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteAggregatorDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationProfileDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.entity.OrderEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.SiteAggregatorEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.service.converters.AffilateEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.AffilateProfileEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.ClientNotificationEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.CommentEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.LogginerEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.MarkEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.MechanicProfileEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.OrderEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.PartEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.PartOrderEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.PersonEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.ServiceEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.SiteAggregatorEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.SiteUserEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.StationEntityModelConverter;
import com.expositds.sjc.servicestation.business.service.converters.StationProfileEntityModelConverter;
import com.expositds.sjc.servicestation.domain.model.Affilate;
import com.expositds.sjc.servicestation.domain.model.AffilateProfile;
import com.expositds.sjc.servicestation.domain.model.ClientNotification;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Logginer;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.MechanicProfile;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.SiteAggregator;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.model.StationProfile;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class IdentificationImpl implements Identification, Serializable {

	private static final long serialVersionUID = 3213650922607892651L;

	@Autowired
	private AffilateDao affilateDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private PartDao partDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private SiteAggregatorDao siteAggregatorDao; 
	
	@Autowired
	private SiteUserDao siteUserDao;
	
	@Autowired
	private LogginerDao logginerDao;
	
	@Autowired
	private StationProfileDao stationProfileDao;
	
	@Autowired
	private MarkDao markDao;
	
	@Autowired
	private MechanicProfileDao mechanicProfileDao;
	
	@Autowired
	private PartOrderDao partOrderDao;
	
	@Autowired
	private ClientNotificationDao clientNotificationDao;
	
	@Autowired
	private ServiceDao serviceDao;
	
	@Autowired
	private AffilateProfileDao affilateProfileDao;
	
	private AffilateEntityModelConverter affilateEntityModelConverter = new AffilateEntityModelConverter();
	private AffilateProfileEntityModelConverter affilateProfileEntityModelConverter = new AffilateProfileEntityModelConverter();
	private ClientNotificationEntityModelConverter clientNotificationEntityModelConverter = new ClientNotificationEntityModelConverter();
	private CommentEntityModelConverter commentEntityModelConverter = new CommentEntityModelConverter();
	private MarkEntityModelConverter markEntityModelConverter = new MarkEntityModelConverter();
	private MechanicProfileEntityModelConverter mechanicProfileEntityModelConverter = new MechanicProfileEntityModelConverter();
	private OrderEntityModelConverter orderEntityModelConverter = new OrderEntityModelConverter();
	private PartEntityModelConverter partEntityModelConverter = new PartEntityModelConverter();
	private PartOrderEntityModelConverter partOrderEntityModelConverter = new PartOrderEntityModelConverter();
	private PersonEntityModelConverter personEntityModelConverter = new PersonEntityModelConverter();
	private ServiceEntityModelConverter serviceEntityModelConverter = new ServiceEntityModelConverter();
	private SiteAggregatorEntityModelConverter siteAggregatorEntityModelConverter = new SiteAggregatorEntityModelConverter();
	private SiteUserEntityModelConverter siteUserEntityModelConverter = new SiteUserEntityModelConverter();
	private StationEntityModelConverter stationEntityModelConverter = new StationEntityModelConverter(); 
	private StationProfileEntityModelConverter stationProfileEntityModelConverter = new StationProfileEntityModelConverter();
	private LogginerEntityModelConverter logginerEntityModelConverter = new LogginerEntityModelConverter();
	
	@Override
	public Affilate getAffilateById(String id) {
		return affilateEntityModelConverter.convert(affilateDao.findById(new Long(id)));
	}

	@Override
	public AffilateProfile getAffilateProfileById(String id) {
		return affilateProfileEntityModelConverter.convert(affilateProfileDao.findById(new Long(id)));
	}

	@Override
	public ClientNotification getClientNotificationById(String id) {
		return clientNotificationEntityModelConverter.convert(clientNotificationDao.findById(new Long(id)));
	}

	@Override
	public Comment getCommentById(String id) {
		return commentEntityModelConverter.convert(commentDao.findById(new Long(id)));
	}

	@Override
	public Mark getMarkById(String id) {
		return markEntityModelConverter.convert(markDao.findById(new Long(id)));
	}

	@Override
	public MechanicProfile getMechanicProfileById(String id) {
		return mechanicProfileEntityModelConverter.convert(mechanicProfileDao.findById(new Long(id)));
	}

	@Override
	public Order getOrderId(String id) {
		return orderEntityModelConverter.convert(orderDao.findById(new Long(id)));
	}

	@Override
	public Part getPartById(String id) {
		return partEntityModelConverter.convert(partDao.findById(new Long(id)));
	}

	@Override
	public PartOrder getPartOrderById(String id) {
		return partOrderEntityModelConverter.convert(partOrderDao.findById(new Long(id)));
	}

	@Override
	public Person getPersonById(String id) {
		return personEntityModelConverter.convert(personDao.findById(new Long(id)));
	}

	@Override
	public com.expositds.sjc.servicestation.domain.model.Service getServiceById(String id) {
		return serviceEntityModelConverter.convert(serviceDao.findById(new Long(id)));
	}

	@Override
	public SiteAggregator getSiteAggregatorById(String id) {
		return siteAggregatorEntityModelConverter.convert(siteAggregatorDao.findById(new Long(id)));
	}

	@Override
	public SiteUser getSiteUserById(String id) {
		return siteUserEntityModelConverter.convert(siteUserDao.findById(new Long(id)));
	}

	@Override
	public Station getStationById(String id) {
		return stationEntityModelConverter.convert(stationDao.findById(new Long(id)));
	}

	@Override
	public StationProfile getStationProfileById(String id) {
		return stationProfileEntityModelConverter.convert(stationProfileDao.findById(new Long(id)));
	}

	@Override
	public Logginer getLogginerByName(String name) {
		return logginerEntityModelConverter.convert(logginerDao.findByName(name));
	}

	@Override
	public Station getStationByAffilate(Affilate affilate) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		
		for (StationEntity currentStationEntity : siteAggregatorEntity.getStationProfiles().keySet()) 
			if (currentStationEntity.getAffilates().keySet().contains(affilateEntity)) 
				return stationEntityModelConverter.convert(currentStationEntity);
		
		return null;
	}

	@Override
	public Affilate getAffilateByMechanic(Person mechanic) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		PersonEntity mechanicEntity = personDao.findById(mechanic.getId());
		
		for (StationEntity currentStationEntity : siteAggregatorEntity.getStationProfiles().keySet()) 
			for (AffilateEntity currentAffilateEntity : currentStationEntity.getAffilates().keySet())
				if (currentAffilateEntity.getPersons().contains(mechanicEntity)) 
					return affilateEntityModelConverter.convert(currentAffilateEntity);
		
		return null;
	}

	@Override
	public Station getStationByOrder(Order order) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		StationEntity stationEntity = siteAggregatorEntity.getOrders().get(orderEntity);
		
		return stationEntityModelConverter.convert(stationEntity);
	}

	@Override
	public Person getMechanicByOrder(Order order) {
		Station station = getStationByOrder(order);
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		StationEntity stationEntity = stationDao.findById(station.getStationId());
		
		for (AffilateEntity currentAffilateEntity : stationEntity.getAffilates().keySet())
			if (currentAffilateEntity.getOrders().containsKey(orderEntity))
				return personEntityModelConverter.convert(
						currentAffilateEntity.getOrders().get(orderEntity));
		
		return null;
	}
	
}