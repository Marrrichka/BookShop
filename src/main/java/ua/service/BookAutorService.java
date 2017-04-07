package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BasicFilter;
import ua.entity.BookAutor;


public interface BookAutorService {
	List<BookAutor> findAll();

	void delete(int id);

	void save(BookAutor form);

	BookAutor findOne(int id);
	
	BookAutor findOne(String name);

	Page<BookAutor> findAll(BasicFilter filter, Pageable pageable);


}
