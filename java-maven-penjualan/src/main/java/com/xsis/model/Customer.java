package com.xsis.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String address;
	private String contact;
	
	@OneToMany(mappedBy="customer")
	List<Penjualan> juals;
	
	@OneToMany(mappedBy="customer")
	List<Pesanan> pesans;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public List<Penjualan> getJuals() {
		return juals;
	}
	public void setJuals(List<Penjualan> juals) {
		this.juals = juals;
	}
	public List<Pesanan> getPesans() {
		return pesans;
	}
	public void setPesans(List<Pesanan> pesans) {
		this.pesans = pesans;
	}
	
	
}
