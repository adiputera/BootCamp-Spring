package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Departemen;
import com.xsis.batch137.model.Employee;

@Repository
public class DepartemenDaoImpl implements DepartemenDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Departemen dep) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(dep);
		session.flush();
	}

	public List<Departemen> selectAll() {
		// TODO Auto-generated method stub
		String hql = "from Departemen";
		Session session = sessionFactory.getCurrentSession();
		List<Departemen> deps = session.createQuery(hql).list();
		if(deps.isEmpty())
			return null;
			else
				return deps;
		
	}

	public Departemen getOne(Departemen dep) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Departemen dep where dep.id= :depid"; // titik dua variabel di hql
		List<Departemen> deps = session.createQuery(hql).setParameter("depid", dep.getId()).list();
		Departemen depp = deps.get(0);
		if(deps.isEmpty())
			return null;
		else
			
		return depp;
	}

	public void delete(Departemen dep) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(dep);
		session.flush();
	}

	public void update(Departemen dep) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(dep);
		session.flush();
	}

	public void saveAtauUpdate(Departemen dep) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(dep);
		session.flush();
	}
	
}
