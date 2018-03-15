package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xsis.batch137.model.Barang;
import com.xsis.batch137.model.Customer;
import com.xsis.batch137.service.BarangService;
import com.xsis.batch137.service.CustomerService;

@Controller
@RequestMapping("/menu")
public class DaftarBarangController {
	
	@Autowired
	BarangService barangService;
	@Autowired
	CustomerService cs;
	@RequestMapping
	public String index(Model model) {
		List<Barang> barangs = barangService.selectAll();
		List<Customer> custs = cs.selectAll();
		model.addAttribute("barangs", barangs);
		model.addAttribute("custs", custs);
		return "daftar-barang";
	}
	
	@RequestMapping(value="/src", method=RequestMethod.GET)
	public String indexBySearch(@RequestParam("search") String search, Model model) {
		List<Barang> barangs = barangService.selectAll();
		List<Customer> custs = cs.selectAll();
		model.addAttribute("barangs", barangs);
		model.addAttribute("custs", custs);
		return "daftar-barang";
	}
}
