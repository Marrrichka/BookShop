package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="cover")
public class BookCover extends AbstractEntity{
	@Column(name="cover")
	private String cover;
	@OneToMany(mappedBy="bookcover")
	private List<Book> books = new ArrayList<>();
	
	

	public BookCover() {
		super();
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	
	

}
