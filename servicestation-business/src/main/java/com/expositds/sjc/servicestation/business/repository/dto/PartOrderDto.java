package com.expositds.sjc.servicestation.business.repository.dto;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author Alexey Suslov
 *
 */
@Entity
public class PartOrderDto implements Comparable<PartOrderDto> {
	
	@Id
	@Column(name = "part_order_id")
	private Integer id;
	
	@Transient
	private List<String[]> parts;
	
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

	public List<String[]> getParts() {
		return parts;
	}

	public void setParts(List<String[]> parts) {
		this.parts = parts;
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

	@Override
	public int compareTo(PartOrderDto o) {
		
		return o.getId()-id;
	}

}
