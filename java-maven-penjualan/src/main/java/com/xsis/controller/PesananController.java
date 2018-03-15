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

import com.xsis.model.Pesanan;
import com.xsis.service.PesananService;

@Controller
@RequestMapping("/pesanan")
public class PesananController {
	
	@Autowired
	PesananService bs;
	
	@RequestMapping
	public String index(Model model) {
		List<Pesanan> pesan = bs.selectAll();
		model.addAttribute("pesans", pesan);
		return "Pesanan";
	}
	
	@RequestMapping("/listPesanan")
	public String listPesanan(Model model) {
		List<Pesanan> pesan = bs.selectAll();
		model.addAttribute("pesans", pesan);
		return "listPesanan";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Pesanan pesan) {
		bs.saveOrUpdate(pesan);
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public Pesanan getOne(@PathVariable int id) {
		Pesanan pesan = bs.getOne(id);
		return pesan;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Pesanan pesan) {
		bs.update(pesan);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		Pesanan pesan = new Pesanan();
		pesan.setId(id);
		bs.delete(pesan);
	}
}
