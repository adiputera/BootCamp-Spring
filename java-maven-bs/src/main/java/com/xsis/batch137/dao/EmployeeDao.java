package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Employee;

public interface EmployeeDao {
	//create
	public void save(Employee emp);
	//read list
	public List<Employee> selectAll();
	//read single
	public Employee getOne(Employee emp);
	//delete
	public void delete(Employee emp);
	//update
	public void update(Employee emp);
	//save or update
	public void saveAtauUpdate(Employee emp);
}
