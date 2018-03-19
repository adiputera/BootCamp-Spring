package com.xsis.batch137.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xsis.batch137.dao.RoomDao;
import com.xsis.batch137.model.Room;

@Service
@Transactional
public class RoomService {
	
	@Autowired
	RoomDao rd;
	public void save(Room room) {
		rd.save(room);
	}
	
	public void update(Room room) {
		rd.update(room);
	}
	
	public void delete(int id) {
		Room room = new Room();
		room.setId(id);
		rd.delete(room);
	}
	
	public List<Room> selectAll(){
		return rd.selectAll();
	}
	
	public Room getOne(int id) {
		Room room = new Room();
		room.setId(id);
		return rd.getOne(room);
	}
}
