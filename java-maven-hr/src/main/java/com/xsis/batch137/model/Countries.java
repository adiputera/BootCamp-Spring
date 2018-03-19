package com.xsis.batch137.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="countries_ex")
public class Countries {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="countries_name")
	private String countriesName;
	
	@ManyToOne
	private Regions regions;
	
	@OneToMany(mappedBy="countries")
	private List<Locations> location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountriesName() {
		return countriesName;
	}
	public void setCountriesName(String countriesName) {
		this.countriesName = countriesName;
	}
	public Regions getRegions() {
		return regions;
	}
	public void setRegions(Regions regions) {
		this.regions = regions;
	}
	public List<Locations> getLocation() {
		return location;
	}
	public void setLocation(List<Locations> location) {
		this.location = location;
	}
	
	
}
