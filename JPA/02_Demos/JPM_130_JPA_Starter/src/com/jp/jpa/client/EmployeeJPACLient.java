package com.jp.jpa.client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jp.jpa.entity.Employee;

public class EmployeeJPACLient {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/*System.out.println("Enter EmployeeId");
		int empId=scanner .nextInt();*/
		System.out.println("Enter Employee Name:");
		String empName=scanner.next();
		System.out.println("Enter Employee Salary:");
		double empSal=scanner.nextDouble();

		String persistenceUnitName="JPA-PU"; // persistence unit name defined in persistence.xml file
		// step 1: Create EntityManagerFactory object
		EntityManagerFactory emFactory=  Persistence.createEntityManagerFactory(persistenceUnitName);
		// step 2: Create EntityManager object
		EntityManager em = emFactory.createEntityManager();
		// step 3: Begin Transaction
		em.getTransaction().begin();
		// step 4: create the entity object and persist entity
		Employee employee = new Employee(empName,empSal);
		em.persist(employee); // persisting the employee into DN;
		// step 5: commit transaction
		em.getTransaction().commit();
		
		//fetch the record from DB with the help of primary key
		Employee e1=em.find(Employee.class, employee.getEmployeeId());
		System.out.println("Employee : "+e1);
		// step 6:close EntityManager
	em.close();
		// step 7:close EntityManagerFactory
		emFactory.close();
	}

}
