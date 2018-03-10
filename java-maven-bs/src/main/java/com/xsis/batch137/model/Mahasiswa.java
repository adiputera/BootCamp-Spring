package com.xsis.batch137.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MAHASISWA")
public class Mahasiswa {
	public Mahasiswa() {
		// TODO Auto-generated constructor stub
	}
	
	public Mahasiswa(int nim, String nama, String alamat, String univ) {
		super();
		this.nim = nim;
		this.nama = nama;
		this.alamat = alamat;
		this.univ = univ;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int nim;
	private String nama;
	private String alamat;
	@Column(name="universitas")
	private String univ;
	
	public int getNim() {
		return nim;
	}

	public void setNim(int nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}
	
}
