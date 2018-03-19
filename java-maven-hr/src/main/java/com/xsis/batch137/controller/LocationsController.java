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
import com.xsis.batch137.model.Locations;
import com.xsis.batch137.service.CountriesService;
import com.xsis.batch137.service.LocationsService;

@Controller
@RequestMapping("/locations")
public class LocationsController {

	@Autowired
	LocationsService rs;
	
	@Autowired
	CountriesService cs;
	
	@RequestMapping
	public String index(Model model) {
		List<Locations> locationss = rs.selectAll();
		List<Countries> countriess = cs.selectAll();
		model.addAttribute("countriess", countriess);
		model.addAttribute("locationss", locationss);
		return "locations";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void save(@RequestBody Locations locations) {
		rs.save(locations);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Locations locations) {
		rs.update(locations);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		rs.delete(id);
	}
	
	@RequestMapping(value="/get-one/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Locations getOne(@PathVariable int id) {
		return rs.getOne(id);
	}
}
