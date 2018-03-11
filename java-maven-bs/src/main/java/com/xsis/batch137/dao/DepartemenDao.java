package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Departemen;

public interface DepartemenDao {
	//create
		public void save(Departemen dep);
		//read list
		public List<Departemen> selectAll();
		//read single
		public Departemen getOne(Departemen dep);
		//delete
		public void delete(Departemen dep);
		//update
		public void update(Departemen dep);
		//save or update
		public void saveAtauUpdate(Departemen dep);
}
