package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BookFilter;
import filter.GlobalFilter;
import filter.UserFilter;
import form.BookForm;
import ua.entity.Book;

public interface BookService {
	BookForm findOne(int id);
	List<Book>findAll();
	void save(BookForm form);
	void delete(int id);
	Page <Book>findAll(BookFilter filter, Pageable pageable);
	List<Book> findByPromo(String promo);
	Book findById(int id);
	List<Book> findByTopic(String topic);
	List<Book> findcategory(String topic);
	List<Book> findcategoryId(int id);
	Page <Book>findAll(UserFilter filter, Pageable pageable);
	Page <Book>findAll(GlobalFilter globalfilter, Pageable pageable);
	Page <Book>findAllBTPC(UserFilter filter, Pageable pageable);
	Page <Book>findAllPromo(UserFilter filter, Pageable pageable);
}

