package com.xsis.batch137.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xsis.batch137.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.save(emp);
		session.flush();
	}

	public List<Employee> selectAll() {
		// TODO Auto-generated method stub
		//HQL = Hibernate Query Language
		String hql = "from Employee";
		Session session = sessionFactory.getCurrentSession();
		//session.createCriteria(Employee.class).list();
		List<Employee> emp = session.createQuery(hql).list();
		if(emp.isEmpty())
			return null;
			else
				return emp;
		
	}

	public Employee getOne(int id) {
		// TODO Auto-generated method stub
		/*Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee emp where emp.id= :empid"; // titik dua variabel di hql
		List<Employee> employees = session.createQuery(hql).setParameter("empid", emp.getId()).list();
		//Employee employee = session.get(Employee.class, emp.getId());
		Employee empp = employees.get(0);
		if(employees.isEmpty())
			return null;
		else
			
		return empp;*/
		return (Employee) sessionFactory.getCurrentSession().get(
                Employee.class, id);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		//Session session = sessionFactory.getCurrentSession();
		//session.delete(emp);
		//session.flush();
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, id);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
		
	}

	public void update(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.update(emp);
		session.flush();
	}

	public void saveAtauUpdate(Employee emp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(emp);
		session.flush();
	}
	
}
