package com.xsis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.model.Barang;
import com.xsis.model.Customer;

@Repository
public class BarangDaoImpl implements BarangDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
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
		session.flush();
	}

	public void update(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(brg);
		session.flush();
	}

	public void saveAtauUpdate(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(brg);
		session.flush();
	}
	
}
