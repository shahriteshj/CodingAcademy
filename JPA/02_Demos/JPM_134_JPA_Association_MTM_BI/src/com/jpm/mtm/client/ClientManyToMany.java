package com.jpm.mtm.client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import com.jpm.mtm.entities.Order;
import com.jpm.mtm.entities.Product;
import com.jpm.mtm.util.JPAUtil;

public class ClientManyToMany {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();

		// first define few products before we place order

		Product elecProduct = new Product();
		elecProduct.setProductId(101L);
		elecProduct.setProductName("LED TV");
		elecProduct.setProductPrice(45000.88);

		Product beautyProduct = new Product();
		beautyProduct.setProductId(102L);
		beautyProduct.setProductName("Face Wash");
		beautyProduct.setProductPrice(80.88);

		Product babyProduct = new Product();
		babyProduct.setProductId(103L);
		babyProduct.setProductName("Pampers");
		babyProduct.setProductPrice(15.75);

		Product eleProduct = new Product();
		eleProduct.setProductId(104L);
		eleProduct.setProductName("CFL Bulb");
		eleProduct.setProductPrice(250.55);


// now create a HashSet of Product and add it into set
		Set<Product> products = new HashSet<>();
		products.add(elecProduct);
		products.add(beautyProduct);
		products.add(babyProduct);
		products.add(eleProduct);
// now define first order and add few products in it
		Order firstOrder = new Order();
		firstOrder.setOrderId(1L);
		firstOrder.setPurchaseDate(new Date());	

// now define second order and add few products in it
		Order secondOrder = new Order();
		secondOrder.setOrderId(2L);
		secondOrder.setPurchaseDate(new Date());
		
// now create a HashSet of Order and add it into set
		Set<Order> orders = new HashSet<>();
		orders.add(firstOrder);
		orders.add(secondOrder);
		
//now set the product Orders
		elecProduct.setOrders(orders);
		beautyProduct.setOrders(orders);
		babyProduct.setOrders(orders);
		elecProduct.setOrders(orders);
				
// now add product hashSet to the Order	
		firstOrder.setProducts(products);				

// now add product hashSet to the Order		
		secondOrder.setProducts(products);
				
// save orders using entity manager

		em.persist(firstOrder);
		em.persist(secondOrder);
		
		System.out.println("Added orders along with order details to database.");

		em.getTransaction().commit();
		em.close();
	}
}
