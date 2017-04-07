package ua.entity;
import java.util.ArrayList;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="adition")
public class BookAdition extends AbstractEntity{
	
	@Column(name="adition")
	private String adition;
	

	@OneToMany(mappedBy="bookcover")
	private List<Book> books = new ArrayList<>();


	public BookAdition() {
		super();
	}


	public String getAdition() {
		return adition;
	}


	public void setAdition(String adition) {
		this.adition = adition;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
	


}
