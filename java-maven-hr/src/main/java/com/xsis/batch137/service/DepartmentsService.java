package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.DepartmentsDao;
import com.xsis.batch137.model.Departments;

@Service
@Transactional
public class DepartmentsService {

	@Autowired
	DepartmentsDao rd;
	public void save(Departments departments) {
		rd.save(departments);
	}
	
	public void update(Departments departments) {
		rd.update(departments);
	}
	
	public void delete(int id) {
		Departments departments = new Departments();
		departments.setId(id);
		rd.delete(departments);
	}
	
	public List<Departments> selectAll(){
		return rd.selectAll();
	}
	
	public Departments getOne(int id) {
		Departments departments = new Departments();
		departments.setId(id);
		return rd.getOne(departments);
	}
}
