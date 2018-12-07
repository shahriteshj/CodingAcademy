/**
 * 
 */
package com.jpm.jpacrud.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jpm.jpacrud.dao.EmployeeDao;
import com.jpm.jpacrud.dao.IEmployeeDao;
import com.jpm.jpacrud.entities.Employee;
import com.jpm.jpacrud.exception.EmployeeException;

/**
 * @author brije
 *
 */
public class EmployeeDaoTest {
	private static IEmployeeDao employeeDao;
	
	@BeforeClass
	public static void  testDaoObject() {
		employeeDao= new EmployeeDao();
		Assert.assertNotNull("employeeDao is Null ", employeeDao);
	}
	
	@Test
	public  void  testAddEmployee() throws EmployeeException {
		Employee employee = new Employee("Smita", 9999.99);
		Long empId =employeeDao.addEmployee(employee);
		Assert.assertTrue("EMployee not added", empId>0);
	}
}
