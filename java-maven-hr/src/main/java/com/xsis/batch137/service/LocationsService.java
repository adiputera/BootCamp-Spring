package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.LocationsDao;
import com.xsis.batch137.model.Locations;

@Service
@Transactional
public class LocationsService {
	
	@Autowired
	LocationsDao rd;
	public void save(Locations locations) {
		rd.save(locations);
	}
	
	public void update(Locations locations) {
		rd.update(locations);
	}
	
	public void delete(int id) {
		Locations locations = new Locations();
		locations.setId(id);
		rd.delete(locations);
	}
	
	public List<Locations> selectAll(){
		return rd.selectAll();
	}
	
	public Locations getOne(int id) {
		Locations locations = new Locations();
		locations.setId(id);
		return rd.getOne(locations);
	}
}
