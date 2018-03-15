package com.xsis.dao;

import java.util.List;

import com.xsis.model.DetailPenjualan;

public interface DetailPenjualanDao {
	public void save(DetailPenjualan dp);
	//read list
	public List<DetailPenjualan> selectAll();
	//read single
	public DetailPenjualan getOne(DetailPenjualan dp);
	//delete
	public void delete(DetailPenjualan dp);
	//update
	public void update(DetailPenjualan dp);
	//save or update
	public void saveAtauUpdate(DetailPenjualan dp);
}
