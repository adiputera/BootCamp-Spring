package com.xsis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.model.Penjualan;

@Repository
public class PenjualanDaoImpl implements PenjualanDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Penjualan jual) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(jual);
		session.flush();
	}

	public List<Penjualan> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Penjualan.class).list();
	}

	public Penjualan getOne(Penjualan jual) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Penjualan.class, jual.getId());
	}

	public void delete(Penjualan jual) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(jual);
		session.flush();
	}

	public void update(Penjualan jual) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(jual);
		session.flush();
	}

	public void saveAtauUpdate(Penjualan jual) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(jual);
		session.flush();
	}

}
