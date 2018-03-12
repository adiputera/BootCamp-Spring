package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Mahasiswa;

@Repository
public class MahasiswaDaoImpl implements MahasiswaDao{
	
	@Autowired
	SessionFactory sessionFactory;
	public void save(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(mhs);
		session.flush();
	}

	public List<Mahasiswa> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Mahasiswa.class).list();
	}

	public Mahasiswa getOne(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Mahasiswa.class, mhs.getId());
	}

	public void delete(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		
	}

	public void update(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		
	}

	public void saveAtauUpdate(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		
	}
	
}
