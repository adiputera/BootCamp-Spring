package com.xsis.batch137.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments_ex")
public class Departments {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="department_name")
	private String departmentName;
	
	@ManyToOne
	private Locations locations;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="departments", cascade= {CascadeType.ALL}, orphanRemoval=true)
	private List<Employees> employees;
	
	//relasi manager
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="manager_id")
	private Employees managers;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Locations getLocations() {
		return locations;
	}

	public void setLocations(Locations locations) {
		this.locations = locations;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public Employees getManagers() {
		return managers;
	}

	public void setManagers(Employees managers) {
		this.managers = managers;
	}


}
