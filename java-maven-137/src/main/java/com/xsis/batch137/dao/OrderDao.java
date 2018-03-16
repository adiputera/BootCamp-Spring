package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;

public interface OrderDao {

	void save(Order order);

	List<Order> SearchOrderByCustomer(Customer customer);

	Order SearchOrderByCustomerByIdOrder(Order order);

	void update(Order order);
	
	void ubahStatus(Customer customer);

}
