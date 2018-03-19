package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Countries;

public interface CountriesDao {
	
	void save(Countries countries);
	
	void update(Countries countries);
	
	void delete(Countries countries);
	
	List<Countries> selectAll();
	
	Countries getOne(Countries countries);
}
