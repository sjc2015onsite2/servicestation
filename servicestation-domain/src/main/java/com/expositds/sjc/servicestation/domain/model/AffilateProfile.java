package com.expositds.sjc.servicestation.domain.model;

import java.util.Calendar;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс для хранения арендной платы филиала. Арендная плата хранится с расчётом по дням.
 * 
 * @author Alexey Suslov
 */
public class AffilateProfile {
	
	/**
	 * Индентифиатор профиля филиала.
	 */
	private Long affilateProfileId;
	
	/**
	 * Список дат и величина арендной платы по дням.
	 */
	private Map<Calendar, Integer> rent;
	
	public AffilateProfile() {
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
		AffilateProfile other = (AffilateProfile) obj;
		if (affilateProfileId == null) {
			if (other.affilateProfileId != null)
				return false;
		} else if (!affilateProfileId.equals(other.affilateProfileId))
			return false;
		return true;
	}

	public Map<Calendar, Integer> getRent() {
		return rent;
	}

	public void setRent(Map<Calendar, Integer> rent) {
		this.rent = rent;
	}

	public Long getAffilateProfileId() {
		return affilateProfileId;
	}

	public void setAffilateProfileId(Long affilateProfileId) {
		this.affilateProfileId = affilateProfileId;
	}

	
	
}
