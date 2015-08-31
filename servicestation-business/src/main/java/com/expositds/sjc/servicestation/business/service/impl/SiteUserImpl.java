package com.expositds.sjc.servicestation.business.service.impl;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.business.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.business.repository.dao.SiteAggregatorDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.CommentEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MarkEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MechanicProfileEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationProfileEntity;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.ServiceStation;
import com.expositds.sjc.servicestation.domain.service.UserSite;

/**
 * @author Alexey Suslov
 *
 */
@Transactional
public abstract class SiteUserImpl implements UserSite {

	@Autowired
	private SiteAggregatorDao siteAggregatorDao;
	
	@Autowired
	private StationDao serviceStationDao;
	
	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private ServiceStation serviceStationService;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public Set<Comment> getMechanicComments(Person mechanic) {
		Map<PersonEntity, MechanicProfileEntity> mechanicsEntity = siteAggregatorDao.findById(1L).getMechanicPofiles();
		PersonEntity personEntity = personDao.findById(mechanic.getId());
		MechanicProfileEntity mechanicProfileEntity = mechanicsEntity.get(personEntity);
		Set<CommentEntity> commentsEntity = mechanicProfileEntity.getComments();
		
		Set<Comment> commentsModel = new HashSet<>();
		
		for (CommentEntity currentCommentEntity : commentsEntity) {
			if (currentCommentEntity.isVisible())
				commentsModel.add(conversionService.convert(currentCommentEntity, Comment.class));
		}
		
		return commentsModel;
	}

	@Override
	public Set<Mark> getServiceStationMark(Station serviceStation) {
		
		Map<StationEntity, StationProfileEntity> stationsEntity = siteAggregatorDao.findById(1L).getStationProfiles();
		StationEntity stationEntity = serviceStationDao.findById(serviceStation.getStationId());
		StationProfileEntity stationProfileEntity = stationsEntity.get(stationEntity);
		Set<MarkEntity> marksEntity = stationProfileEntity.getMarks();
		
		Set<Mark> marksModel = new HashSet<>();
		
		for (MarkEntity currentMarkEntity : marksEntity) {
			marksModel.add(conversionService.convert(currentMarkEntity, Mark.class));
		}
		
		return marksModel;
	}

	@Override
	public Set<Station> getServiceStations() {
		
		Set<Station> stationsModel = new HashSet<>();
		Set<StationEntity> stationsEntity = siteAggregatorDao.findById(1L).getStationProfiles().keySet();
		
		for (StationEntity currentStationEntity : stationsEntity) {
			stationsModel.add(conversionService.convert(currentStationEntity, Station.class));
		}
				
		return stationsModel;
	}

	@Override
	public Set<Person> getServiceStationMechanics(Station serviceStation) {
		return serviceStationService.getMechanics(serviceStation);
	}

	@Override
	public Set<Comment> getServiceStationComments(Station serviceStation) {
		
		Map<StationEntity, StationProfileEntity> stationsEntity = siteAggregatorDao.findById(1L).getStationProfiles();
		StationEntity stationEntity = serviceStationDao.findById(serviceStation.getStationId());
		StationProfileEntity stationProfileEntity = stationsEntity.get(stationEntity);
		Set<CommentEntity> commentsEntity = stationProfileEntity.getComments();
		
		Set<Comment> commentsModel = new HashSet<>();
		
		for (CommentEntity currentCommentEntity : commentsEntity) {
			if (currentCommentEntity.isVisible())
				commentsModel.add(conversionService.convert(currentCommentEntity, Comment.class));
		}
		
		return commentsModel;
	}
	
	@Override
	public Double getAverageStationMark(Station station) {
		Set<Mark> stationMarks = getServiceStationMark(station);
		Double summMark = 0.0;
		for (Mark currentMark : stationMarks) 
			summMark = summMark + currentMark.getMark();
		return summMark / stationMarks.size();
	}
	
}
