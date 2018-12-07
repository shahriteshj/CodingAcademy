/**
 * 
 */
package com.jpm.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpm.jpacrud.entities.Employee;
import com.jpm.jpacrud.exception.EmployeeException;
import com.jpm.jpacrud.util.JPAUtil;

/**
 * @author brije
 *
 */
public class EmployeeDao implements IEmployeeDao {
	//prep work in Dao-> EnttityManager Object
	private EntityManager entityManager;
	public EmployeeDao() {
		entityManager= JPAUtil.getEntityManager();
	}
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		entityManager.persist(employee);
		return employee.getEmployeeId();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		Query query = entityManager.createQuery("from Employee");
		return query.getResultList();
	}
	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return entityManager.find(Employee.class, empId);
	}
	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return entityManager.merge(employee);
	}
	@Override
	public Long deleteEmployeeById(Long empId) throws EmployeeException {
		entityManager.remove(getEmployeeById(empId));
		return empId;
	}
	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}
	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

}
