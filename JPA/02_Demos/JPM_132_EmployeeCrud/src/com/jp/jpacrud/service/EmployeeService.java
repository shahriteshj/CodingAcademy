/**
 * 
 */
package com.jp.jpacrud.service;

import java.util.List;

import com.jp.jpacrud.dao.EmployeeDao;
import com.jp.jpacrud.dao.IEmployeeDao;
import com.jp.jpacrud.entity.Employee;
import com.jp.jpacrud.exception.EmployeeException;

/**
 * @author Administrator
 *
 */
public class EmployeeService implements IEmployeeService {
	//prepwork - create object of IEmployeeDao
	private IEmployeeDao employeeDao;
	
	public EmployeeService() {
		employeeDao=new EmployeeDao();
	
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see com.jp.jpacrud.dao.IEmployeeDao#addEmployee(com.jp.jpacrud.entity.Employee)
	 */
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		// call dao layer method and return to Client
		employeeDao.beginTransaction();
		employeeDao.updateEmployee(employee);
		employeeDao.commitTransaction();
		return employee.getEmployeeId(); 
	}
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employee getEmployeeById(Long custId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Long deleteEmployeeById(Long empId) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}
}
