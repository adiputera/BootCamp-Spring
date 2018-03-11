package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsis.batch137.model.Departemen;
import com.xsis.batch137.model.Employee;
import com.xsis.batch137.model.Mahasiswa;
import com.xsis.batch137.service.DepartemenService;
import com.xsis.batch137.service.EmployeeService;
import com.xsis.batch137.service.MahasiswaService;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	EmployeeService empService;
	
	@Autowired
	MahasiswaService ms;
	
	@Autowired
	DepartemenService ds;
	
	@RequestMapping
	public String index(Model model) {
		List<Employee> emps = empService.selectAll();
		List<Mahasiswa> mhs = ms.selectAll();
		List<Departemen> deps = ds.selectAll();
		model.addAttribute("emps", emps);
		model.addAttribute("mhs", mhs);
		model.addAttribute("deps", deps);
		return "index";
	}
	
	@RequestMapping(value="about", method=RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(value="/contact", method=RequestMethod.GET)
	public String contact() {
		return "contact";
	}
}
