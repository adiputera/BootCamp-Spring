package com.xsis.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BARANG")
public class Barang {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="idbrg")
	@SequenceGenerator(initialValue = 1, name = "idbrg", sequenceName = "idbrg")
	private int id;
	@Column(name="nama_barang")
	private String namaBarang;
	private double harga;
	private int stock;
	
	@OneToMany(mappedBy="barang")
	List<DetailPenjualan> dps;
	
	@OneToMany(mappedBy="barang")
	List<Pesanan> pesans;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public double getHarga() {
		return harga;
	}
	public void setHarga(double harga) {
		this.harga = harga;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public List<DetailPenjualan> getDps() {
		return dps;
	}
	public void setDps(List<DetailPenjualan> dps) {
		this.dps = dps;
	}
	public List<Pesanan> getPesans() {
		return pesans;
	}
	public void setPesans(List<Pesanan> pesans) {
		this.pesans = pesans;
	}
	
	
}
