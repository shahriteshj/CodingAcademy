package com.jp.jpacrud.dao;

import java.util.List;

import com.jp.jpacrud.entity.Employee;
import com.jp.jpacrud.exception.EmployeeException;

public interface IEmployeeDao {
	
	public Long addEmployee(Employee employee) throws EmployeeException; //C-create
	public List<Employee> getEmployeeList()throws EmployeeException;//R All Employee -retrieve
	public Employee getEmployeeById(Long custId)throws EmployeeException;//S-search

	public Employee updateEmployee(Employee employee)throws EmployeeException;//U-update
	public Long deleteEmployeeById(Long empId)throws EmployeeException;//D-delete
public void commitTransaction();
public void beginTransaction();
	}
