package com.xsis.dao;

import java.util.List;

import com.xsis.model.Customer;

public interface CustomerDao {

	void save(Customer cust);

	List<Customer> selectAll();

	Customer getCustomerById(String id);
	
}
