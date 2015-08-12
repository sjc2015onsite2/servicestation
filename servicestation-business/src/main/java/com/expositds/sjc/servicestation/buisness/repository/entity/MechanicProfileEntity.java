package com.expositds.sjc.servicestation.buisness.repository.entity;

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
 * Класс содержит информацию об отзывах лиентов о механиках.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "mechanic_profiles")
public class MechanicProfileEntity {
	
	/**
	 * Идентификатор профиля механика.
	 */
	@Id
	@Column(name = "mechanic_profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long mechanicProfileId;
	
	/**
	 * Список комментариев о механике.
	 */
	@OneToMany
	@JoinTable(
			name = "mechanic_profile_has_comments",
			joinColumns = @JoinColumn(name = "mechanic_profile_id"),
			inverseJoinColumns = @JoinColumn(name = "comment_id"))
	private Set<CommentEntity> comments;
	
	/**
	 * Создаёт новый профиль о механике.
	 */
	public MechanicProfileEntity() {
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
		MechanicProfileEntity other = (MechanicProfileEntity) obj;
		if (mechanicProfileId == null) {
			if (other.mechanicProfileId != null)
				return false;
		} else if (!mechanicProfileId.equals(other.mechanicProfileId))
			return false;
		return true;
	}


	public Long getMechanicPofileId() {
		return mechanicProfileId;
	}


	public void setMechanicPofileId(Long mechanicPofileId) {
		this.mechanicProfileId = mechanicPofileId;
	}


	public Set<CommentEntity> getComments() {
		return comments;
	}


	public void setComments(Set<CommentEntity> comments) {
		this.comments = comments;
	}



	
		
}
