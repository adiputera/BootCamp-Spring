package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Employees;

@Repository
public class EmployeesDaoImpl implements EmployeesDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Employees employees) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employees);
		session.flush();
	}

	public void update(Employees employees) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(employees);
		session.flush();
	}

	public void delete(Employees employees) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(employees);
		session.flush();
	}

	public List<Employees> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Employees.class).list();

	}

	public Employees getOne(Employees employees) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Employees.class, employees.getId());
	}
}
