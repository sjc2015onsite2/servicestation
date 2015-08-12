package com.expositds.sjc.servicestation.business.repository.entity;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Класс для хранения арендной платы филиала. Арендная плата хранится с расчётом по дням.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "affilate_profiles")
public class AffilateProfileEntity {
	
	/**
	 * Индентифиатор профиля филиала.
	 */
	@Id
	@Column(name = "affilate_profile_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long affilateProfileId;
	
	/**
	 * Список дат и величина арендной платы по дням.
	 */
	@ElementCollection
	@CollectionTable(
			name = "affilate_profile_has_dates_rent",
			joinColumns = @JoinColumn(name = "affilate_profile_id"))
	@MapKeyColumn(name = "date")
	@Column(name = "rent")
	private Map<Calendar, Integer> rent;
	
	public AffilateProfileEntity() {
		this.rent = new TreeMap<>();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affilateProfileId == null) ? 0 : affilateProfileId.hashCode());
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
		AffilateProfileEntity other = (AffilateProfileEntity) obj;
		if (affilateProfileId == null) {
			if (other.affilateProfileId != null)
				return false;
		} else if (!affilateProfileId.equals(other.affilateProfileId))
			return false;
		return true;
	}

	public Long getAffilateProfileId() {
		return affilateProfileId;
	}

	public void setAffilateProfileId(Long affilateProfileId) {
		this.affilateProfileId = affilateProfileId;
	}

	public Map<Calendar, Integer> getRent() {
		return rent;
	}

	public void setRent(Map<Calendar, Integer> rent) {
		this.rent = rent;
	}

	
	
}
