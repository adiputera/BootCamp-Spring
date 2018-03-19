package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Regions;

@Repository
public class RegionsDaoImpl implements RegionsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Regions regions) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(regions);
		session.flush();
	}

	public void update(Regions regions) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(regions);
		session.flush();
	}

	public void delete(Regions regions) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(regions);
		session.flush();
	}

	public List<Regions> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Regions.class).list();

	}

	public Regions getOne(Regions regions) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Regions.class, regions.getId());
	}
}
