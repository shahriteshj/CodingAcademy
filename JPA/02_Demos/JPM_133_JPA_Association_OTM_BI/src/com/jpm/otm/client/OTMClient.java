package com.jpm.otm.client;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import com.jpm.otm.entity.Department;
import com.jpm.otm.entity.Employee;
import com.jpm.otm.util.JPAUtil;
/**
 * @author Smita
 *
 */
public class OTMClient {
	public static void main(String[] args) {
		// step 1: obtain entityManager object
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		//create the object to be persisted
		//--dept obj
		Department department = new Department();
		department.setDeptId(20L);
		department.setDeptName("IT");
		
		//-emp obj 1
		Employee e1 = new Employee();
		e1.setEmpId(101L);		e1.setEmpName("Zara"); e1.setEmpSal(99.99);
		//set the department of the employee
		e1.setDepartment(department);
		
		//-emp obj 2
		Employee e2 = new Employee();
		e2.setEmpId(102L);		e2.setEmpName("Tara"); e2.setEmpSal(88.88);
		//set the department of the employee
		e2.setDepartment(department);
		
		//create the set of employees and set to the department
		Set<Employee> employees = new HashSet<>();
		//adding the employee obj to the HashSet
		employees.add(e1);employees.add(e2);
		
		//set the employees set in Department object
		department.setEmployees(employees);
		
		//begin transaction
		entityManager.getTransaction().begin();
		
		//persist the department object
		entityManager.persist(department);
		
		//commit transaction
		entityManager.getTransaction().commit();
		
		//close em
		entityManager.close();
	}

}





