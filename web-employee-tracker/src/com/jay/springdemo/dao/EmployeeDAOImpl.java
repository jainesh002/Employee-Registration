package com.jay.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jay.springdemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override 
	public List<Employee> getEmloyees() {
		// TODO Auto-generated method stub
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query<Employee> theQurey=currentSession.createQuery("from Employee order by firstName",Employee.class);
		
		List<Employee> employees=theQurey.getResultList();
		
		return employees;
		
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public Employee getEmloyee(int theId) {
		Session currentSession=sessionFactory.getCurrentSession();
		
		Employee theEmployee=currentSession.get(Employee.class,theId);
		
		return theEmployee;
	}

	@Override
	public void deleteEmployee(int theId) {
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		Query theQuery=	currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
		
	}

}
