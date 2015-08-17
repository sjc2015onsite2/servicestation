package com.expositds.sjc.servicestation.domain.service;

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
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.SiteAggregator;
import com.expositds.sjc.servicestation.domain.model.SiteUser;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.model.StationProfile;

/**
 * Интерфейс предоставляет набор методов для идентификации объектов по ключу, имени.
 * 
 * @author Alexey Suslov
 *
 */
public interface Identification {
	
	public Affilate getAffilateById(String id);
	
	public AffilateProfile getAffilateProfileById(String id);
	
	public ClientNotification getClientNotificationById(String id);
	
	public Comment getCommentById(String id);
	
	public Mark getMarkById(String id);
	
	public MechanicProfile getMechanicProfileById(String id);
	
	public Order getOrderId(String id);
	
	public Part getPartId(String id);
	
	public PartOrder getPartOrderById(String id);
	
	public Person getPersonId(String id);
	
	public Service getServiceId(String id);
	
	public SiteAggregator getSiteAggregatorById(String id);
	
	public SiteUser getSiteUserById(String id);
	
	public Station getStationById(String id);
	
	public StationProfile getStationProfileById(String id);
	
	public Logginer getLogginerByName(String name);
	
	public Station getStationByAffilate(Affilate affilate);

}
