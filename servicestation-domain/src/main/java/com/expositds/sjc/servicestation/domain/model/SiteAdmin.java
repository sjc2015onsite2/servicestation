package com.expositds.sjc.servicestation.domain.model;

/**
 * Класс содержит информацю об администраторе сайта.
 * 
 * @author Alexey Suslov
 *
 */
public class SiteAdmin extends Logginer {
	
	/**
	 * Специализация администратора.
	 */
	private String specilisation;

	public String getSpecilisation() {
		return specilisation;
	}

	public void setSpecilisation(String specilisation) {
		this.specilisation = specilisation;
	}
	
	

}
