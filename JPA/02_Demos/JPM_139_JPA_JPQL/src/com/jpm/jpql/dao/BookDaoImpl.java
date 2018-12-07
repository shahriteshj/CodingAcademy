package com.jpm.jpql.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jpm.jpql.entities.Book;
import com.jpm.jpql.util.JPAUtil;
public class BookDaoImpl implements IBookDao {
	
	//prep-work
	private EntityManager entityManager;
	private Logger logger;
	public BookDaoImpl() {//create entity object
		entityManager = JPAUtil.getEntityManager();
		logger = LoggerFactory.getLogger(BookDaoImpl.class);
	}
	@Override
	public Book getBookById(int id) {
		Book book = entityManager.find(Book.class, id);
		logger.info("Invoked getBookById at BookDaoImpl and book found is : ", book);
		return book;
	}	
	@Override
	public List<Book> getBookByTitle(String title) {
	//select * from books where title like %?%"
		String qStr = 
	"SELECT b1 FROM Book b1 WHERE b1.title LIKE :ptitle";
	TypedQuery<Book> query = 
			entityManager.createQuery(qStr, Book.class);
		query.setParameter("ptitle", "%"+title+"%");
		return query.getResultList();
	}
	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(b1.id) FROM Book b1";
		TypedQuery<Long> query = 
				entityManager.createQuery(qStr,Long.class);
		Long count = query.getSingleResult();
		return count;
	}	
	@Override
	public List<Book> getAuthorBooks(String author) {
		String qStr = 
	"SELECT b1 FROM Book b1 WHERE b1.author=:pAuthor";//pAuthor 
		TypedQuery<Book> query = 
				entityManager.createQuery(qStr, Book.class);
		query.setParameter("pAuthor", author);
		List<Book> bookList = query.getResultList();
		return bookList;
	}	
	@Override
	public List<Book> getAllBooks() {
		Query query = entityManager
				.createNamedQuery("getAllBooks");
		@SuppressWarnings("unchecked")
		List<Book> bookList = query.getResultList();
		return bookList;
	}	
	@Override
	public List<Book> getBooksInPriceRange(double low,double high) {
		String qStr = 
"SELECT b1 FROM Book b1 WHERE b1.price between :low and :high";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		List<Book> bookList = query.getResultList();
		return bookList;
	}

}
