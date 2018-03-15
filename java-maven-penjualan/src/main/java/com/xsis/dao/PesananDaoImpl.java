package com.xsis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.model.Pesanan;
import com.xsis.model.Pesanan;

@Repository
public class PesananDaoImpl implements PesananDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Pesanan psn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(psn);
		session.flush();
	}

	public List<Pesanan> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Pesanan.class).list();
	}

	public Pesanan getOne(Pesanan psn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Pesanan.class, psn.getId());
	}

	public void delete(Pesanan psn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(psn);
		session.flush();
	}

	public void update(Pesanan psn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(psn);
		session.flush();
	}

	public void saveAtauUpdate(Pesanan psn) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(psn);
		session.flush();
	}
}
