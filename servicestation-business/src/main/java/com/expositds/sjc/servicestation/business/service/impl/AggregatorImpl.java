package com.expositds.sjc.servicestation.business.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.business.repository.dao.SiteAggregatorDao;
import com.expositds.sjc.servicestation.business.repository.dao.StationDao;
import com.expositds.sjc.servicestation.business.repository.entity.CommentEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MarkEntity;
import com.expositds.sjc.servicestation.business.repository.entity.MechanicProfileEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationEntity;
import com.expositds.sjc.servicestation.business.repository.entity.StationProfileEntity;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.LogginerRole;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Aggregator;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class AggregatorImpl implements Aggregator {
	
	@Autowired
	private SiteAggregatorDao siteAggregatorDao;
	
	@Autowired
	private StationDao stationDao;
	
	@Autowired
	private ConversionService conversionService;
	
	@Override
	public Set<Comment> getServiceStationAllComments(Station seviceStation) {
		Map<StationEntity, StationProfileEntity> stationsEntity = siteAggregatorDao.findById(1L).getStationProfiles();
		StationEntity stationEntity = stationDao.findById(seviceStation.getStationId());
		StationProfileEntity stationProfileEntity = stationsEntity.get(stationEntity);
		Set<CommentEntity> commentsEntity = stationProfileEntity.getComments();
		
		Set<Comment> commentsModel = new HashSet<>();
		
		for (CommentEntity currentCommentEntity : commentsEntity) 
			commentsModel.add(conversionService.convert(currentCommentEntity, Comment.class));
		
		return commentsModel;
	}

	@Override
	public Map<Person, Set<Comment>> getMechanicsAllComments(Station serviceStation) {
		StationEntity stationEntity = stationDao.findById(serviceStation.getStationId());
		
		Map<Person, Set<Comment>> comments = new HashMap<>();
		
		for (PersonEntity currentPersonEntity : stationEntity.getPersons())
			if (currentPersonEntity.getRole().equals(LogginerRole.MECHANIC))
				comments.put(conversionService.convert(currentPersonEntity, Person.class), 
						getMechanicComments(currentPersonEntity));
		
		return comments;
	}

	@Override
	public Set<Mark> getServiceStationMarks(Station seviceStation) {
		Map<StationEntity, StationProfileEntity> stationsEntity = siteAggregatorDao.findById(1L).getStationProfiles();
		StationEntity stationEntity = stationDao.findById(seviceStation.getStationId());
		StationProfileEntity stationProfileEntity = stationsEntity.get(stationEntity);
		
		Set<Mark> marks = new HashSet<>();
		
		for (MarkEntity currentMark : stationProfileEntity.getMarks())
			marks.add(conversionService.convert(currentMark, Mark.class));
		
		return marks;
	}

	private Set<Comment> getMechanicComments(PersonEntity mechanicEntity) {
		Map<PersonEntity, MechanicProfileEntity> mechanicsEntity = siteAggregatorDao.findById(1L).getMechanicPofiles();
		MechanicProfileEntity mechanicProfileEntity = mechanicsEntity.get(mechanicEntity);
		Set<CommentEntity> commentsEntity = mechanicProfileEntity.getComments();
		
		Set<Comment> commentsModel = new HashSet<>();
		
		for (CommentEntity currentCommentEntity : commentsEntity) 
			commentsModel.add(conversionService.convert(currentCommentEntity, Comment.class));
		
		return commentsModel;
	}
}
