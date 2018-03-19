package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Countries;

@Repository
public class CountriesDaoImpl implements CountriesDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Countries countries) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(countries);
		session.flush();
	}

	public void update(Countries countries) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(countries);
		session.flush();
	}

	public void delete(Countries countries) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(countries);
		session.flush();
	}

	public List<Countries> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Countries.class).list();

	}

	public Countries getOne(Countries countries) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Countries.class, countries.getId());
	}
}
