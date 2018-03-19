package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.RegionsDao;
import com.xsis.batch137.model.Regions;

@Service
@Transactional
public class RegionsService {
	
	@Autowired
	RegionsDao rd;
	public void save(Regions regions) {
		rd.save(regions);
	}
	
	public void update(Regions regions) {
		rd.update(regions);
	}
	
	public void delete(int id) {
		Regions regions = new Regions();
		regions.setId(id);
		rd.delete(regions);
	}
	
	public List<Regions> selectAll(){
		return rd.selectAll();
	}
	
	public Regions getOne(int id) {
		Regions regions = new Regions();
		regions.setId(id);
		return rd.getOne(regions);
	}
}
