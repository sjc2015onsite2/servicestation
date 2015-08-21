package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.MarkEntity;
import com.expositds.sjc.servicestation.domain.model.Mark;
import com.expositds.sjc.servicestation.domain.model.SiteUser;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class MarkEntityModelConverter implements Converter<MarkEntity, Mark> {

	@Override
	public Mark convert(MarkEntity source) {
		SiteUser siteUser = new SiteUser(source.getAuthor().getName(), source.getAuthor().getRole());
		siteUser.setId(source.getAuthor().getId());
		Mark mark = new Mark(source.getMark(), siteUser);
		mark.setMarkId(source.getMarkId());
		mark.setDate(source.getDate());
		return mark;
	}

}
