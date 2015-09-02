package com.expositds.sjc.servicestation.business.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.DtosDao;
import com.expositds.sjc.servicestation.business.repository.dto.CeoNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.MechanicNotificationDto;
import com.expositds.sjc.servicestation.business.repository.dto.PartOrderDto;
import com.expositds.sjc.servicestation.business.repository.dto.StationsDto;

/**
 * @author Алексей
 *
 */
@Repository
public class DtosDaoImpl implements DtosDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public CustomerOrderDto getCustomerOrderDtoByOrderId(Long id) {
		return (CustomerOrderDto) getSession()
				 .getNamedQuery("callCustomerOrderDtoProc")
			     .setParameter("orderId", id)
		         .uniqueResult();
	}

	@Override
	public StationsDto getStationsDto() {
		return (StationsDto) getSession().get(StationsDto.class, 1L);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MechanicNotificationDto> getMechanicNotificationDto(Long id) {
		return getSession()
				 .getNamedQuery("callGetNotificationsByMechanicIdProc")
			     .setParameter("personId", id)
		         .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CeoNotificationDto> getCeoNotificationDto(Long id) {
		return getSession()
				 .getNamedQuery("callGetNotificationsByCeoIdProc")
			     .setParameter("personId", id)
		         .list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PartOrderDto> getPartOrderDto(Long id) {
		List<PartOrderDto> result = getSession()
									 .getNamedQuery("callGetMechanicPartOrdersDtoProc")
								     .setParameter("personId", id)
							         .list();
		
		for (PartOrderDto currentPartOrderDto : result) {
			List<String[]> parts = getSession().getNamedQuery("callGetPartsByPartOrderProc")
									.setParameter("partOrderId", currentPartOrderDto.getId())
									.list();
			currentPartOrderDto.setParts(parts);
		}
		
		return result;
	}

}
