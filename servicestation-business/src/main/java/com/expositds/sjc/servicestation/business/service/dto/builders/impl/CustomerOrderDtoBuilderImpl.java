package com.expositds.sjc.servicestation.business.service.dto.builders.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.expositds.sjc.servicestation.business.repository.dao.dto.CustomerOrderDtoDao;
import com.expositds.sjc.servicestation.business.repository.dto.CustomerOrderDto;
import com.expositds.sjc.servicestation.business.service.dto.builders.CustomerOrderDtoBuilder;
import com.expositds.sjc.servicestation.domain.model.Order;
import com.expositds.sjc.servicestation.domain.model.Part;
import com.expositds.sjc.servicestation.domain.model.Service;
import com.expositds.sjc.servicestation.domain.model.Station;
import com.expositds.sjc.servicestation.domain.service.AuthorizedUserSite;
import com.expositds.sjc.servicestation.domain.service.Identification;

/**
 * @author Alexey Suslov
 *
 */
@org.springframework.stereotype.Service
@Scope("prototype")
public class CustomerOrderDtoBuilderImpl implements CustomerOrderDtoBuilder {
		
		private Order order;
		
		private Integer orderCost;
		
		private SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		
		@Autowired
		private Identification identification;
		
		@Autowired
		private AuthorizedUserSite authorizedUserSite;
		
		@Autowired
		private CustomerOrderDtoDao customerOrderDtoDao;
		
		@Override
		public void setOrder(Order order) {
			this.order = order;
		}
		
		@Override
		public String getOrderId() {
			return order.getOrderId().toString();
		}
		
		@Override
		public String getStationName() {
			return identification.getStationByOrder(order).getName().toString();
		}
		
		@Override
		public String getMechanicName() {
			return identification.getMechanicByOrder(order).getName().toString();
		}
		
		@Override
		public String getProblemDescription() {
			return order.getProblemDescription().toString();
		}
		
		@Override
		public String getOrderStatus() {
			return order.getStatus().toString();
		}
		
		@Override
		public String[][] getServiceRows() {
			
			String [][] serviceRows = new String[order.getServices().size()][4];
			int i = 0;
			orderCost = 0;
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
		
		@Override
		public Map<String, String> getPartsNamesAndQuantity() {
			Map<String, String> result = new HashMap<>();
			for(Part currentPart : order.getParts().keySet()){
				result.put(currentPart.getName().toString(), order.getParts().get(currentPart).toString());
			}
			return result;
		}
		
		@Override
		public String getOrderCost() {
			return orderCost.toString();
		}
		
		@Override
		public String getCompletedDate() {
			if(order.getCompleteDate() != null)
				return dateFormat.format(order.getCompleteDate().getTime());
			return new String();
		}
		
		@Override
		public String getCreatedDate() {
			if(order.getCreateDate() != null)
				return dateFormat.format(order.getCreateDate().getTime());
			return new String();
		}
		
		@Override
		public String getNotificationMessage() {
			if(order.getNotification() != null)
				return order.getNotification().getMessage().toString();
			return new String();
		}
		
		@Override
		public Map<String, String> getStationsIdAndNames() {
			Map<String, String> result = new HashMap<>();
			for(Station currentStation : authorizedUserSite.getServiceStations()){
				result.put(currentStation.getStationId().toString(), currentStation.getName());
			}
			
			return result;
		}
		
		@Override
		public CustomerOrderDto build() {
			CustomerOrderDto result = customerOrderDtoDao.getCustomerOrderDtoByOrderId(order.getOrderId());
			return result;
		}
}
