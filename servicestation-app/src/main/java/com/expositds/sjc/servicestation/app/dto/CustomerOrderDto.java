package com.expositds.sjc.servicestation.app.dto;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

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
	
	public CustomerOrderDto(Builder builder) {
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


	public static class Builder {
		
		private Order order;
		
		private Integer orderCost;
		
		private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		@Autowired
		private Identification identification;
		
		@Autowired
		AuthorizedUserSite authorizedUserSite;
		
		public Builder(Order order) {
			this.order = order;
		}
		
		public String getOrderId() {
			return order.getOrderId().toString();
		}
		
		public String getStationName() {
			return identification.getStationByOrder(order).getName().toString();
		}
		
		public String getMechanicName() {
			return identification.getMechanicByOrder(order).getName().toString();
		}
		
		public String getProblemDescription() {
			return order.getProblemDescription().toString();
		}
		
		public String getOrderStatus() {
			return order.getStatus().toString();
		}
		
		public String[][] getServiceRows() {
			
			String [][] serviceRows = new String[order.getServices().size()][4];
			int i = 0;
			for(Service currentService : order.getServices().keySet()){
				serviceRows[i][0] = currentService.getName();
				serviceRows[i][1] = order.getServices().get(currentService).toString();
				serviceRows[i][2] = order.getOrderServicesPriceList().get(currentService).toString();
				serviceRows[i][3] = Integer.toString((Integer.parseInt(serviceRows[i][1]) * Integer.parseInt(serviceRows[i][2])));
				orderCost += Integer.parseInt(serviceRows[i][3]);
				i++;
			}
			
			return serviceRows;
		}
		
		public Map<String, String> getPartsNamesAndQuantity() {
			Map<String, String> result = new HashMap<>();
			for(Part currentPart : order.getParts().keySet()){
				result.put(currentPart.getName().toString(), order.getParts().get(currentPart).toString());
			}
			return result;
		}
		
		public String getOrderCost() {
			return orderCost.toString();
		}
		
		public String getCompletedDate() {
			if(order.getCompleteDate() != null)
				return dateFormat.format(order.getCompleteDate().getTime());
			return new String();
		}
		
		public String getCreatedDate() {
			if(order.getCreateDate() != null)
				return dateFormat.format(order.getCreateDate().getTime());
			return new String();
		}
		
		public String getNotificationMessage() {
			if(order.getNotification() != null)
				return order.getNotification().getMessage().toString();
			return new String();
		}
		
		public Map<String, String> getStationsIdAndNames() {
			Map<String, String> result = new HashMap<>();
			for(Station currentStation : authorizedUserSite.getServiceStations()){
				result.put(currentStation.getStationId().toString(), currentStation.getName());
			}
			
			return result;
		}
		
		public CustomerOrderDto build() {
			return new CustomerOrderDto(this);
		}
	}
}
