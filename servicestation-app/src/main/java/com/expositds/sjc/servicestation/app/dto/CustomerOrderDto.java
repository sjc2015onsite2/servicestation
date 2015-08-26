package com.expositds.sjc.servicestation.app.dto;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.expositds.sjc.servicestation.business.service.IdentificationImpl;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

public class CustomerOrderDto {
	
	private String orderId;
	
	private String stationName;
	
	private String mechanicName;
	
	private String problemDescription;
	
	private String orderStatus;
	
	private String[][] serviceRows;
	
	private Map<String, String> partsNamesAndQuantity;
	
	private String orderCost;
	
	private String completedDate;
	
	private String createdDate;
	
	private String notificationMessage;
	
	private Map<String, String> stationsIdAndNames;
	
	@Autowired
	Identification identification;
	
	@Autowired
	AuthorizedUserSite authorizedUserSite;
	

	public CustomerOrderDto(Order order) {
		
		this.orderId = order.getOrderId().toString();
		
		this.stationName = identification.getStationByOrder(order).getName().toString();
		
		this.mechanicName = identification.getMechanicByOrder(order).getName().toString();
		
		this.problemDescription = order.getProblemDescription().toString();
		
		this.orderStatus = order.getStatus().toString();
		
		this.orderCost = new String();
		
		this.serviceRows = new String[order.getServices().size()][4];
		int i = 0;
		for(Service currentService : order.getServices().keySet()){
			serviceRows[i][0] = currentService.getName();
			serviceRows[i][1] = order.getServices().get(currentService).toString();
			serviceRows[i][2] = order.getOrderServicesPriceList().get(currentService).toString();
			serviceRows[i][3] = Integer.toString((Integer.parseInt(serviceRows[i][1]) * Integer.parseInt(serviceRows[i][2])));
			orderCost += Integer.parseInt(serviceRows[i][3]);
			i++;
		}
		
		this.partsNamesAndQuantity = new HashMap<>();
		for(Part currentPart : order.getParts().keySet()){
			partsNamesAndQuantity.put(currentPart.getName().toString(), order.getParts().get(currentPart).toString());
		}
		
		this.completedDate = new String();
		this.createdDate = new String();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		if(order.getCompleteDate() != null)
			completedDate = dateFormat.format(order.getCompleteDate().getTime());
		createdDate = dateFormat.format(order.getCreateDate().getTime());
		
		
		this.notificationMessage = new String();
		if(order.getNotification() != null){
			notificationMessage = order.getNotification().getMessage().toString();
		}
		
		this.stationsIdAndNames = new HashMap<>();
		for(Station currentStation : authorizedUserSite.getServiceStations()){
			stationsIdAndNames.put(currentStation.getStationId().toString(),currentStation.getName().toString());
		}
	}

	public String getOrderId() {
		return orderId;
	}

	public String getStationName() {
		return stationName;
	}

	public String getMechanicName() {
		return mechanicName;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public Map<String, String> getPartsNamesAndQuantity() {
		return partsNamesAndQuantity;
	}

	public String getOrderCost() {
		return orderCost;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public Map<String, String> getStationsIdAndNames() {
		return stationsIdAndNames;
	}
	
	
}
