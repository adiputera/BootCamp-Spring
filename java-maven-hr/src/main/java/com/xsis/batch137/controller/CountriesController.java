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

import com.xsis.batch137.model.Countries;
import com.xsis.batch137.model.Regions;
import com.xsis.batch137.service.CountriesService;
import com.xsis.batch137.service.RegionsService;

@Controller
@RequestMapping("/countries")
public class CountriesController {

	@Autowired
	CountriesService rs;
	
	@Autowired
	RegionsService regService;
	
	@RequestMapping
	public String index(Model model) {
		List<Countries> countriess = rs.selectAll();
		List<Regions> regionss = regService.selectAll();
		model.addAttribute("regionss", regionss);
		model.addAttribute("countriess", countriess);
		return "countries";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void save(@RequestBody Countries countries) {
		rs.save(countries);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Countries countries) {
		rs.update(countries);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		rs.delete(id);
	}
	
	@RequestMapping(value="/get-one/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Countries getOne(@PathVariable int id) {
		return rs.getOne(id);
	}
}
