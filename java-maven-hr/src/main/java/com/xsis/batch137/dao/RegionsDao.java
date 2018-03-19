package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Regions;

public interface RegionsDao {

	void save(Regions regions);
	
	void update(Regions regions);
	
	void delete(Regions regions);
	
	List<Regions> selectAll();
	
	Regions getOne(Regions regions);
}
