package com.expositds.sjc.servicestation.business.repository.dto;

import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Алексей
 *
 */
@Entity
@Table(name = "site_aggregators")
public class StationsDto {
	
	@Id
	@Column(name = "site_aggregator_id")
	private Long siteAggregatorId;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(
			name = "site_aggregator_services_ids_names",
			joinColumns = @JoinColumn(name = "site_aggregator_id"))
	@MapKeyColumn(name = "station_id")
	@Column(name = "station_name")
	private Map<Integer, String> stationsIdAndNames;

	public Long getSiteAggregatorId() {
		return siteAggregatorId;
	}

	public void setSiteAggregatorId(Long siteAggregatorId) {
		this.siteAggregatorId = siteAggregatorId;
	}

	public Map<Integer, String> getStationsIdAndNames() {
		return stationsIdAndNames;
	}

	public void setStationsIdAndNames(Map<Integer, String> stationsIdAndNames) {
		this.stationsIdAndNames = stationsIdAndNames;
	}
	
	
	
}
