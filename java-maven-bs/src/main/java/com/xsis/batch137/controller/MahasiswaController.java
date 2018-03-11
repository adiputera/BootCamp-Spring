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

import com.xsis.batch137.model.Mahasiswa;
import com.xsis.batch137.service.MahasiswaService;

@Controller
@RequestMapping("/mhs")
public class MahasiswaController {
	
	@Autowired
	MahasiswaService ms;
	
	@RequestMapping
	public String index(Model model) {
		List<Mahasiswa> mhs = this.getAll();
		model.addAttribute("mhs", mhs);
		return "mhs/mahasiswa";
	}
	
	//========================================================//
	//create
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Mahasiswa mhs) {
		ms.saveOrUpdate(mhs);
	}
	
	//read all
	@RequestMapping(value="/get-all", method=RequestMethod.GET)
	@ResponseBody
	public List<Mahasiswa> getAll(){
		return ms.selectAll();
	}
	//read one
	@RequestMapping(value="/get-one/{id}", method=RequestMethod.GET)
	@ResponseBody
	public Mahasiswa getOne(@PathVariable int id) {
		return ms.getOne(id);
	}
	
	//update
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Mahasiswa mhs) {
		ms.save(mhs);
	}
	
	//delete
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable int id) {
		Mahasiswa mhs = new Mahasiswa();
		mhs.setNim(id);
		ms.delete(mhs);
	}
}
