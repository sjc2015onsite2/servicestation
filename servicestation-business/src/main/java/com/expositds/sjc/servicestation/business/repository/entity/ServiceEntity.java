package com.expositds.sjc.servicestation.business.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Класс, содержащий информацию о работе, услуге. Экземпляром данного класса является тип услуги с названием и артикулом.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "services")
public class ServiceEntity {
	
	/**
	 * Идентификатор услуги.
	 */
	@Id
	@Column(name = "service_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long serviceId;
	
	/**
	 * Артикул услуги.
	 */
	@Column(name = "article")
	private String article;
	
	/**
	 * Наименование услуги.
	 */
	@Column(name="name")
	private String name; 
	
	/**
	 * @param article артикул услуги
	 * @param name наименование услуги
	 */
	public ServiceEntity(String article, String name) {
		this.article = article;
		this.name = name;
	}
	
	public ServiceEntity() {
		this(null, null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
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
		ServiceEntity other = (ServiceEntity) obj;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}

	public String getArticle() {
		return article;
	}

	public String getName() {
		return name;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
		
}
