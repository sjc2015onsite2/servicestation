package com.expositds.sjc.servicestation.app.dto;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.PartOrder;
import com.expositds.sjc.servicestation.domain.model.PartOrderStatus;

public class PartOrderDto implements Comparable<PartOrderDto>{
	
	private String id;
	
	private Map<String, String> parts;
	
	private String status;
	
	private String date;
	
	private boolean changeStatus;
	

	public PartOrderDto(PartOrder partOrder) {
		this.id = partOrder.getPartOrderId().toString();
		this.parts = new HashMap<>();
		
		for (Part currentPart : partOrder.getParts().keySet()){
			String cPart = currentPart.getName();
			String vPart = partOrder.getParts().get(currentPart).toString();
			this.parts.put(cPart, vPart);
		}
		this.status = partOrder.getStatus().toString();
		String date = new String();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		date = dateFormat.format(partOrder.getDate().getTime());
		this.date = date;
		
		this.changeStatus = false;
		if(partOrder.getStatus() == PartOrderStatus.PENDING){
			changeStatus = true;
		}
	}

	
	
	public String getId() {
		return id;
	}

	public Map<String, String> getParts() {
		return parts;
	}

	public String getStatus() {
		return status;
	}

	public String getDate() {
		return date;
	}
	
	public boolean getChangeStatus() {
		return changeStatus;
	}



	@Override
	public int compareTo(PartOrderDto o) {
		
		return (-1) * id.compareTo(o.getId());
	}

}
