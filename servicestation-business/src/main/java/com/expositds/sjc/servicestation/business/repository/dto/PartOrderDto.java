package com.expositds.sjc.servicestation.business.repository.dto;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Alexey Suslov
 *
 */
@Entity
public class PartOrderDto {
	
	@Id
	@Column(name = "part_order_id")
	private Integer id;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "part_order_parts_counts",
			joinColumns = @JoinColumn(name = "part_order_id"))
	@Column(name = "part_name")
	private List<String> partNames;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "part_order_parts_counts",
			joinColumns = @JoinColumn(name = "part_order_id"))
	@Column(name = "count")
	private List<Integer> partCounts;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "canchange")
	private boolean changeStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getPartNames() {
		return partNames;
	}

	public void setPartNames(List<String> partNames) {
		this.partNames = partNames;
	}

	public List<Integer> getPartCounts() {
		return partCounts;
	}

	public void setPartCounts(List<Integer> partCounts) {
		this.partCounts = partCounts;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isChangeStatus() {
		return changeStatus;
	}

	public void setChangeStatus(boolean changeStatus) {
		this.changeStatus = changeStatus;
	}

	
	

}
