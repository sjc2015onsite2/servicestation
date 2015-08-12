package com.expositds.sjc.servicestation.buisness.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.buisness.repository.dao.PersonDao;
import com.expositds.sjc.servicestation.buisness.repository.entity.PersonEntity;
import com.expositds.sjc.servicestation.buisness.repository.hibernate.AbstractHibernateDao;

/**
 * @author Алексей
 *
 */
@Repository
public class PersonDaoImpl extends AbstractHibernateDao<PersonEntity, Long> implements PersonDao {

	

}
