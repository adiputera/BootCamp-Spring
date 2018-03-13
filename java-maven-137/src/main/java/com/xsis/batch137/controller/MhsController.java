package com.xsis.batch137.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Jurusan;
import com.xsis.batch137.model.Mahasiswa;
import com.xsis.batch137.service.JurusanService;
import com.xsis.batch137.service.MahasiswaService;

@Controller
@RequestMapping("/mhs")
public class MhsController {
	@Autowired
	MahasiswaService mhsService;
	
	@Autowired
	JurusanService jService;
	
	@RequestMapping
	public String index(Model model) {
		List<Mahasiswa> mhs = mhsService.selectAll();
		List<Jurusan> jur = jService.selectAll();
		model.addAttribute("mhss", mhs);
		model.addAttribute("jurs", jur);
		return "mahasiswa";
	}
	
	@ModelAttribute("mahasiswa")
	public Mahasiswa getMahasiswaForm() {
		return new Mahasiswa();
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String index(@Valid @ModelAttribute("mahasiswa") Mahasiswa mhs, BindingResult binding, Model model) {
		if(binding.hasErrors()) {
			List<Mahasiswa> mhss = mhsService.selectAll();
			List<Jurusan> jur = jService.selectAll();
			model.addAttribute("mhss", mhss);
			model.addAttribute("jurs", jur);
			return "mahasiswa";
		}
		mhsService.save(mhs);
		return "redirect:/mhs";
	}
	
	@RequestMapping(value="/get-one/{id}")
	@ResponseBody
	public Mahasiswa getOne(@PathVariable int id) {
		Mahasiswa mhs = mhsService.getOne(id);
		return mhs;
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody Mahasiswa mhs) {
		mhsService.update(mhs);
	}
}
