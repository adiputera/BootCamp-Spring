package com.xsis.batch137.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Barang;
import com.xsis.batch137.model.Customer;
import com.xsis.batch137.service.BarangService;
import com.xsis.batch137.service.CustomerService;

@Controller
@RequestMapping("/barang")
public class BarangController {
	
	@Autowired
	BarangService bs;
	
	@RequestMapping
	public String index(Model model) {
		List<Barang> custs = bs.selectAll();
		model.addAttribute("custs", custs);
		return "barang";
	}
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void saveg(@RequestBody Barang barang) {
		bs.save(barang);
	}
}
