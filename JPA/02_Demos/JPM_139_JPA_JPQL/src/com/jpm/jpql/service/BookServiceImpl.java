package com.jpm.jpql.service;

import java.util.List;

import com.jpm.jpql.dao.BookDaoImpl;
import com.jpm.jpql.dao.IBookDao;
import com.jpm.jpql.entities.Book;

public class BookServiceImpl implements IBookService {
	//prep-work
	private IBookDao dao;
	public BookServiceImpl() {
		dao = new BookDaoImpl();
	}
	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}
	@Override
	public List<Book> getBookByTitle(String title) {
		return dao.getBookByTitle(title);
	}
	@Override
	public Long getBookCount() {
		return dao.getBookCount();
	}

	@Override
	public List<Book> getAuthorBooks(String author) {
		return dao.getAuthorBooks(author);
	}

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}
	
	@Override
	public List<Book> getBooksInPriceRange(double low, double high){
		return dao.getBooksInPriceRange(low, high);
	}
}
