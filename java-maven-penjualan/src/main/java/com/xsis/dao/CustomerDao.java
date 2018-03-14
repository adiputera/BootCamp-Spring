package com.xsis.dao;

import java.util.List;

import com.xsis.model.Customer;

public interface CustomerDao {
	public void save(Customer cust);
	//read list
	public List<Customer> selectAll();
	//read single
	public Customer getOne(Customer cust);
	//delete
	public void delete(Customer cust);
	//update
	public void update(Customer cust);
	//save or update
	public void saveAtauUpdate(Customer cust);
}
