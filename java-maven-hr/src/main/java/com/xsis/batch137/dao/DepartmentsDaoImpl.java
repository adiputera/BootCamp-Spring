package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Departments;

@Repository
public class DepartmentsDaoImpl implements DepartmentsDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Departments departments) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(departments);
		session.flush();
	}

	public void update(Departments departments) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(departments);
		session.flush();
	}

	public void delete(Departments departments) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(departments);
		session.flush();
	}

	public List<Departments> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Departments.class).list();

	}

	public Departments getOne(Departments departments) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Departments.class, departments.getId());
	}
}
