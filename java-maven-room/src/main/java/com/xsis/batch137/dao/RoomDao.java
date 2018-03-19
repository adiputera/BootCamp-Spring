package com.xsis.batch137.dao;

import java.util.List;

import com.xsis.batch137.model.Room;

public interface RoomDao {
	
	void save(Room room);
	
	void update(Room room);
	
	void delete(Room room);
	
	List<Room> selectAll();
	
	Room getOne(Room room);
}
