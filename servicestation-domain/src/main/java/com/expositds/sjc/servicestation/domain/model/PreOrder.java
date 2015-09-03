package com.expositds.sjc.servicestation.domain.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Класс содержит информацию о предзаказе, для передачи от сайта-агрегатора СТО.
 * 
 * @author Alexey Suslov
 */
public class PreOrder {
	
	/**
	 * Идентификатор предзаказа.
	 */
	private Long preOrderId;
	
	/**
	 * Описание проблеммы, с которой клиент обратился в СТО.
	 */
	
	private String problemDescription;
	
	/**
	 * Контактные данные незарегестрированного пользователя.
	 */
	
	private String contactData;
	
	/**
	 * Создаёт новый предзаказ.
	 * 
	 * @param problemDescription описание проблеммы, с которой клиент обратился в СТО
	 * @param contactData контактные данные незарегестрированного пользователя
	 */
	public PreOrder(String problemDescription, String contactData) {
		this.problemDescription = problemDescription;
		this.contactData = contactData;
	}
	
	/**
	 * Создаёт новый предзаказ.
	 * 
	 * @param problemDescription описание проблеммы, с которой клиент обратился в СТО
	 */
	public PreOrder(String problemDescription) {
		this(problemDescription, null);
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public String getContactData() {
		return contactData;
	}

	public Long getPreOrderId() {
		return preOrderId;
	}

	public void setPreOrderId(Long preOrderId) {
		this.preOrderId = preOrderId;
	}
	
}
