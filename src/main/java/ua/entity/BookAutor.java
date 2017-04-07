package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="autor")
public class BookAutor extends AbstractEntity{
	private String autor;
	@ManyToMany(mappedBy="bookautors")
	private List<Book> books= new ArrayList<>();
	public BookAutor() {
		super();
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	

}
