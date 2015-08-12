package com.expositds.sjc.servicestation.buisness.repository.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Класс Affilate содержит иформацию о Person, Part, Service, PartOrder, Order.
 * 
 * @author Alexey Suslov
 */
@Entity
@Table(name = "affilates")
public class AffilateEntity {
	
	/**
	 * Идентификатор филиала.
	 */
	@Id
	@Column(name = "affilate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@PrimaryKeyJoinColumn
	private Long affilateId; 
	
	/**
	 * Список запасных частей в филиале с указанием их количества.
	 */
	@ElementCollection
	@CollectionTable(
			name = "affilate_has_parts_counts",
			joinColumns = @JoinColumn(name = "affilate_id"))
	@MapKeyJoinColumn(name = "part_id")
	@Column(name = "count")
	private Map<PartEntity, Integer> parts;

	/**
	 * Список заявок у филиала.
	 */
	@OneToMany
	@JoinTable(
			name = "affilate_has_orders",
			joinColumns = @JoinColumn(name = "affilate_id"),
			inverseJoinColumns = @JoinColumn(name = "order_id"))
	private Set<OrderEntity> orders;

	/**
	 * Список заявок на запчасти с указанием механика, который создал завку на запчасть.
	 */
	@OneToMany
	@JoinTable(
			name = "affilate_has_part_orders_persons",
			joinColumns = @JoinColumn(name = "affilate_id"),
			inverseJoinColumns = @JoinColumn(name = "person_id"))
	@MapKeyJoinColumn(name = "part_order_id")
	private Map<PartOrderEntity, PersonEntity> partOrders;

	/**
	 * Список сотрудников (механиков) работающих в филиале.
	 */
	@OneToMany
	@JoinTable(
			name = "affilate_has_persons",
			joinColumns = @JoinColumn(name = "affilate_id"),
			inverseJoinColumns = @JoinColumn(name = "person_id"))
	private Set<PersonEntity> persons;

	/**
	 * Список оказываемых филиалом услуг и их стоимость.
	 */
	@ElementCollection
	@CollectionTable(
			name = "affilate_has_services_costs",
			joinColumns = @JoinColumn(name = "affilate_id"))
	@MapKeyJoinColumn(name = "sevice_id")
	@Column(name = "cost")
	private Map<ServiceEntity, Integer> services;

	/**
	 * Код филиала.
	 */
	@Column(name = "person_affilate_id")
	private String affilateCode;
	
	/**
	 * Создаёт филлиал.
	 * 
	 * @param affilateCode униальный в рамках СТО код филиала
	 */
	public AffilateEntity(String affilateCode) {
		this.affilateCode = affilateCode;
		this.parts = new HashMap<>();
		this.orders = new HashSet<>();
		this.partOrders = new HashMap<>();
		this.persons = new HashSet<>();
		this.services = new HashMap<>();
	}
	
	public AffilateEntity() {
		this(null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affilateId == null) ? 0 : affilateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffilateEntity other = (AffilateEntity) obj;
		if (affilateId == null) {
			if (other.affilateId != null)
				return false;
		} else if (!affilateId.equals(other.affilateId))
			return false;
		return true;
	}

	public Long getAffilateId() {
		return affilateId;
	}

	public void setAffilateId(Long affilateId) {
		this.affilateId = affilateId;
	}

	public Map<PartEntity, Integer> getParts() {
		return parts;
	}

	public void setParts(Map<PartEntity, Integer> parts) {
		this.parts = parts;
	}

	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

	public Map<PartOrderEntity, PersonEntity> getPartOrders() {
		return partOrders;
	}

	public void setPartOrders(Map<PartOrderEntity, PersonEntity> partOrders) {
		this.partOrders = partOrders;
	}

	public Set<PersonEntity> getPersons() {
		return persons;
	}

	public void setPersons(Set<PersonEntity> persons) {
		this.persons = persons;
	}

	public Map<ServiceEntity, Integer> getServices() {
		return services;
	}

	public void setServices(Map<ServiceEntity, Integer> services) {
		this.services = services;
	}

	public String getAffilateCode() {
		return affilateCode;
	}

	public void setAffilateCode(String affilateCode) {
		this.affilateCode = affilateCode;
	}

}
