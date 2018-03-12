package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Employee;
import com.xsis.batch137.model.Mahasiswa;

public interface MahasiswaDao {
	//create
		public void save(Mahasiswa mhs);
		//read list
		public List<Mahasiswa> selectAll();
		//read single
		public Mahasiswa getOne(Mahasiswa mhs);
		//delete
		public void delete(Mahasiswa mhs);
		//update
		public void update(Mahasiswa mhs);
		//save or update
		public void saveAtauUpdate(Mahasiswa mhs);
}
