package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Класс содержит комментарий клиента как о СТО, так и о механике, и необязательно только о них.
 * 
 * @author Alexey Suslov
 */
public class Comment implements Comparable<Comment> {
	
	/**
	 * Идентификатор комментария.
	 */
	private Long commentId;
	
	/**
	 * Непосредственно отзыв об СТО или механнике.
	 */
	private String comment;
	
	/**
	 * Дата написания отзыва.
	 */
	private Calendar date;
	
	/**
	 * Автор отзыва.
	 */
	private SiteUser author;
	
	/**
	 * Виден ли отзыв посетителям сайта.
	 */
	private boolean visible;
	
	/**
	 * Создаёт коментарий.
	 * 
	 * @param comment комментарий
	 * @param author пользователь, оставивший данный комментарий
	 * @param visible виден ли отзыв посетителям сайта
	 */
	public Comment(String comment, SiteUser author, boolean visible) {
		this.comment = comment;
		this.author = author;
		this.date = new GregorianCalendar();
		this.visible = visible;
	}
	
	public Comment() {
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
		Comment other = (Comment) obj;
		if (commentId == null) {
			if (other.commentId != null)
				return false;
		} else if (!commentId.equals(other.commentId))
			return false;
		return true;
	}

	public String getComment() {
		return comment;
	}

	public Calendar getDate() {
		return date;
	}

	public SiteUser getAuthor() {
		return author;
	}

	public boolean isVisible() {
		return visible;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setAuthor(SiteUser author) {
		this.author = author;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Override
	public int compareTo(Comment o) {
		return (int) (o.getCommentId() - commentId);
	}

	@Override
	public String toString() {
		return commentId.toString();
	}
	
	
	
}
