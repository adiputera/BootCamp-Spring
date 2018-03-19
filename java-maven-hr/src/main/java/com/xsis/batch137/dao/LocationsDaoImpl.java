package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Locations;

@Repository
public class LocationsDaoImpl implements LocationsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Locations locations) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(locations);
		session.flush();
	}

	public void update(Locations locations) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(locations);
		session.flush();
	}

	public void delete(Locations locations) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(locations);
		session.flush();
	}

	public List<Locations> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Locations.class).list();

	}

	public Locations getOne(Locations locations) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Locations.class, locations.getId());
	}
}
