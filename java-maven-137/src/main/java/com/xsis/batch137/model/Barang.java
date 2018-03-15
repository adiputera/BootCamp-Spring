package com.xsis.batch137.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="BARANG_XE")
public class Barang {
	
	public Barang() {
		this.createDate = new Date();
	}
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	private String id;
	@Column(name="nama_barang")
	@NotNull
	@NotEmpty
	private String namaBarang;
	@Column(name="kode_barang")
	private String kodeBarang;
	private Float harga;
	@Temporal(TemporalType.DATE)
	@Column(name="create_date")
	private Date createDate;
	@Column(name="user_create")
	private String userCreate;
	@Temporal(TemporalType.DATE)
	@Column(name="last_modify")
	private Date lastModify;
	private int Stock;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="barang", cascade=javax.persistence.CascadeType.ALL, orphanRemoval=true)
	private List<Order> orders;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public Float getHarga() {
		return harga;
	}
	public void setHarga(Float harga) {
		this.harga = harga;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	public Date getLastModify() {
		return lastModify;
	}
	public void setLastModify(Date lastModify) {
		this.lastModify = lastModify;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getKodeBarang() {
		return kodeBarang;
	}
	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}
	
	
}

