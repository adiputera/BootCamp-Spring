package com.xsis.batch137.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xsis.batch137.model.Penjualan;
import com.xsis.batch137.service.PenjualanService;

@Controller
@RequestMapping("/penjualan")
public class PenjualanController {
	
	@Autowired
	PenjualanService ps;
	
	@RequestMapping(value = "/save", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void save(@RequestBody Penjualan penjualan) {
		ps.save(penjualan);
	}
}
