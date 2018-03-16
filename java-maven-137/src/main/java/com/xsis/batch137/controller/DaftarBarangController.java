package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Barang;
import com.xsis.batch137.model.Customer;
import com.xsis.batch137.model.Order;
import com.xsis.batch137.service.BarangService;
import com.xsis.batch137.service.CustomerService;
import com.xsis.batch137.service.OrderService;

@Controller
@RequestMapping("/menu")
public class DaftarBarangController {
	
	@Autowired
	BarangService barangService;
	@Autowired
	CustomerService cs;
	@Autowired
	OrderService os;
	
	@RequestMapping
	public String index(Model model) {
		List<Barang> barangs = barangService.selectAll();
		List<Customer> custs = cs.selectAll();
		model.addAttribute("barangs", barangs);
		model.addAttribute("custs", custs);
		return "daftar-barang";
	}
	
	@RequestMapping(value="/src", method=RequestMethod.GET)
	public String indexBySearch(@RequestParam(value="search", defaultValue="") String search, Model model) {
		List<Barang> barangs = barangService.getBarangBySearchName(search);
		List<Customer> custs = cs.selectAll();
		model.addAttribute("barangs", barangs);
		model.addAttribute("custs", custs);
		return "daftar-barang";
	}
	
	@RequestMapping(value="/order", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void order(@RequestBody Order order) {
		//jika ada didatabase maka update
		os.save(order);
	}
	
}
