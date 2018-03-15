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

import com.xsis.model.DetailPenjualan;
import com.xsis.service.DPService;

@Controller
@RequestMapping("/detail")
public class DetailPenjualanController {
	
	@Autowired
	DPService bs;
	
	@RequestMapping
	public String index(Model model) {
		List<DetailPenjualan> dp = bs.selectAll();
		model.addAttribute("dps", dp);
		return "DetailPenjualan";
	}
	
	@RequestMapping("/listDetailPenjualan")
	public String listDetailPenjualan(Model model) {
		List<DetailPenjualan> dp = bs.selectAll();
		model.addAttribute("dps", dp);
		return "listDetailPenjualan";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody DetailPenjualan dp) {
		bs.saveOrUpdate(dp);
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public DetailPenjualan getOne(@PathVariable int id) {
		DetailPenjualan dp = bs.getOne(id);
		return dp;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody DetailPenjualan dp) {
		bs.update(dp);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		DetailPenjualan dp = new DetailPenjualan();
		dp.setId(id);
		bs.delete(dp);
	}
}
