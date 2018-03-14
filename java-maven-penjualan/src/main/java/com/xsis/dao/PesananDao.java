package com.xsis.dao;

import java.util.List;

import com.xsis.model.Pesanan;

public interface PesananDao {
	public void save(Pesanan pesan);
	//read list
	public List<Pesanan> selectAll();
	//read single
	public Pesanan getOne(Pesanan pesan);
	//delete
	public void delete(Pesanan pesan);
	//update
	public void update(Pesanan pesan);
	//save or update
	public void saveAtauUpdate(Pesanan pesan);
}
