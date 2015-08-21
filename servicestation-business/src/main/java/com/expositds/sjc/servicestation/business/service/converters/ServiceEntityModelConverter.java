package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.ServiceEntity;
import com.expositds.sjc.servicestation.domain.model.Service;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class ServiceEntityModelConverter implements Converter<ServiceEntity, Service> {

	@Override
	public Service convert(ServiceEntity source) {
		Service service = new Service(source.getArticle(), source.getName());
		service.setServiceId(source.getServiceId());
		return service;
	}

}
