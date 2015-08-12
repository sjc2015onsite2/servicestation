package com.expositds.sjc.servicestation.domain.model;

/**
 * Класс, содержащий информацию о работе, услуге. Экземпляром данного класса является тип услуги с названием и артикулом.
 * 
 * @author Alexey Suslov
 */
public class Service {
	
	/**
	 * Идентификатор услуги.
	 */
	private Long serviceId;
	
	/**
	 * Артикул услуги.
	 */
	private String article;
	
	/**
	 * Наименование услуги.
	 */
	private String name; 
	
	/**
	 * Создаёт новую услугу.
	 * 
	 * @param article артикул услуги
	 * @param name наименование услуги
	 */
	public Service(String article, String name) {
		this.article = article;
		this.name = name;
	}
	
	public Service() {
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
		Service other = (Service) obj;
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

	public void setArticle(String article) {
		this.article = article;
	}

	public void setName(String name) {
		this.name = name;
	}
		
}
