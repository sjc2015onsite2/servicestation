package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Класс содержит оценку с указанием даты её выставления.
 * 
 * @author Alexey Suslov
 */

public class Mark implements Comparable<Mark>{
	
	/**
	 * Идентификатор оценки.
	 */
	private Long markId;
	
	/**
	 * Оценка, оставленная пользователем.
	 */
	private Integer mark;
	
	/**
	 * Дата выставления оценки.
	 */
	private Calendar date;
	
	/**
	 * Автор оценки.
	 */
	private SiteUser author;
	
	/**
	 * Создаёт оценку.
	 * 
	 * @param mark оценка
	 * @param author автор оценки
	 */
	public Mark(Integer mark, SiteUser author) {
		if (mark < 1 ) this.mark = 1;
		else if (mark > 5) this.mark = 5;
		else this.mark = mark;
		this.author = author;
		this.date = new GregorianCalendar();
	}
	
	public Mark() {
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
		Mark other = (Mark) obj;
		if (markId == null) {
			if (other.markId != null)
				return false;
		} else if (!markId.equals(other.markId))
			return false;
		return true;
	}

	public Integer getMark() {
		return mark;
	}

	public Calendar getDate() {
		return date;
	}

	public SiteUser getAuthor() {
		return author;
	}

	public Long getMarkId() {
		return markId;
	}

	public void setMarkId(Long markId) {
		this.markId = markId;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public void setAuthor(SiteUser author) {
		this.author = author;
	}

	@Override
	public int compareTo(Mark o) {
		return (int) (o.getMarkId() - markId);
	}
	
	
}
