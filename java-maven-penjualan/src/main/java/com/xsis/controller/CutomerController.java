package com.xsis.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.model.Customer;
import com.xsis.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CutomerController {
	
	@Autowired
	CustomerService cs;
	
	@RequestMapping
	public String index(Model model) {
		List<Customer> cust = cs.selectAll();
		model.addAttribute("custs", cust);
		return "customer";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void index(@RequestBody Customer cust) {
		cs.saveOrUpdate(cust);
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public Customer getOne(@PathVariable int id) {
		Customer cust = cs.getOne(id);
		return cust;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Customer cust) {
		cs.update(cust);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		Customer cust = new Customer();
		cust.setId(id);
		cs.delete(cust);
	}
}
