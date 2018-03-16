package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		session.flush();
	}

	public List<Order> SearchOrderByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order order where order.customer = :cus";
		List<Order> orders =  session.createQuery(hql).setParameter("cus", customer).list();
		if(orders.isEmpty()) {
			return null;
		}
		return orders;
	}

	public Order SearchOrderByCustomerByIdOrder(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order order where order.customer = :customer and order.barang = :barang";
		List<Order> orders = session.createQuery(hql).setParameter("customer", order.getCustomer()).setParameter("barang", order.getBarang()).list();
		if(orders.isEmpty()) {
			return null;
		}
		return orders.get(0);
	}

	public void update(Order order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Order or = session.get(Order.class, order.getId());
		or.setId(order.getId());
		or.setCustomer(order.getCustomer());
		or.setJumlahBeli(order.getJumlahBeli());
		or.setBarang(order.getBarang());
		session.update(or);
		session.flush();
	}

}
