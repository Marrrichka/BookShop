package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="booktpc")
public class BookTopicPidCat  extends AbstractEntity{
	@Column(name="booktpc")
	private String booktpc;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	private BookTopic topic;
	
	@OneToMany(mappedBy="booktpc") 
	private List<Book> books = new ArrayList<>();
	public String getBooktpc() {
		return booktpc;
	}

	public void setBooktpc(String booktpc) {
		this.booktpc = booktpc;
	}

	public BookTopic getTopic() {
		return topic;
	}

	public void setTopic(BookTopic topic) {
		this.topic = topic;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public BookTopicPidCat() {
		super();
	}

	@Override
	public String toString() {
		return booktpc;
	}
	

}
