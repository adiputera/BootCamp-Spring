package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.EmployeesDao;
import com.xsis.batch137.model.Employees;

@Service
@Transactional
public class EmployeesService {

	@Autowired
	EmployeesDao rd;
	public void save(Employees employees) {
		rd.save(employees);
	}
	
	public void update(Employees employees) {
		rd.update(employees);
	}
	
	public void delete(int id) {
		Employees employees = new Employees();
		employees.setId(id);
		rd.delete(employees);
	}
	
	public List<Employees> selectAll(){
		return rd.selectAll();
	}
	
	public Employees getOne(int id) {
		Employees employees = new Employees();
		employees.setId(id);
		return rd.getOne(employees);
	}
}
