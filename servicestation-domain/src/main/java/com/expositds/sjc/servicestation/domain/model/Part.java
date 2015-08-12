package com.expositds.sjc.servicestation.domain.model;

/**
 * Класс, содержащий информацию о запасной части. Экземпляром данного класса является тип запчасти с названием и артикулом.
 * 
 * @author Alexey Suslov
 */
public class Part {
	
	/**
	 * Идентификатор типа запасной части.
	 */
	private Long partId;
	
	/**
	 * Артикул запчасти.
	 */
	private String article;
	
	/**
	 * Наименование запчасти.
	 */
	private String name;
	
	/**
	 * Создаёт новый тип запчасти.
	 * 
	 * @param article артикул запчасти
	 * @param name наименование запчасти
	 */
	public Part(String article, String name) {
		this.article = article;
		this.name = name;
	}
	
	public Part() {
		this(null, null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partId == null) ? 0 : partId.hashCode());
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
		Part other = (Part) obj;
		if (partId == null) {
			if (other.partId != null)
				return false;
		} else if (!partId.equals(other.partId))
			return false;
		return true;
	}

	public String getArticle() {
		return article;
	}

	public String getName() {
		return name;
	}

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
