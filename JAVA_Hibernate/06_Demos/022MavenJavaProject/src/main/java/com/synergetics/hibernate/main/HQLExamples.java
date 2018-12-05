package com.synergetics.hibernate.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.synergetics.hibernate.model.Employee;
import com.synergetics.hibernate.util.HibernateUtil;

public class HQLExamples {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		// Prep work
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			// Get All Employees
			tx = session.beginTransaction();
			Query query = session.createQuery("from Employee");
			List<Employee> empList = query.list();
			for (Employee emp : empList) {
				System.out.println("List of Employees::" + emp.getId() + "," + emp.getAddress().getCity());
			}

			// Get Employee with id
			query = session.createQuery("from Employee where id= :id");
			query.setLong("id", 3);
			Employee emp = (Employee) query.uniqueResult();
			System.out.println("Employee Name=" + emp.getName() + ", City=" + emp.getAddress().getCity());

			// Update Employee
			query = session.createQuery("update Employee set name= :name where id= :id");
			query.setParameter("name", "Smita");
			query.setLong("id", 1);
			int result = query.executeUpdate();
			System.out.println("Employee Update Status=" + result);

			// Delete Employee, we need to take care of foreign key constraints
			// too
			query = session.createQuery("delete from Address where id= :id");
			query.setLong("id", 4);
			result = query.executeUpdate();
			System.out.println("Address Delete Status=" + result);

			query = session.createQuery("delete from Employee where id= :id");
			query.setLong("id", 4);
			result = query.executeUpdate();
			System.out.println("Employee Delete Status=" + result);

			// Aggregate function examples
			query = session.createQuery("select sum(salary) from Employee");
			double sumSalary = (Double) query.uniqueResult();
			System.out.println("Sum of all Salaries= " + sumSalary);

			// join examples
			query = session.createQuery("select e.name, a.city from Employee e " + "INNER JOIN e.address a");
			List<Object[]> list = query.list();
			for (Object[] arr : list) {
				System.out.println(Arrays.toString(arr));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// rolling back to save the test data
			tx.rollback();

		} finally {

			System.out.println("closing hibernate resources");
			sessionFactory.close();
		}
	}

}
