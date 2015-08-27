package com.expositds.sjc.servicestation.business.repository.dto;

import java.util.List;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Alexey Suslov
 *
 */
@Entity
@NamedNativeQueries({
	@NamedNativeQuery(
		name = "callCustomerOrderDtoProc", 
		query = "call customer_order_dto(:orderId)",
		resultClass = CustomerOrderDto.class)})
public class CustomerOrderDto {
	
	@Id
	@Column(name = "orders.order_id")
	private Integer orderId;
	
	@Column(name = "stations.station_name")
	private String stationName;
	
	@Column(name = "logginers.name")
	private String mechanicName;
	
	@Column(name = "orders.order_problem_description")
	private String problemDescription;
	
	@Column(name = "orders.order_status")
	private String orderStatus;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "order_services_costs_counts",
			joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "name")
	private List<String> serviceNames;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "order_services_costs_counts",
			joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "count")
	private List<Integer> serviceCounts;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "order_services_costs_counts",
			joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "cost")
	private List<Integer> serviceCosts;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "order_services_costs_counts",
			joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "sum")
	private List<Integer> serviceSums;
		
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "order_parts_counts",
			joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "part_name")
	private List<String> partNames;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "order_has_parts_counts",
			joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "count")
	private List<Integer> partCounts;
	
	//private String orderCost;
	
	@Column(name = "orders.order_compleate_date")
	private String completedDate;
	
	@Column(name = "orders.order_create_date")
	private String createdDate;
	
	@Column(name = "client_notifications.client_notification")
	private String notificationMessage;
	
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@ElementCollection
//	@CollectionTable(name = "stations")
//	@MapKeyColumn(name = "station_id")
//	@Column(name = "station_name")
//	private Map<Integer, String> stationsIdAndNames;
	
//	@LazyCollection(LazyCollectionOption.FALSE)
//	@ElementCollection
//	@CollectionTable(name = "services")
//	@Column(name = "station_d")
//	private List<Integer> stationIds;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getMechanicName() {
		return mechanicName;
	}

	public void setMechanicName(String mechanicName) {
		this.mechanicName = mechanicName;
	}

	public String getProblemDescription() {
		return problemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	public String getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
	
	
	
}
