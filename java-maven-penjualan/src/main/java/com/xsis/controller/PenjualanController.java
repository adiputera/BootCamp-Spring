package com.xsis.controller;

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

import com.xsis.model.Penjualan;
import com.xsis.service.PenjualanService;

@Controller
@RequestMapping("/penjualan")
public class PenjualanController {
	
	@Autowired
	PenjualanService ps;
	
	@RequestMapping
	public String index(Model model) {
		List<Penjualan> jual = ps.selectAll();
		model.addAttribute("juals", jual);
		return "Penjualan";
	}
	
	@RequestMapping("/listPenjualan")
	public String listPenjualan(Model model) {
		List<Penjualan> jual = ps.selectAll();
		model.addAttribute("juals", jual);
		return "listPenjualan";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Penjualan jual) {
		ps.saveOrUpdate(jual);
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public Penjualan getOne(@PathVariable int id) {
		Penjualan jual = ps.getOne(id);
		return jual;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Penjualan jual) {
		ps.update(jual);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		Penjualan jual = new Penjualan();
		jual.setId(id);
		ps.delete(jual);
	}
}
