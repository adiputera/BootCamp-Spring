package com.xsis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.dao.CustomerDao;
import com.xsis.model.Customer;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerDao cDao;
	
	public void save(Customer cust) {
		cDao.save(cust);
	}
	
	public List<Customer> selectAll(){
		return cDao.selectAll();
	}
	
	public void delete(Customer cust) {
		cDao.delete(cust);
	}
	
	public void saveOrUpdate(Customer cust) {
		cDao.saveAtauUpdate(cust);
	}

	public Customer getOne(int id) {
		// TODO Auto-generated method stub
		Customer Customer = new Customer();
		Customer.setId(id);
		return cDao.getOne(Customer);
	}

	public void update(Customer cust) {
		// TODO Auto-generated method stub
		cDao.update(cust);
	}
}
