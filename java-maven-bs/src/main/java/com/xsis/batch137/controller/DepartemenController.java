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

import com.xsis.batch137.model.Departemen;
import com.xsis.batch137.service.DepartemenService;

@Controller
@RequestMapping("/dep")
public class DepartemenController {
	@Autowired
	DepartemenService ds;
	
	@RequestMapping
	public String index(Model model) {
		List<Departemen> deps = this.getAll();
		model.addAttribute("deps", deps);
		return "dep/departemen";
	}
	
	//========================================================//
	//create
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Departemen dep) {
		ds.saveOrUpdate(dep);
	}
	
	//read all
	@RequestMapping(value="/get-all", method=RequestMethod.GET)
	@ResponseBody
	public List<Departemen> getAll(){
		return ds.selectAll();
	}
	//read one
	@RequestMapping(value="/get-one/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Departemen getOne(@PathVariable int id) {
		return ds.getOne(id);
	}
	
	//update
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Departemen dep) {
		ds.save(dep);
	}
	
	//delete
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		Departemen dep = new Departemen();
		dep.setId(id);
		dep.setEmail("1");
		ds.delete(dep);
	}
}
