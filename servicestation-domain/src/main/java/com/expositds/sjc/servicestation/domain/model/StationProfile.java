package com.expositds.sjc.servicestation.domain.model;

import java.util.HashSet;

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
	private HashSet<Comment> comments = new HashSet<>();
	
	/**
	 * Список оценок о СТО.
	 */
	private HashSet<Mark> marks = new HashSet<>();

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

	public HashSet<Comment> getComments() {
		return comments;
	}

	public void setComments(HashSet<Comment> comments) {
		this.comments = comments;
	}

	public HashSet<Mark> getMarks() {
		return marks;
	}

	public void setMarks(HashSet<Mark> marks) {
		this.marks = marks;
	}

	public Long getStationProfileId() {
		return stationProfileId;
	}

	public void setStationProfileId(Long stationProfileId) {
		this.stationProfileId = stationProfileId;
	}
	
	
	
}
