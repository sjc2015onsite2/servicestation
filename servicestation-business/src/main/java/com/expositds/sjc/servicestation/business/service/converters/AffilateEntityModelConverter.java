package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.AffilateEntity;
import com.expositds.sjc.servicestation.domain.model.Affilate;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class AffilateEntityModelConverter implements Converter<AffilateEntity, Affilate> {

	@Override
	public Affilate convert(AffilateEntity source) {
		Affilate affilate = new Affilate(source.getAffilateCode());
		affilate.setAffilateId(source.getAffilateId());
		return affilate;
	}

}
