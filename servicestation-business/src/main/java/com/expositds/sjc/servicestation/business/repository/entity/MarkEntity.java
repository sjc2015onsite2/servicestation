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
 * Класс содержит оценку с указанием даты её выставления.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "marks")
public class MarkEntity {
	
	/**
	 * Идентификатор оценки.
	 */
	@Id
	@Column(name = "mark_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long markId;
	
	/**
	 * Оценка, оставленная пользователем.
	 */
	@Column(name = "mark")
	private Integer mark;
	
	/**
	 * Дата выставления оценки.
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Calendar date;
	
	/**
	 * Автор оценки.
	 */
	@ManyToOne
	@JoinColumn(name = "site_user_id")
	private SiteUserEntity author;
	
	/**
	 * Создаёт оценку.
	 * 
	 * @param mark оценка
	 * @param author автор оценки
	 */
	public MarkEntity(Integer mark, SiteUserEntity author) {
		if (mark != null) {
			if (mark < 1 ) this.mark = 1;
			else if (mark > 5) this.mark = 5;
			else this.mark = mark;
		}
		this.author = author;
		this.date = new GregorianCalendar();
	}
	
	public MarkEntity() {
		this(null, null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((markId == null) ? 0 : markId.hashCode());
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
		MarkEntity other = (MarkEntity) obj;
		if (markId == null) {
			if (other.markId != null)
				return false;
		} else if (!markId.equals(other.markId))
			return false;
		return true;
	}

	public Long getMarkId() {
		return markId;
	}

	public void setMarkId(Long markId) {
		this.markId = markId;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
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
	
		
}
