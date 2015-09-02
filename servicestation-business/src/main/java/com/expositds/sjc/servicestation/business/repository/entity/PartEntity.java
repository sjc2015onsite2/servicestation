package com.expositds.sjc.servicestation.business.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Класс, содержащий информацию о запасной части. Экземпляром данного класса является тип запчасти с названием и артикулом.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "parts")
@NamedNativeQueries({
	@NamedNativeQuery(
		name = "callGetPartsByPartOrderProc",
		query = "call get_parts_by_part_order_id(:partOrderId)")})
public class PartEntity {
	
	/**
	 * Идентификатор типа запасной части.
	 */
	@Id
	@Column(name = "part_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long partId;
	
	/**
	 * Артикул запчасти.
	 */
	@Column(name = "part_article")
	private String article;
	
	/**
	 * Наименование запчасти.
	 */
	@Column(name = "part_name")
	private String name;
	
	/**
	 * Создаёт новый тип запчасти.
	 * 
	 * @param article артикул запчасти
	 * @param name наименование запчасти
	 */
	public PartEntity(String article, String name) {
		this.article = article;
		this.name = name;
	}
	
	public PartEntity() {
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
		PartEntity other = (PartEntity) obj;
		if (partId == null) {
			if (other.partId != null)
				return false;
		} else if (!partId.equals(other.partId))
			return false;
		return true;
	}

	public Long getPartId() {
		return partId;
	}

	public void setPartId(Long partId) {
		this.partId = partId;
	}

	public String getArticle() {
		return article;
	}

	public void setArticle(String article) {
		this.article = article;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
