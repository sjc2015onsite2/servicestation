package com.expositds.sjc.servicestation.business.service.converters;

import java.util.HashMap;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.PartEntity;
import com.expositds.sjc.servicestation.business.repository.entity.PartOrderEntity;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class PartOrderEntityModelConverter implements Converter<PartOrderEntity, PartOrder> {
	
	private PartEntityModelConverter partEntityModelConverter = new PartEntityModelConverter();

	@Override
	public PartOrder convert(PartOrderEntity source) {
		PartOrder partOrder = new PartOrder();
		partOrder.setPartOrderId(source.getPartOrderId());
		partOrder.setClientPartOrderId(source.getClientPartOrderId());
		partOrder.setDate(source.getDate());
		partOrder.setStatus(source.getStatus());
		partOrder.setParts(new HashMap<Part, Integer>());
		for (PartEntity currentPartEntity : source.getParts().keySet()) {
			Part currentPart = partEntityModelConverter.convert(currentPartEntity);
			Integer currentCount = source.getParts().get(currentPartEntity);
			partOrder.getParts().put(currentPart, currentCount);
		}
		return partOrder;
	}

}
