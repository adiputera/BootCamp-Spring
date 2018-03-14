package com.xsis.dao;

import java.util.List;

import com.xsis.model.Penjualan;

public interface PenjualanDao {
	public void save(Penjualan jual);
	//read list
	public List<Penjualan> selectAll();
	//read single
	public Penjualan getOne(Penjualan jual);
	//delete
	public void delete(Penjualan jual);
	//update
	public void update(Penjualan jual);
	//save or update
	public void saveAtauUpdate(Penjualan jual);
}
