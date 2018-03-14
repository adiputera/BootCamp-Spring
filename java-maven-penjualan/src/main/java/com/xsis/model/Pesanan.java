package com.xsis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pesanan")
public class Pesanan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="jml_barang")
	private int jmlBarang;
	private int status;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Barang barang;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJmlBarang() {
		return jmlBarang;
	}
	public void setJmlBarang(int jmlBarang) {
		this.jmlBarang = jmlBarang;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Barang getBarang() {
		return barang;
	}
	public void setBarang(Barang barang) {
		this.barang = barang;
	}
}
