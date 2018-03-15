package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.CustomerDao;
import com.xsis.batch137.model.Customer;

@Service
@Transactional
public class CustomerService {
	@Autowired
	CustomerDao cDao;
	
	public void save(Customer cust) {
		cDao.save(cust);
	}

	public List<Customer> selectAll() {
		// TODO Auto-generated method stub
		return cDao.selectAll();
	}
}
