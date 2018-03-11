package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.DepartemenDao;
import com.xsis.batch137.model.Departemen;

@Service
@Transactional
public class DepartemenService {
	@Autowired
	DepartemenDao depDao;
	public void save(Departemen dep) {
		depDao.save(dep);
	}
	
	public List<Departemen> selectAll(){
		return depDao.selectAll();
	}
	
	public void delete(Departemen dep) {
		depDao.delete(dep);
	}
	
	public void saveOrUpdate(Departemen dep) {
		depDao.saveAtauUpdate(dep);
	}

	public Departemen getOne(int id) {
		// TODO Auto-generated method stub
		Departemen dep = new Departemen();
		dep.setId(id);
		return depDao.getOne(dep);
	}
}
