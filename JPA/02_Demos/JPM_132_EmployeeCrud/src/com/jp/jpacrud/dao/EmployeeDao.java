package com.jp.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jp.jpacrud.entity.Employee;
import com.jp.jpacrud.exception.EmployeeException;
import com.jp.jpacrud.util.JPAUtil;

public class EmployeeDao implements IEmployeeDao {
	//prep work in Dao-> EntityManager Object
	private EntityManager entityManager;
	public EmployeeDao() {
	entityManager= JPAUtil.getEntityManager();
	}
/*(non-Javadoc)
 * @see com.jp.jpacrud.dao.IEmployeeDao#addEmployee(com.jp.jpacrud.entity.Employee)
 */
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
		// TODO Auto-generated method stub
	
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
		// TODO Auto-generated method stub
		return empId ;
	
	}
	@Override
	public void commitTransaction() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}

}
