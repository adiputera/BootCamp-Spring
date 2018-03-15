package com.xsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.dao.DetailPenjualanDao;
import com.xsis.model.DetailPenjualan;

@Service
@Transactional
public class DPService {
	@Autowired
	DetailPenjualanDao dDao;
	
	public void save(DetailPenjualan dp) {
		dDao.save(dp);
	}
	
	public List<DetailPenjualan> selectAll(){
		return dDao.selectAll();
	}
	
	public void delete(DetailPenjualan dp) {
		dDao.delete(dp);
	}
	
	public void saveOrUpdate(DetailPenjualan dp) {
		dDao.saveAtauUpdate(dp);
	}

	public DetailPenjualan getOne(int id) {
		// TODO Auto-generated method stub
		DetailPenjualan DetailPenjualan = new DetailPenjualan();
		DetailPenjualan.setId(id);
		return dDao.getOne(DetailPenjualan);
	}

	public void update(DetailPenjualan dp) {
		// TODO Auto-generated method stub
		dDao.update(dp);
	}
}
