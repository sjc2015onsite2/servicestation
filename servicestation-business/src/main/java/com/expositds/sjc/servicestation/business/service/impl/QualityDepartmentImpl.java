package com.expositds.sjc.servicestation.business.service.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Aggregator;
import com.expositds.sjc.servicestation.domain.service.QualityDepartment;

/**
 * @author Alexey Suslov
 *
 */
@Service
public class QualityDepartmentImpl implements QualityDepartment {

	@Autowired
	private Aggregator aggrgator;
	
	@Override
	public Set<Mark> getServiceStationMarks(Station seviceStation) {
		return aggrgator.getServiceStationMarks(seviceStation);
	}

	@Override
	public Set<Comment> getServiceStationComments(Station seviceStation) {
		return aggrgator.getServiceStationAllComments(seviceStation);
	}

	@Override
	public Map<Person, Set<Comment>> getMechanicsComments(Station seviceStation) {
		return aggrgator.getMechanicsAllComments(seviceStation);
	}

}
