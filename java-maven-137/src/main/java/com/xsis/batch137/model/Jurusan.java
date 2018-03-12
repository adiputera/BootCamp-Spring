package com.xsis.batch137.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="jurusan_xe")
public class Jurusan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="nama_jurusan")
	private String namaJurusan;
	@OneToMany(mappedBy="jurusan")
	List<Mahasiswa> mhss;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamaJurusan() {
		return namaJurusan;
	}
	public void setNamaJurusan(String namaJurusan) {
		this.namaJurusan = namaJurusan;
	}
	public List<Mahasiswa> getMhss() {
		return mhss;
	}
	public void setMhss(List<Mahasiswa> mhss) {
		this.mhss = mhss;
	}
	
}
