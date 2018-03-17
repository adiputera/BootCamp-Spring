package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.BarangDao;
import com.xsis.batch137.dao.OrderDao;
import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;

@Service
@Transactional
public class OrderService {

	@Autowired
	BarangDao bd;
	
	@Autowired
	OrderDao od;
	
	public void save(Order order) {
		// TODO Auto-generated method stub
		Order oldOrder = od.SearchOrderByCustomerByIdOrder(order);
		int newJb = 0;
		bd.kurangJumlahBarang(order.getBarang(), order.getJumlahBeli());
		if(oldOrder!=null) {
			newJb = oldOrder.getJumlahBeli() + order.getJumlahBeli();
			order.setJumlahBeli(newJb);
			order.setId(oldOrder.getId());
			this.update(order);
		}else {
			od.save(order);
		}
		
	}
	public List<Order> searchOrderByCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return od.SearchOrderByCustomer(customer);
	}
	public Order SearchOrderByCustomerByIdOrder(Order order) {
		// TODO Auto-generated method stub
		return od.SearchOrderByCustomerByIdOrder(order);
	}
	public void update(Order order) {
		// TODO Auto-generated method stub
		od.update(order);
	}
	public void cancel(Order order) {
		// TODO Auto-generated method stub
		od.cancel(order);
	}
	public Order getOne(String id) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setId(id);
		order.setJumlahBeli(0);
		return od.getOne(order);
	}

}
