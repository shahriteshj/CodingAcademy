/**
 * 
 */
package com.jpm.joins.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.jpm.joins.entities.Employee;
import com.jpm.joins.entities.Task;
import com.jpm.joins.util.JPAUtil;

/**
 * @author brije
 *
 */
public class JoinsClient {
	public static void main(String[] args) {
		try {
			persistEmployees();
			executeQuery();
		} finally {
			JPAUtil.close();
		}
	}



	public static void persistEmployees() {
		Task task1 = new Task("Coding", "Denise");
		Task task2 = new Task("Refactoring", "Rose");
		Task task3 = new Task("Designing", "Denise");
		Task task4 = new Task("Documentation", "Mike");

		Employee employee1 = Employee.create("Ria", task1, task3);
		Employee employee2 = Employee.create("Mysha", task2, task4);
		Employee employee3 = Employee.create("Tim", task3, task4);
		Employee employee4 = Employee.create("Justin");

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(employee1);
		em.persist(employee2);
		em.persist(employee3);
		em.persist(employee4);
		em.getTransaction().commit();
		em.close();
		System.out.println("-- Employee persisted --");
		System.out.println(employee1);
		System.out.println(employee2);
		System.out.println(employee3);
		System.out.println(employee4);
	}

	private static void executeQuery() {
		System.out.println("-- executing query --");
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("SELECT DISTINCT e FROM Employee e INNER JOIN e.tasks t");
		List<Employee> resultList = query.getResultList();
		resultList.forEach(System.out::println);
		em.close();
	}
}
