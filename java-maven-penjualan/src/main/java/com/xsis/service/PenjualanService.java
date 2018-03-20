package com.xsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.dao.DetailPenjualanDao;
import com.xsis.dao.OrderDao;
import com.xsis.dao.PenjualanDao;
import com.xsis.model.Barang;
import com.xsis.model.DetailPenjualan;
import com.xsis.model.Order;
import com.xsis.model.Penjualan;

@Service
@Transactional
public class PenjualanService {
	
	@Autowired
	PenjualanDao pDao;
	
	@Autowired
	DetailPenjualanDao dDao;
	
	@Autowired
	OrderDao oDao;
	
	public void save(Penjualan penjualan) {
		Penjualan pen = new Penjualan();
		pen.setCustomer(penjualan.getCustomer());
		pen.setTotalHarga(penjualan.getTotalHarga());
		pen.setTotalItem(penjualan.getTotalItem());
		pDao.save(pen);
		for(Order order : oDao.SearchOrderByCustomer(pen.getCustomer())) {
			oDao.ubahStatus(order);
		}
		for(DetailPenjualan dp : penjualan.getDetailPenjualan()) {
			Barang barang = new Barang();
			barang.setId(dp.getBarang().getId());
			DetailPenjualan det = new DetailPenjualan();
			det.setBarang(barang);
			det.setJumlahBeli(dp.getJumlahBeli());
			det.setPenjualan(pen);
			dDao.save(det);
		}
		
	}
}
