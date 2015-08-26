package com.expositds.sjc.servicestation.business.service.dto;

import java.util.Map;

import com.expositds.sjc.servicestation.business.service.dto.builders.CustomerOrderDtoBuilder;

/**
 * @author Alexey Suslov
 * @author Sergey Rybakov
 *
 */
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
	
	public CustomerOrderDto(CustomerOrderDtoBuilder builder) {
		orderId = builder.getOrderId();
		stationName = builder.getStationName();
		mechanicName = builder.getMechanicName();
		problemDescription = builder.getProblemDescription();
		orderStatus = builder.getOrderStatus();	
		serviceRows = builder.getServiceRows();
		orderCost = builder.getOrderCost();
		partsNamesAndQuantity = builder.getPartsNamesAndQuantity();
		completedDate = builder.getCompletedDate();
		createdDate = builder.getCreatedDate();
		notificationMessage = builder.getNotificationMessage();
		stationsIdAndNames = builder.getStationsIdAndNames();
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
	
	public String[][] getServiceRows() {
		return serviceRows;
	}

}
