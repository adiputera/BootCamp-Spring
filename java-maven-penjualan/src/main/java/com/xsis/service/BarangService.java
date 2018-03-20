package com.xsis.service;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.dao.BarangDao;
import com.xsis.model.Barang;
import com.xsis.model.Order;

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

	public List<Barang> getBarangBySearchName(String search) {
		// TODO Auto-generated method stub
		return bDao.getBarangBySearchName(search);
	}

	public void cancel(Order order) {
		// TODO Auto-generated method stub
		Barang barang = new Barang();
		barang.setId(order.getBarang().getId());
		bDao.tambahJumlahBarang(barang, order.getJumlahBeli());
	}
}
