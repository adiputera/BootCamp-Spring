package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xsis.batch137.model.Countries;
import com.xsis.batch137.model.Departments;
import com.xsis.batch137.model.Employees;
import com.xsis.batch137.model.Locations;
import com.xsis.batch137.model.Regions;
import com.xsis.batch137.service.CountriesService;
import com.xsis.batch137.service.DepartmentsService;
import com.xsis.batch137.service.EmployeesService;
import com.xsis.batch137.service.LocationsService;
import com.xsis.batch137.service.RegionsService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	RegionsService rs;
	
	@Autowired
	CountriesService cs;
	
	@Autowired
	LocationsService ls;
	
	@Autowired
	DepartmentsService ds;
	
	@Autowired
	EmployeesService es;
	
	@RequestMapping
	public String index(Model model) {
		List<Employees> emps = es.selectAll();
		List<Departments> deps = ds.selectAll();
		List<Locations> locs = ls.selectAll();
		List<Countries> couns = cs.selectAll();
		List<Regions> regs = rs.selectAll();
		model.addAttribute("emps", emps);
		model.addAttribute("deps", deps);
		model.addAttribute("locs", locs);
		model.addAttribute("couns", couns);
		model.addAttribute("regs", regs);
		return "index";
	}
}
