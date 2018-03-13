package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Jurusan;

@Repository
public class JurusanDaoImpl implements JurusanDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Jurusan> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Jurusan.class).list();
	}

	public void save(Jurusan jur) {
		// TODO Auto-generated method stub
		
	}

	public Jurusan getOne(Jurusan jur) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Jurusan jur) {
		// TODO Auto-generated method stub
		
	}

	public void update(Jurusan jur) {
		// TODO Auto-generated method stub
		
	}

	public void saveAtauUpdate(Jurusan jur) {
		// TODO Auto-generated method stub
		
	}

}
