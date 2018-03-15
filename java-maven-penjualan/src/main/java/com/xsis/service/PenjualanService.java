package com.xsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.dao.PenjualanDao;
import com.xsis.model.Penjualan;

@Service
@Transactional
public class PenjualanService {
	
	@Autowired
	PenjualanDao cDao;
	
	public void save(Penjualan jual) {
		cDao.save(jual);
	}
	
	public List<Penjualan> selectAll(){
		return cDao.selectAll();
	}
	
	public void delete(Penjualan jual) {
		cDao.delete(jual);
	}
	
	public void saveOrUpdate(Penjualan jual) {
		cDao.saveAtauUpdate(jual);
	}

	public Penjualan getOne(int id) {
		// TODO Auto-generated method stub
		Penjualan Penjualan = new Penjualan();
		Penjualan.setId(id);
		return cDao.getOne(Penjualan);
	}

	public void update(Penjualan jual) {
		// TODO Auto-generated method stub
		cDao.update(jual);
	}
}
