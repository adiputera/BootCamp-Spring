package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Departments;
import com.xsis.batch137.model.Employees;
import com.xsis.batch137.service.DepartmentsService;
import com.xsis.batch137.service.EmployeesService;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

	@Autowired
	EmployeesService rs;
	
	@Autowired
	DepartmentsService ds;
	
	@RequestMapping
	public String index(Model model) {
		List<Employees> employeess = rs.selectAll();
		List<Departments> deps = ds.selectAll();
		model.addAttribute("deps", deps);
		model.addAttribute("employeess", employeess);
		return "employees";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void save(@RequestBody Employees employees) {
		rs.save(employees);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Employees employees) {
		rs.update(employees);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		rs.delete(id);
	}
	
	@RequestMapping(value="/get-one/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Employees getOne(@PathVariable int id) {
		return rs.getOne(id);
	}
}
