package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Departments;

public interface DepartmentsDao {

	void save(Departments departments);
	
	void update(Departments departments);
	
	void delete(Departments departments);
	
	List<Departments> selectAll();
	
	Departments getOne(Departments departments);
}
