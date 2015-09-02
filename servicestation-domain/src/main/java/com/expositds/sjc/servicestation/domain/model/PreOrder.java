package com.expositds.sjc.servicestation.domain.model;

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
	@NotNull
	@Pattern(regexp = "[a-zA-Zа-яА-Я0-9 ]*",
	message="problemDescription must be alphanumeric.")
	@Size(min=5,
	message="problemDescription must be at least 5 characters long.")
	private String problemDescription;
	
	/**
	 * Контактные данные незарегестрированного пользователя.
	 */
	@NotNull
	@Pattern(regexp = "[0-9]*",
	message="contactData must be numeric.")
	@Size(min=9, max=9,
	message="contactData must be 9 characters long.")
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
