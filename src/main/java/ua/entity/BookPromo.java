package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="promo")
public class BookPromo extends AbstractEntity{
	
	@Column(name="promo")
	private String promo;
	

	@OneToMany(mappedBy="bookpromo")
	private List<Book> books = new ArrayList<>();


	public BookPromo() {
		super();
	}	

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return promo;
	}
	
	


}
