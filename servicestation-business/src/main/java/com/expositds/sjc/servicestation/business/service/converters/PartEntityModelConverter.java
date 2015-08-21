package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.domain.model.Part;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class PartEntityModelConverter implements Converter<PartEntity, Part> {

	@Override
	public Part convert(PartEntity source) {
		Part part = new Part(source.getArticle(), source.getName());
		part.setPartId(source.getPartId());
		return part;
	}

}
