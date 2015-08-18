package com.expositds.sjc.servicestation.business.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
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
import com.expositds.sjc.servicestation.business.repository.tools.EntityModelConverter;
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
	private EntityModelConverter entityModelConverterTool;
		
	@Override
	public Affilate getAffilateById(String id) {
		return (Affilate) entityModelConverterTool.convert(affilateDao.findById(new Long(id)), Affilate.class);
	}

	@Override
	public AffilateProfile getAffilateProfileById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientNotification getClientNotificationById(String id) {
		return (ClientNotification) entityModelConverterTool.convert(clientNotificationDao.findById(new Long(id)), ClientNotification.class);
	}

	@Override
	public Comment getCommentById(String id) {
		return (Comment) entityModelConverterTool.convert(commentDao.findById(new Long(id)), Comment.class);
	}

	@Override
	public Mark getMarkById(String id) {
		return (Mark) entityModelConverterTool.convert(markDao.findById(new Long(id)), Mark.class);
	}

	@Override
	public MechanicProfile getMechanicProfileById(String id) {
		return (MechanicProfile) entityModelConverterTool.convert(mechanicProfileDao.findById(new Long(id)), MechanicProfile.class);
	}

	@Override
	public Order getOrderId(String id) {
		return (Order) entityModelConverterTool.convert(orderDao.findById(new Long(id)), Order.class);
	}

	@Override
	public Part getPartId(String id) {
		return (Part) entityModelConverterTool.convert(partDao.findById(new Long(id)), Part.class);
	}

	@Override
	public PartOrder getPartOrderById(String id) {
		return (PartOrder) entityModelConverterTool.convert(partOrderDao.findById(new Long(id)), PartOrder.class);
	}

	@Override
	public Person getPersonId(String id) {
		return (Person) entityModelConverterTool.convert(personDao.findById(new Long(id)), Person.class);
	}

	@Override
	public com.expositds.sjc.servicestation.domain.model.Service getServiceId(String id) {
		return (com.expositds.sjc.servicestation.domain.model.Service) entityModelConverterTool.convert(serviceDao.findById(new Long(id)), com.expositds.sjc.servicestation.domain.model.Service.class);
	}

	@Override
	public SiteAggregator getSiteAggregatorById(String id) {
		return (SiteAggregator) entityModelConverterTool.convert(siteAggregatorDao.findById(new Long(id)), SiteAggregator.class);
	}

	@Override
	public SiteUser getSiteUserById(String id) {
		return (SiteUser) entityModelConverterTool.convert(siteUserDao.findById(new Long(id)), SiteUser.class);
	}

	@Override
	public Station getStationById(String id) {
		return (Station) entityModelConverterTool.convert(stationDao.findById(new Long(id)), Station.class);
	}

	@Override
	public StationProfile getStationProfileById(String id) {
		return (StationProfile) entityModelConverterTool.convert(stationProfileDao.findById(new Long(id)), StationProfile.class);
		}

	@Override
	public Logginer getLogginerByName(String name) {
		return (Logginer) entityModelConverterTool.convert(logginerDao.findByName(name), Logginer.class);
	}

	@Override
	public Station getStationByAffilate(Affilate affilate) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		AffilateEntity affilateEntity = affilateDao.findById(affilate.getAffilateId());
		
		for (StationEntity currentStationEntity : siteAggregatorEntity.getStationProfiles().keySet()) 
			if (currentStationEntity.getAffilates().keySet().contains(affilateEntity)) 
				return (Station) entityModelConverterTool.convert(currentStationEntity, Station.class);
		
		return null;
	}

	@Override
	public Affilate getAffilateByMechanic(Person mechanic) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		PersonEntity mechanicEntity = personDao.findById(mechanic.getId());
		
		for (StationEntity currentStationEntity : siteAggregatorEntity.getStationProfiles().keySet()) 
			for (AffilateEntity currentAffilateEntity : currentStationEntity.getAffilates().keySet())
				if (currentAffilateEntity.getPersons().contains(mechanicEntity)) 
					return (Affilate) entityModelConverterTool.convert(currentAffilateEntity, Affilate.class);
		
		return null;
	}

	@Override
	public Station gerStationByOrder(Order order) {
		SiteAggregatorEntity siteAggregatorEntity = siteAggregatorDao.findById(1L);
		OrderEntity orderEntity = orderDao.findById(order.getOrderId());
		
		StationEntity stationEntity = siteAggregatorEntity.getOrders().get(orderEntity);
		
		return (Station) entityModelConverterTool.convert(stationEntity, Station.class);
	}

	
}
