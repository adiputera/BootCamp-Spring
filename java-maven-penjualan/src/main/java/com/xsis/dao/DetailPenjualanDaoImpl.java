package com.xsis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.model.DetailPenjualan;

@Repository
public class DetailPenjualanDaoImpl implements DetailPenjualanDao {

	@Autowired
	SessionFactory sessionFactory;
	public void save(DetailPenjualan dp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(dp);
		session.flush();
	}

}
