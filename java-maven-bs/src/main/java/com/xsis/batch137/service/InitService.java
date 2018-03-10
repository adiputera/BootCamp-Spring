package com.xsis.batch137.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.model.Employee;

@Service
@Transactional
public class InitService {
	
	@Autowired
	EmployeeService empService;
	//save employee
	@PostConstruct
	public void init() {
		System.out.println("service init work");
		/*Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Fahmi");
		emp.setAddress("di sana");
		emp.setEmail("ini email");
		empService.saveOrUpdate(emp);
		this.getDataEmployee();*/
		//this.deleteEmp(5);
		//this.getDataEmployee();
	}
	
	/*public void getDataEmployee() {
		List<Employee> employees = empService.selectAll();
		for(Employee emp : employees) {
			System.out.println("name : "+ emp.getName());
		}
	}
	
	public void deleteEmp(int id) {
		Employee emp = new Employee();
		emp.setId(id);
		emp.setEmail("a");
		empService.delete(emp);
	}*/
}
