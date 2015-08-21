package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.SiteAggregatorEntity;
import com.expositds.sjc.servicestation.domain.model.SiteAggregator;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class SiteAggregatorEntityModelConverter implements Converter<SiteAggregatorEntity, SiteAggregator> {

	@Override
	public SiteAggregator convert(SiteAggregatorEntity source) {
		SiteAggregator siteAggregator = new SiteAggregator();
		siteAggregator.setSiteAggregatorId(source.getSiteAggregatorId());
		return siteAggregator;
	}

}
