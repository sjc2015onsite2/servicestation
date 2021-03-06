package com.expositds.sjc.servicestation.business.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.SiteUserDao;
import com.expositds.sjc.servicestation.business.repository.entity.SiteUserEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class SiteUserDaoImpl extends AbstractHibernateDao<SiteUserEntity, Long> implements SiteUserDao {

}
