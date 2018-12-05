
package com.lnt.hibernate.client;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lnt.hibernate.model.Employee;
import com.lnt.hibernate.util.HibernateUtil;

public class HQLMain {

	public static void main(String[] args) {
	
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		Query query = null;
		List<Employee> empList = null;
		try {
			sessionFactory=HibernateUtil.getSessionFactory();
			session=sessionFactory.getCurrentSession();
			// HQL example - Get All Employees
			session = sessionFactory.openSession();
			
			tx = session.beginTransaction();
			query = session.createQuery("from EmployeeHQL");
			empList = query.list();
			for (Employee emp : empList) {
				System.out.println("List of Employees::" + emp.getId()+ "," + emp.getAddress().getCity());
			}
			tx.commit();


			/*// HQL example - Get Employee with id
			query = session.createQuery("from Employee where id= :id");
			query.setLong("id", 3);
			Employee emp = (Employee) query.uniqueResult();
			System.out.println("Employee Name=" + emp.getName() + ", City=" + emp.getAddress().getCity());

			// HQL pagination example
			query = session.createQuery("from Employee");
			query.setFirstResult(0); // starts with 0
			query.setFetchSize(2);
			empList = query.list();
			for (Employee emp4 : empList) {
				System.out.println("Paginated Employees::" + emp4.getId() + "," + emp4.getAddress().getCity());
			}

			// HQL Update Employee
			query = session.createQuery("update Employee set name= :name where id= :id");
			query.setParameter("name", "Smita Kumar");
			query.setLong("id", 1);
			int result = query.executeUpdate();
			System.out.println("Employee Update Status=" + result);

			// HQL Delete Employee, we need to take care of foreign key constraints too
			query = session.createQuery("delete from Address where id= :id");
			query.setLong("id", 4);
			result = query.executeUpdate();
			System.out.println("Address Delete Status=" + result);

			query = session.createQuery("delete from Employee where id= :id");
			query.setLong("id", 4);
			result = query.executeUpdate();
			System.out.println("Employee Delete Status=" + result);

			// HQL Aggregate function examples
			query = session.createQuery("select sum(salary) from Employee");
			double sumSalary = (Double) query.uniqueResult();
			System.out.println("Sum of all Salaries= " + sumSalary);

			// HQL join examples
			query = session.createQuery("select e.name, a.city from Employee e " + "INNER JOIN e.address a");
			List<Object[]> list = query.list();
			for (Object[] arr : list) {
				System.out.println(Arrays.toString(arr));
			}

			// HQL group by and like example
			query = session.createQuery("select e.name, sum(e.salary), count(e)"
					+ " from Employee e where e.name like '%i%' group by e.name");
			List<Object[]> groupList = query.list();
			for (Object[] arr : groupList) {
				System.out.println(Arrays.toString(arr));
			}

			// HQL order by example
			query = session.createQuery("from Employee e order by e.id desc");
			empList = query.list();
			for (Employee emp3 : empList) {
				System.out.println("ID Desc Order Employee::" + emp3.getId() + "," + emp3.getAddress().getCity());
			} // data
*/		} catch (Exception e) {
			System.out.println("Exception occured. " + e);
		} finally {
			if (session.isOpen()) {
				System.out.println("Closing session");
				session.close();
			}
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}

}
