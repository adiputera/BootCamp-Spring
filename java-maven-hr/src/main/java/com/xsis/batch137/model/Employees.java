package com.xsis.batch137.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees_ex")
public class Employees {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="hire_date")
	private Date hireDate;
	
	private float salary;
	
	@Column(name="commission_pct")
	private float commissionPct;
	
	@ManyToOne(cascade=javax.persistence.CascadeType.ALL)
	private Employees manager;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager")
	private List<Employees> employees;
	
	@ManyToOne(cascade=javax.persistence.CascadeType.ALL)
	private Departments departments;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="manager")
	private List<Departments> department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public float getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(float commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public List<Departments> getDepartment() {
		return department;
	}

	public void setDepartment(List<Departments> department) {
		this.department = department;
	}
	
}
