package com.expositds.sjc.servicestation.domain.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс содержит информацию об отзывах лиентов о механиках.
 * 
 * @author Alexey Suslov
 */
public class MechanicProfile {
	
	/**
	 * Идентификатор профиля механика.
	 */
	private Long mechanicProfileId;
	
	/**
	 * Список комментариев о механике.
	 */
	private Set<Comment> comments;
	
	/**
	 * Информация о механике.
	 */
	private String info;
	
	public MechanicProfile() {
		this.comments = new HashSet<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mechanicProfileId == null) ? 0 : mechanicProfileId.hashCode());
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
		MechanicProfile other = (MechanicProfile) obj;
		if (mechanicProfileId == null) {
			if (other.mechanicProfileId != null)
				return false;
		} else if (!mechanicProfileId.equals(other.mechanicProfileId))
			return false;
		return true;
	}

	public Long getMechanicProfileId() {
		return mechanicProfileId;
	}

	public void setMechanicProfileId(Long mechanicProfileId) {
		this.mechanicProfileId = mechanicProfileId;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
