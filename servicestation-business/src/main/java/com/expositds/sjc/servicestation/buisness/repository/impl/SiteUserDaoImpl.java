package com.expositds.sjc.servicestation.buisness.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.buisness.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.buisness.repository.entity.SiteUserEntity;
import com.expositds.sjc.servicestation.buisness.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class SiteUserDaoImpl extends AbstractHibernateDao<SiteUserEntity, Long>implements SiteUserDao {

}
