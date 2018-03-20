package com.xsis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="customer_xe")
public class Customer {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	@NotNull
	@NotEmpty
	@Size(min=4, max=30)
	private String name;
	private String address;
	private String contact;
	@Email
	private String email;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", cascade=javax.persistence.CascadeType.ALL, orphanRemoval=true)
	private List<Order> orders;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer", cascade=javax.persistence.CascadeType.ALL, orphanRemoval=true)
	private List<Penjualan> juals;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Penjualan> getJuals() {
		return juals;
	}
	public void setJuals(List<Penjualan> juals) {
		this.juals = juals;
	}
}
