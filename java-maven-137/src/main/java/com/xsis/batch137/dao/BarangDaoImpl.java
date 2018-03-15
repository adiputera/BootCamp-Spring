package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Barang;

@Repository
public class BarangDaoImpl implements BarangDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void save(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(brg);
		session.flush();
	}

	public List<Barang> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Barang.class).list();
	}

	public Barang getOne(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Barang.class, brg.getId());
	}

	public void delete(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(brg);
	}

	public void update(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(brg);
	}

	public void saveAtauUpdate(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(brg);
	}
	
	
}
