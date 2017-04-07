package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book extends AbstractEntity{
	@Column(name="bookname")
	private String bookname;
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="adition")
	private BookAdition bookadition;
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="cover")
	private BookCover bookcover;
	
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="language")
	private BookLanguage booklanguage;
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="promo")
	private BookPromo bookpromo;

	
	@Column(name="price")
	private BigDecimal bookPrice;
	
	@Column(name="year")
	private int bookYear;
	
	@Column(name="pages")
	private int bookPages;
	
	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name="booktpc")
	private BookTopicPidCat booktpc;
	

	@ManyToMany
	private List<BookAutor> bookautors = new ArrayList<>();
	
	@ManyToMany(mappedBy="books")
	private List<User> users = new ArrayList<>();
	
	public Book() {
		super();
	}

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	@Column(name = "version", nullable = true)
	private Integer version;


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public String getBookname() {
		return bookname;
	}


	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public BookAdition getBookadition() {
		return bookadition;
	}


	public void setBookadition(BookAdition bookadition) {
		this.bookadition = bookadition;
	}


	public BookCover getBookcover() {
		return bookcover;
	}


	public void setBookcover(BookCover bookcover) {
		this.bookcover = bookcover;
	}


	public BookLanguage getBooklanguage() {
		return booklanguage;
	}


	public void setBooklanguage(BookLanguage booklanguage) {
		this.booklanguage = booklanguage;
	}


	public BookPromo getBookpromo() {
		return bookpromo;
	}


	public void setBookpromo(BookPromo bookpromo) {
		this.bookpromo = bookpromo;
	}


	public BigDecimal getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(BigDecimal bookPrice) {
		this.bookPrice = bookPrice;
	}


	public int getBookYear() {
		return bookYear;
	}


	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}


	public int getBookPages() {
		return bookPages;
	}


	public void setBookPages(int bookPages) {
		this.bookPages = bookPages;
	}


	public List<BookAutor> getBookautors() {
		return bookautors;
	}


	public void setBookautors(List<BookAutor> bookautors) {
		this.bookautors = bookautors;
	}


	

	public BookTopicPidCat getBooktpc() {
		return booktpc;
	}


	public void setBooktpc(BookTopicPidCat booktpc) {
		this.booktpc = booktpc;
	}
	

	
}
