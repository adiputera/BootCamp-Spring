package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Room;

@Repository
public class RoomDaoImpl implements RoomDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void save(Room room) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(room);
		session.flush();
	}

	public void update(Room room) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(room);
		session.flush();
	}

	public void delete(Room room) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(room);
		session.flush();
	}

	public List<Room> selectAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Room.class).list();

	}

	public Room getOne(Room room) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.get(Room.class, room.getId());
	}
	
}
