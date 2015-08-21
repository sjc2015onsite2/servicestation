package com.expositds.sjc.servicestation.business.service.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.expositds.sjc.servicestation.business.repository.entity.CommentEntity;
import com.expositds.sjc.servicestation.domain.model.Comment;
import com.expositds.sjc.servicestation.domain.model.SiteUser;

/**
 * @author Alexey Suslov
 *
 */
@Component
public class CommentEntityModelConverter implements Converter<CommentEntity, Comment> {

	@Override
	public Comment convert(CommentEntity source) {
		SiteUser siteUser = new SiteUser(source.getAuthor().getName(), source.getAuthor().getRole());
		siteUser.setId(source.getAuthor().getId());
		Comment comment = new Comment(source.getComment(), siteUser, source.isVisible());
		comment.setCommentId(source.getCommentId());
		comment.setDate(source.getDate());
		return comment;
	}

}
