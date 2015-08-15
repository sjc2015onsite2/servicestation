package com.expositds.sjc.servicestation.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.dao.CommentDao;
import com.expositds.sjc.servicestation.business.repository.dao.LogginerDao;
import com.expositds.sjc.servicestation.business.repository.dao.MarkDao;
import com.expositds.sjc.servicestation.business.repository.dao.MechanicProfileDao;
import com.expositds.sjc.servicestation.business.repository.dao.OrderDao;
import com.expositds.sjc.servicestation.business.repository.dao.PartDao;
import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteAggregatorDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationProfileDao;
import com.expositds.sjc.servicestation.business.repository.tools.BasicEntityModelObjectConverter;
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
public class IdentificationImpl implements Identification {

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
	private BasicEntityModelObjectConverter basicEntityModelObjectConverter;
		
	@Override
	public Affilate getAffilateById(String id) {
		return (Affilate) basicEntityModelObjectConverter.convert(affilateDao.findById(new Long(id)), Affilate.class);
	}

	@Override
	public AffilateProfile getAffilateProfileById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientNotification getClientNotificationById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment getCommentById(String id) {
		return (Comment) basicEntityModelObjectConverter.convert(commentDao.findById(new Long(id)), Comment.class);
	}

	@Override
	public Mark getMarkById(String id) {
		return (Mark) basicEntityModelObjectConverter.convert(markDao.findById(new Long(id)), Mark.class);
	}

	@Override
	public MechanicProfile getMechanicProfileById(String id) {
		return (MechanicProfile) basicEntityModelObjectConverter.convert(mechanicProfileDao.findById(new Long(id)), MechanicProfile.class);
	}

	@Override
	public Order getOrderId(String id) {
		return (Order) basicEntityModelObjectConverter.convert(orderDao.findById(new Long(id)), Order.class);
	}

	@Override
	public Part getPartId(String id) {
		return (Part) basicEntityModelObjectConverter.convert(partDao.findById(new Long(id)), Part.class);
	}

	@Override
	public PartOrder getPartOrderById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getPersonId(String id) {
		return (Person) basicEntityModelObjectConverter.convert(personDao.findById(new Long(id)), Person.class);
	}

	@Override
	public com.expositds.sjc.servicestation.domain.model.Service getServiceId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteAggregator getSiteAggregatorById(String id) {
		return (SiteAggregator) basicEntityModelObjectConverter.convert(siteAggregatorDao.findById(new Long(id)), SiteAggregator.class);
	}

	@Override
	public SiteUser getSiteUserById(String id) {
		return (SiteUser) basicEntityModelObjectConverter.convert(siteUserDao.findById(new Long(id)), SiteUser.class);
	}

	@Override
	public Station getStationById(String id) {
		return (Station) basicEntityModelObjectConverter.convert(stationDao.findById(new Long(id)), Station.class);
	}

	@Override
	public StationProfile getStationProfileById(String id) {
		return (StationProfile) basicEntityModelObjectConverter.convert(stationProfileDao.findById(new Long(id)), StationProfile.class);
		}

	@Override
	public Logginer getLogginerByName(String name) {
		return (Logginer) basicEntityModelObjectConverter.convert(logginerDao.findByName(name), Logginer.class);
	}

	
}
