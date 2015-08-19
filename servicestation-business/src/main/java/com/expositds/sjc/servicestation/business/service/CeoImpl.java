package com.expositds.sjc.servicestation.business.service;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.Person;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.Ceo;
import com.expositds.sjc.servicestation.domain.service.QualityDepartment;

/**
 * @author Alexey Suslov
 *
 */
@Service
@Transactional
public class CeoImpl extends ReportableImpl implements Ceo {
	
	@Autowired
	private QualityDepartment qualityDepartment;

	@Override
	public Set<Comment> getServiceStationComments(Station seviceStation) {
		return qualityDepartment.getServiceStationComments(seviceStation);
	}

	@Override
	public Map<Person, Set<Comment>> getMechanicsComments(Station seviceStation) {
		return qualityDepartment.getMechanicsComments(seviceStation);
	}

	@Override
	public Set<Mark> getServiceStationMarks(Station seviceStation) {
		return qualityDepartment.getServiceStationMarks(seviceStation);
	}

}
