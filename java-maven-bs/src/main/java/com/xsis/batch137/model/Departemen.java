package com.xsis.batch137.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTEMEN")
public class Departemen {
	public Departemen() {
		// TODO Auto-generated constructor stub
	}
	
	public Departemen(int id, String namaDepartemen, String alamat, String email) {
		super();
		this.id = id;
		this.namaDepartemen = namaDepartemen;
		this.alamat = alamat;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="nama_departemen")
	private String namaDepartemen;
	private String alamat;
	private String email;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaDepartemen() {
		return namaDepartemen;
	}

	public void setNamaDepartemen(String namaDepartemen) {
		this.namaDepartemen = namaDepartemen;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
