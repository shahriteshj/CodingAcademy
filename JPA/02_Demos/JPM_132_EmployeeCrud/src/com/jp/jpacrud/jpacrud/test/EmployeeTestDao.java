/**
 * 
 */
package com.jp.jpacrud.jpacrud.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jp.jpacrud.dao.EmployeeDao;
import com.jp.jpacrud.dao.IEmployeeDao;
import com.jp.jpacrud.entity.Employee;
import com.jp.jpacrud.exception.EmployeeException;

/**
 * @author Administrator
 *
 */
public class EmployeeTestDao {
	private static IEmployeeDao employeeDao;
	
	@BeforeClass
	public static void testDaoObject() {
		employeeDao= new EmployeeDao();
		Assert.assertNotNull("employeeDao is Null ", employeeDao);
	}
	@Test
	public void testAddEmployee() throws EmployeeException {
		Employee employee = new Employee("Ruby", 9999.99);
		Long empId =employeeDao.addEmployee(employee);
		Assert.assertTrue("Employee not added", empId>0);
	}

}
