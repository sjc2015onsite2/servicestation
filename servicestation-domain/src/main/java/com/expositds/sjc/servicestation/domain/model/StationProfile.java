package com.expositds.sjc.servicestation.domain.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Профиль СТО на сайте-агрегаторе.
 * 
 * @author Alexey Suslov
 */
public class StationProfile {
	
	/**
	 * Идентификатор профиля станции.
	 */
	private Long stationProfileId;
	
	/**
	 * Список комментариев о СТО.
	 */
	private Set<Comment> comments;
	
	/**
	 * Список оценок о СТО.
	 */
	private Set<Mark> marks;
	
	/**
	 * Информация о станции.
	 */
	private String info;
	
	public StationProfile() {
		this.comments = new HashSet<>();
		this.marks = new HashSet<>();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stationProfileId == null) ? 0 : stationProfileId.hashCode());
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
		StationProfile other = (StationProfile) obj;
		if (stationProfileId == null) {
			if (other.stationProfileId != null)
				return false;
		} else if (!stationProfileId.equals(other.stationProfileId))
			return false;
		return true;
	}

	public Long getStationProfileId() {
		return stationProfileId;
	}

	public void setStationProfileId(Long stationProfileId) {
		this.stationProfileId = stationProfileId;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Mark> getMarks() {
		return marks;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
}
