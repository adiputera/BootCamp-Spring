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

	public Mahasiswa getOne(int id) {
		// TODO Auto-generated method stub
		Mahasiswa mhs = new Mahasiswa();
		mhs.setId(id);
		mhs.setName("nama");
		return mhsDao.getOne(mhs);
	}

	public List<Mahasiswa> selectAll() {
		// TODO Auto-generated method stub
		return mhsDao.selectAll();
	}
	
	public void update(Mahasiswa mhs) {
		mhsDao.update(mhs);
	}

	public void delete(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		mhsDao.delete(mhs);
	}
}
