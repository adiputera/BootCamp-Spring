package com.xsis.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DETAIL_PENJUALAN")
public class DetailPenjualan {
	
	@Id
	private int id;
	@ManyToOne
	private Barang barang;
	@ManyToOne
	private Penjualan penjualan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Barang getBarang() {
		return barang;
	}
	public void setBarang(Barang barang) {
		this.barang = barang;
	}
	public Penjualan getPenjualan() {
		return penjualan;
	}
	public void setPenjualan(Penjualan penjualan) {
		this.penjualan = penjualan;
	}
}
