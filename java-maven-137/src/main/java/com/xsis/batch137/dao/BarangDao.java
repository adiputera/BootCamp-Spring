package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Barang;

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
	
	public List<Barang> getBarangBySearchName(String search);
	
	public void kurangJumlahBarang(Barang brg, int jmlBeli);
	
	public void tambahJumlahBarang(Barang brg, int jmlBeli);
}
