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
public class MhsController {
	@Autowired
	MahasiswaService mhsService;
	
	@RequestMapping
	public String index(Model model) {
		List<Mahasiswa> mhs = mhsService.selectAll();
		model.addAttribute("mhss", mhs);
		return "mahasiswa";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void index(@RequestBody Mahasiswa mhs) {
		mhsService.save(mhs);
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public Mahasiswa getOne(@PathVariable int id) {
		Mahasiswa mhs = mhsService.getOne(id);
		return mhs;
	}
}
