package com.xsis.batch137.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MAHASISWA_XE")
public class Mahasiswa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(nullable=false)
	@NotNull
	@NotEmpty
	@Size(min=4, max = 30, message="Harus 4-30 karakter")
	private String name;
	
	//relation jurusan
	@ManyToOne
	private Jurusan jurusan;
	
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
	public Jurusan getJurusan() {
		return jurusan;
	}
	public void setJurusan(Jurusan jurusan) {
		this.jurusan = jurusan;
	}
	
	
}
