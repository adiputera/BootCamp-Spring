package com.xsis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.model.Barang;
import com.xsis.service.BarangService;

@Controller
@RequestMapping("/barang")
public class BarangController {
	
	@Autowired
	BarangService bs;
	
	@RequestMapping
	public String index(Model model) {
		List<Barang> brg = bs.selectAll();
		model.addAttribute("brgs", brg);
		return "barang";
	}
	
	@RequestMapping("/listbarang")
	public String listBarang(Model model) {
		List<Barang> brg = bs.selectAll();
		model.addAttribute("brgs", brg);
		return "listbarang";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Barang brg) {
		bs.saveOrUpdate(brg);
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public Barang getOne(@PathVariable int id) {
		Barang brg = bs.getOne(id);
		return brg;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Barang brg) {
		bs.update(brg);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		Barang brg = new Barang();
		brg.setId(id);
		brg.setHarga(0);
		brg.setStock(0);
		bs.delete(brg);
	}
}
