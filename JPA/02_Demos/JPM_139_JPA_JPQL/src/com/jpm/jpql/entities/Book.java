package com.jpm.jpql.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
/**
 * 
 * @author Smita
 *
 */
@Entity
@Table(name = "books")
@NamedQueries({
		@NamedQuery(name = "getAllBooksId",query = "SELECT b1.id FROM Book b1"),
		@NamedQuery(name = "getAllBooks", query = "SELECT b1 FROM Book b1")
})
public class Book implements Serializable {
	private static final long serialVersionUID = -6697110923595996770L;
	@Id
	private Integer id;
	private String title;
	private String author;
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author
				+ ", price=" + price + "]";
	}

}
