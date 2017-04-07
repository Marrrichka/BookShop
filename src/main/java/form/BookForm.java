package form;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.BookAdition;
import ua.entity.BookAutor;
import ua.entity.BookCover;
import ua.entity.BookLanguage;
import ua.entity.BookPromo;
import ua.entity.BookTopic;
import ua.entity.BookTopicPidCat;

public class BookForm {
	private int id;
	private String bookname;
	private BookAdition bookadition;
	private BookCover bookcover;
	private BookLanguage booklanguage;
	private BookPromo bookpromo;
	private BookTopic booktopic;
	private String bookPrice;
	private String bookYear;
	private String bookPages;
	private BookTopicPidCat booktpc;
	private List<BookAutor> bookautors = new ArrayList<>();
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public BookTopic getBooktopic() {
		return booktopic;
	}
	public void setBooktopic(BookTopic booktopic) {
		this.booktopic = booktopic;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookYear() {
		return bookYear;
	}
	public void setBookYear(String bookYear) {
		this.bookYear = bookYear;
	}
	public String getBookPages() {
		return bookPages;
	}
	public void setBookPages(String bookPages) {
		this.bookPages = bookPages;
	}
	public BookTopicPidCat getBooktpc() {
		return booktpc;
	}
	public void setBooktpc(BookTopicPidCat booktpc) {
		this.booktpc = booktpc;
	}
	public List<BookAutor> getBookautors() {
		return bookautors;
	}
	public void setBookautors(List<BookAutor> bookautors) {
		this.bookautors = bookautors;
	}

	
	
	

}
