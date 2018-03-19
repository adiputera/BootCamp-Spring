package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Employees;

public interface EmployeesDao {

	void save(Employees employees);
	
	void update(Employees employees);
	
	void delete(Employees employees);
	
	List<Employees> selectAll();
	
	Employees getOne(Employees employees);
}
