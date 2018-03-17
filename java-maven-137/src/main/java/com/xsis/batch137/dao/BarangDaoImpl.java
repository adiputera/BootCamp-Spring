package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Barang;

@Repository
public class BarangDaoImpl implements BarangDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public void save(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(brg);
		session.flush();
	}

	public List<Barang> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Barang where stock > 0";
		return session.createQuery(hql).list();
	}

	public Barang getOne(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Barang.class, brg.getId());
	}

	public void delete(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(brg);
	}

	public void update(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(brg);
	}

	public void saveAtauUpdate(Barang brg) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(brg);
	}

	public List<Barang> getBarangBySearchName(String search) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Barang br where lower(br.namaBarang) like :nb";
		List<Barang> barangs = session.createQuery(hql).setParameter("nb", "%"+search.toLowerCase()+"%").list();
		if(barangs.isEmpty()) {
			return null;
		}
		return barangs;
	}

	public void kurangJumlahBarang(Barang brg, int jmlBeli) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "update Barang set stock = stock - :jmlBeli where id = :id";
		int hasil = session.createQuery(hql).setParameter("jmlBeli", jmlBeli).setParameter("id", brg.getId()).executeUpdate();
	}

	public void tambahJumlahBarang(Barang brg, int jmlBeli) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "update Barang set stock = stock + :jmlBeli where id = :id";
		int hasil = session.createQuery(hql).setParameter("jmlBeli", jmlBeli).setParameter("id", brg.getId()).executeUpdate();
	}
	
	
}
