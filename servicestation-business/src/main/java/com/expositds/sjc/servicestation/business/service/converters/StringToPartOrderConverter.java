package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Rybakov Sergey
 *
 */
@Component
public class StringToPartOrderConverter implements Converter<String, PartOrder> {

	@Autowired
	private Identification identification;
	
	@Override
	public PartOrder convert(String id) {
		return identification.getPartOrderById(id);
	}
}