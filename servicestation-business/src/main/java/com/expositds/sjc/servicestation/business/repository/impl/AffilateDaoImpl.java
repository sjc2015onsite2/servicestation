package com.expositds.sjc.servicestation.business.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.AffilateDao;
import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class AffilateDaoImpl extends AbstractHibernateDao<AffilateEntity, Long> implements AffilateDao {

	@Override
	public AffilateEntity getAffilateByPartOrderId(Long Id) {
		return (AffilateEntity) getSession().getNamedQuery("callGetAffilateByPartOrderIdProc")
				   .setParameter("partOrderId", Id)
			       .uniqueResult();
	}

	
}
