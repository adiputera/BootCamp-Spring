package com.xsis.dao;

import java.util.List;

import com.xsis.model.Customer;
import com.xsis.model.Order;

public interface OrderDao {

	void save(Order order);

	List<Order> SearchOrderByCustomer(Customer customer);

	Order SearchOrderByCustomerByIdOrder(Order order);

	void update(Order order);
	
	void ubahStatus(Order order);

	void cancel(Order order);

	Order getOne(Order order);
	
	List<Order> SearchAllOrderByCustomer(Customer customer);
	
	List<Order> SearchCancelOrderByCustomer(Customer customer);
	
	List<Order> SearchOrderDibayarByCustomer(Customer customer);
}
