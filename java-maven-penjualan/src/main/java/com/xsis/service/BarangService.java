package com.xsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.dao.BarangDao;
import com.xsis.model.Barang;

@Service
@Transactional
public class BarangService {
	
	@Autowired
	BarangDao bDao;
	
	public void save(Barang brg) {
		bDao.save(brg);
	}
	
	public List<Barang> selectAll(){
		return bDao.selectAll();
	}
	
	public void delete(Barang brg) {
		bDao.delete(brg);
	}
	
	public void saveOrUpdate(Barang brg) {
		bDao.saveAtauUpdate(brg);
	}

	public Barang getOne(int id) {
		// TODO Auto-generated method stub
		Barang barang = new Barang();
		barang.setId(id);
		barang.setHarga(0);
		barang.setStock(0);
		return bDao.getOne(barang);
	}

	public void update(Barang brg) {
		// TODO Auto-generated method stub
		bDao.update(brg);
	}
}
