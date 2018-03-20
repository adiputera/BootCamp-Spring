package com.xsis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.model.Barang;
import com.xsis.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Customer cust) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(cust);
		session.flush();
	}

	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Customer.class).list();
	}

	public Customer getCustomerById(String id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Customer cust = session.get(Customer.class, id);
		return cust;
	}
	
}
