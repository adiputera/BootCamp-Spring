package com.xsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.dao.PesananDao;
import com.xsis.model.Pesanan;

@Service
@Transactional
public class PesananService {
	
	@Autowired
	PesananDao cDao;
	
	public void save(Pesanan pesan) {
		cDao.save(pesan);
	}
	
	public List<Pesanan> selectAll(){
		return cDao.selectAll();
	}
	
	public void delete(Pesanan pesan) {
		cDao.delete(pesan);
	}
	
	public void saveOrUpdate(Pesanan pesan) {
		cDao.saveAtauUpdate(pesan);
	}

	public Pesanan getOne(int id) {
		// TODO Auto-generated method stub
		Pesanan Pesanan = new Pesanan();
		Pesanan.setId(id);
		return cDao.getOne(Pesanan);
	}

	public void update(Pesanan pesan) {
		// TODO Auto-generated method stub
		cDao.update(pesan);
	}
}
