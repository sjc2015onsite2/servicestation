package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Профиль СТО на сайте-агрегаторе.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "station_profiles")
public class StationProfileEntity {
	
	/**
	 * Идентификатор профиля станции.
	 */
	@Id
	@Column(name = "station_profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long stationProfileId;
	
	/**
	 * Список комментариев о СТО.
	 */
	@OneToMany
	@JoinTable(
			name = "station_profile_has_comments",
			joinColumns = @JoinColumn(name = "station_profile_id"),
			inverseJoinColumns = @JoinColumn(name = "comment_id"))
	private Set<CommentEntity> comments;
	
	/**
	 * Список оценок о СТО.
	 */
	@OneToMany
	@JoinTable(
			name = "station_profile_has_marks",
			joinColumns = @JoinColumn(name = "station_profile_id"),
			inverseJoinColumns = @JoinColumn(name = "mark_id"))
	private Set<MarkEntity> marks;
	
	/**
	 * Информация о СТО.
	 */
	@Column(name = "info")
	private String info;

	public StationProfileEntity() {
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
		StationProfileEntity other = (StationProfileEntity) obj;
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

	public Set<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}

	public Set<MarkEntity> getMarks() {
		return marks;
	}

	public void setMarks(Set<MarkEntity> marks) {
		this.marks = marks;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
