package com.jpm.lifecycle.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpm.lifecycle.entities.Greet;
import com.jpm.lifecycle.entities.Student;
import com.jpm.lifecycle.util.JPAUtil;

/**
 * @author Smita
 *
 */
public class ClientObjectLifeCycle {
	public static void main(String[] args) {
		
		// step 2 : Obtain EntityManager object
		EntityManager em = JPAUtil.getEntityManager();
		//step 3 : begin Transaction
		em.getTransaction().begin();
		//step 4 : create the bean object and persist it on the DB
		Greet greet =null;//NULL state
		
		
		greet = new Greet();//Transient/New
		//greet.setMessageId(1001);//throw an exception
		greet.setMessage("Welcome to JPA Session!");
		//step 5: persist bean object in DB
		em.persist(greet);//Managed state
		System.out.println(
		"Adding Greet object on to the DB with unique message id "
		+greet.getMessageId());
		//step 6 : commit the tx
		greet.setMessage("OBject Life Cycle....");
//Object is in Managed stated so the changed message will be reflected in DB
		em.getTransaction().commit();//Detached State - greet
		//delete operation will remove the object
		//step 7: close em and em factory
		greet.setMessage("Hello....");
		greet.setMessageId(101);
//Object is in Detached stated so the changed message will NOT be reflected in DB
		em.close();//Detached State
		System.out.println("Updated Greet object on to the DB with unique message id "
		+em.find(Greet.class, greet.getMessageId()));
	}

}
/*
em.getTransaction().commit();//Detached State - greet

em.getTransaction().begin();
Student student = new Student();//Transient State - student
student.setName("Zara");		
em.persist(student);//Managed State - student
em.getTransaction().commit();

System.out.println("Added one student to database.");
*/
/*CREATE TABLE student_master
(student_id NUMBER(6) PRIMARY KEY,
student_name VARCHAR2(25));
CREATE SEQUENCE student_seq;*/