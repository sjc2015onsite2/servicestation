package com.expositds.sjc.servicestation.business.repository.impl.dto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.dto.CustomerOrderDtoDao;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;

@Repository
public class CustomerOrderDtoDaoImpl implements CustomerOrderDtoDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public CustomerOrderDto getCustomerOrderDtoByOrderId(Long Id) {
		return (CustomerOrderDto) getSession().getNamedQuery("callCustomerOrderDtoProc")
				   .setParameter("orderId", Id)
			       .uniqueResult();
	}

}
