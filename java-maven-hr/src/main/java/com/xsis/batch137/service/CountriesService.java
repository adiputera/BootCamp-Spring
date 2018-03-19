package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.CountriesDao;
import com.xsis.batch137.model.Countries;

@Service
@Transactional
public class CountriesService {
	
	@Autowired
	CountriesDao rd;
	public void save(Countries countries) {
		rd.save(countries);
	}
	
	public void update(Countries countries) {
		rd.update(countries);
	}
	
	public void delete(int id) {
		Countries countries = new Countries();
		countries.setId(id);
		rd.delete(countries);
	}
	
	public List<Countries> selectAll(){
		return rd.selectAll();
	}
	
	public Countries getOne(int id) {
		Countries countries = new Countries();
		countries.setId(id);
		return rd.getOne(countries);
	}
}
