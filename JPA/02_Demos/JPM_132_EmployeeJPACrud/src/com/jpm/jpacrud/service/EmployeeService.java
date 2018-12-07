/**
 * 
 */
package com.jpm.jpacrud.service;

import java.util.List;

import com.jpm.jpacrud.dao.EmployeeDao;
import com.jpm.jpacrud.dao.IEmployeeDao;
import com.jpm.jpacrud.entities.Employee;
import com.jpm.jpacrud.exception.EmployeeException;

/**
 * @author Smita
 *
 */
public class EmployeeService implements IEmployeeService {
//prepwork - create object of IEmployeeDao
	private IEmployeeDao employeeDao;
	
	public EmployeeService() {
		employeeDao=new EmployeeDao();
	}
	/* (non-Javadoc)
	 * @see com.jpm.jpacrud.service.IEmployeeService#addEmployee(com.jpm.jpacrud.entities.Employee)
	 */
	@Override
	public Long addEmployee(Employee employee) throws EmployeeException {
		// call dao layer method and return to Client
		employeeDao.beginTransaction();
		employeeDao.addEmployee(employee);
		employeeDao.commitTransaction();
		return employee.getEmployeeId();//auto generated emp id will be returned
	}
	@Override
	public List<Employee> getEmployeeList() throws EmployeeException {
		// call Dao layer method and return to Service layer
		return employeeDao.getEmployeeList();
	}
	@Override
	public Employee getEmployeeById(Long empId) throws EmployeeException {
		// call Dao layer method and return to Service layer
		return employeeDao.getEmployeeById(empId);
	}
	@Override
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		employeeDao.beginTransaction();
		employeeDao.updateEmployee(employee);
		employeeDao.commitTransaction();
		return employee;
	}
	@Override
	public Long deleteEmployeeById(Long empId) throws EmployeeException {
		employeeDao.beginTransaction();
		employeeDao.deleteEmployeeById(empId);
		employeeDao.commitTransaction();
		return empId;
	}

}
