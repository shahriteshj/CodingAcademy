package com.jp.lifecycle.client;

import javax.persistence.EntityManager;

import com.jp.lifecycle.entities.Greet;
import com.jp.lifecycle.util.JPAUtil;

public class ClientObjectLifecycle {
	public static void main(String[] args) {
		
		//step 2 : Obtain EntityManagerObject
		EntityManager em =JPAUtil.getEntityManager();
		//Step 3 : begin transaction
		em.getTransaction().begin();
		//Step 4 : Create the bean object and persist it on the DB
		Greet greet = new Greet(); //Transient/New
		//greet.setMessageId(1001); //throw an exception
		greet.setMesssage("Welcome to JPA Session");
		//Step 5 : persist bean object in DB
		em.persist(greet); //Managed state
		System.out.println("Adding Greet object on to the DB with unique message id" 
		+greet.getMessageId());
		//step 6 : commit the tx
		greet.setMesssage("Object LifeCycle..");
		//Object is in Managed state so the changed message will be reflected in DB
		em.getTransaction().commit();//Detached State - greet
		//delete operation will remove the object
		//step 7 : close em and emfactory
		greet.setMesssage("Hello....");
		greet.setMessageId(101);
		//Object is in Detached stated so the changed message will NOT be reflected in the DB
		em.close(); //Detached State
		System.out.println("Updated Greet object on to the DB with unique message id"
		+em.find(Greet.class, greet.getMessageId()));
	}

}
/*
 * em.getTransaction() .commit; //Detached State - greet 
*/