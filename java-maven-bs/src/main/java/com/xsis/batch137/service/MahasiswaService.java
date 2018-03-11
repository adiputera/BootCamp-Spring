package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.MahasiswaDao;
import com.xsis.batch137.model.Mahasiswa;

@Service
@Transactional
public class MahasiswaService {
	@Autowired
	MahasiswaDao mhsDao;
	public void save(Mahasiswa mhs) {
		mhsDao.save(mhs);
	}
	
	public List<Mahasiswa> selectAll(){
		return mhsDao.selectAll();
	}
	
	public void delete(Mahasiswa mhs) {
		mhsDao.delete(mhs);
	}
	
	public void saveOrUpdate(Mahasiswa mhs) {
		mhsDao.saveAtauUpdate(mhs);
	}

	public Mahasiswa getOne(int id) {
		// TODO Auto-generated method stub
		Mahasiswa mhs = new Mahasiswa();
		mhs.setNim(id);
		return mhsDao.getOne(mhs);
	}
}
