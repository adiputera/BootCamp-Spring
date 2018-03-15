package com.xsis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xsis.model.DetailPenjualan;
import com.xsis.model.Customer;
import com.xsis.model.DetailPenjualan;

public class DetailPenjualanDaoImpl implements DetailPenjualanDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(DetailPenjualan dp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(dp);
		session.flush();
	}

	public List<DetailPenjualan> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(DetailPenjualan.class).list();
	}

	public DetailPenjualan getOne(DetailPenjualan dp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(DetailPenjualan.class, dp.getId());
	}

	public void delete(DetailPenjualan dp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(dp);
		session.flush();
	}

	public void update(DetailPenjualan dp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(dp);
		session.flush();
	}

	public void saveAtauUpdate(DetailPenjualan dp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(dp);
		session.flush();
	}
	
}
