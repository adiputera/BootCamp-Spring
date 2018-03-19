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
@Table(name="regions_ex")
public class Regions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="region_name")
	private String regionName;
	
	@OneToMany(mappedBy="regions")
	private List<Countries> countries;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public List<Countries> getCountries() {
		return countries;
	}
	public void setCountries(List<Countries> countries) {
		this.countries = countries;
	}
	
}
