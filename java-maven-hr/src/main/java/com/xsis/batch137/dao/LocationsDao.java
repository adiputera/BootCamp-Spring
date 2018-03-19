package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Locations;

public interface LocationsDao {

	void save(Locations locations);
	
	void update(Locations locations);
	
	void delete(Locations locations);
	
	List<Locations> selectAll();
	
	Locations getOne(Locations locations);
}
