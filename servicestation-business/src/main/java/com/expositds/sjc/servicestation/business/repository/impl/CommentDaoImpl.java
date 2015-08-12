package com.expositds.sjc.servicestation.business.repository.impl;

import org.springframework.stereotype.Repository;

import com.expositds.sjc.servicestation.business.repository.dao.CommentDao;
import com.expositds.sjc.servicestation.business.repository.hibernate.AbstractHibernateDao;
import com.expositds.sjc.servicestation.domain.model.Comment;

/**
 * @author Alexey Suslov
 *
 */
@Repository
public class CommentDaoImpl extends AbstractHibernateDao<Comment, Long> implements CommentDao {

}
