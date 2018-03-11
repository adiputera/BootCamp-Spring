package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Mahasiswa;

@Repository
public class MahasiswaDaoImpl implements MahasiswaDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(mhs);
		session.flush();
		
	}

	public List<Mahasiswa> selectAll() {
		// TODO Auto-generated method stub
		String hql = "from Mahasiswa";
		Session session = sessionFactory.getCurrentSession();
		List<Mahasiswa> mhs = session.createQuery(hql).list();
		if(mhs.isEmpty())
			return null;
			else
				return mhs;
		
	}

	public Mahasiswa getOne(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Mahasiswa mhs where mhs.nim= :nim";
		List<Mahasiswa> mhss = session.createQuery(hql).setParameter("nim", mhs.getNim()).list();
		Mahasiswa mhsiswa = mhss.get(0);
		if(mhss.isEmpty())
			return null;
		else
		return mhsiswa;
	}

	public void delete(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(mhs);
		session.flush();
	}

	public void update(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(mhs);
		session.flush();
	}

	public void saveAtauUpdate(Mahasiswa mhs) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(mhs);
		session.flush();
	}
	
}
