package com.expositds.sjc.servicestation.business.repository.dto;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedNativeQuery;
import com.expositds.sjc.servicestation.business.service.dto.builders.CustomerOrderDtoBuilder;

/**
 * @author Alexey Suslov
 * @author Sergey Rybakov
 *
 */
@Entity
@NamedNativeQuery(
		name = "callCustomerOrderDtoProc", 
		query = "call customer_order_dto(:orderId)")
public class CustomerOrderDto {
	
	@Column(name = "orders.order_id")
	private String orderId;
	
	@Column(name = "stations.station_name")
	private String stationName;
	
	@Column(name = "logginers.name")
	private String mechanicName;
	
	@Column(name = "orders.order_problem_description")
	private String problemDescription;
	
	@Column(name = "orders.order_status")
	private String orderStatus;
	
	private String[][] serviceRows;
	
	@ElementCollection
	@CollectionTable(
			name = "order_has_parts_counts",
			joinColumns = @JoinColumn(name = "part_name"))
	@MapKeyJoinColumn(name = "part_name")
	@Column(name = "count")
	private Map<String, String> partsNamesAndQuantity;
	
	private String orderCost;
	
	@Column(name = "orders.order_compleate_date")
	private String completedDate;
	
	@Column(name = "orders.order_create_date")
	private String createdDate;
	
	@Column(name = "client_notifications.client_notification")
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
