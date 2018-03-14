package com.xsis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PENJUALAN")
public class Penjualan {
	
	@Id
	private int id;
	private int items;
	private double total;
	@Column(name="kode_transaksi")
	private int kodeTransaksi;
	@Column(name="status_bayar")
	private String statusBayar;
	
	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy="penjualan")
	List<DetailPenjualan> dps;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getKodeTransaksi() {
		return kodeTransaksi;
	}
	public void setKodeTransaksi(int kodeTransaksi) {
		this.kodeTransaksi = kodeTransaksi;
	}
	public String getStatusBayar() {
		return statusBayar;
	}
	public void setStatusBayar(String statusBayar) {
		this.statusBayar = statusBayar;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<DetailPenjualan> getDps() {
		return dps;
	}
	public void setDps(List<DetailPenjualan> dps) {
		this.dps = dps;
	}
	
}
