package com.xsis.batch137.service;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.BarangDao;
import com.xsis.batch137.model.Barang;

@Service
@Transactional
public class BarangService {
	
	@Autowired
	BarangDao bDao;
	
	public void save(Barang brg) {
		bDao.save(brg);
	}
	
	public void delete(Barang brg) {
		bDao.delete(brg);
	}
	
	public void update(Barang brg) {
		bDao.update(brg);
	}
	
	public List<Barang> selectAll(){
		return bDao.selectAll();
	}
	
	public Barang getOne(String id) {
		Barang barang = new Barang();
		barang.setId(id);
		barang.setNamaBarang("s");
		return bDao.getOne(barang);
	}
}
