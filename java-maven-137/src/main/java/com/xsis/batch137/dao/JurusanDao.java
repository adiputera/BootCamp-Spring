package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Jurusan;
import com.xsis.batch137.model.Mahasiswa;

public interface JurusanDao {
	public void save(Jurusan jur);
	//read list
	public List<Jurusan> selectAll();
	//read single
	public Jurusan getOne(Jurusan jur);
	//delete
	public void delete(Jurusan jur);
	//update
	public void update(Jurusan jur);
	//save or update
	public void saveAtauUpdate(Jurusan jur);
}
