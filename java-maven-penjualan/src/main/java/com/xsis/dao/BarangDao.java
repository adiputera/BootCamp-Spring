package com.xsis.dao;

import java.util.List;

import com.xsis.model.Barang;

public interface BarangDao {
	public void save(Barang brg);
	//read list
	public List<Barang> selectAll();
	//read single
	public Barang getOne(Barang brg);
	//delete
	public void delete(Barang brg);
	//update
	public void update(Barang brg);
	//save or update
	public void saveAtauUpdate(Barang brg);
}
