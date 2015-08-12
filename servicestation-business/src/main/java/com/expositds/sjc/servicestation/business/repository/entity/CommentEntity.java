package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Класс содержит комментарий клиента как о СТО, так и о механике, и необязательно только о них.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "comments")
public class CommentEntity {
	
	/**
	 * Идентификатор комментария.
	 */
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long commentId;
	
	/**
	 * Непосредственно отзыв об СТО или механнике.
	 */
	@Column(name = "comment")
	private String comment;
	
	/**
	 * Дата написания отзыва.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Calendar date;
	
	/**
	 * Автор отзыва.
	 */
	@ManyToOne
	@JoinColumn(name = "site_user_id")
	private SiteUserEntity author;
	
	/**
	 * Виден ли отзыв посетителям сайта.
	 */
	@Column(name = "visible")
	private boolean visible;
	
	/**
	 * Создаёт коментарий.
	 * 
	 * @param comment комментарий
	 * @param author пользователь, оставивший данный комментарий
	 * @param visible виден ли отзыв посетителям сайта
	 */
	public CommentEntity(String comment, SiteUserEntity author, boolean visible) {
		this.comment = comment;
		this.author = author;
		this.date = new GregorianCalendar();
		this.visible = visible;
	}
	
	public CommentEntity() {
		this(null, null, false);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentId == null) ? 0 : commentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentEntity other = (CommentEntity) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		return true;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public SiteUserEntity getAuthor() {
		return author;
	}

	public void setAuthor(SiteUserEntity author) {
		this.author = author;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
		
}
