package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BasicFilter;
import ua.entity.BookAdition;


public interface BookAditionService {
	List<BookAdition> findAll();

	void delete(int id);

	void save(BookAdition form);

	BookAdition findOne(int id);
	
	BookAdition findOne(String name);

	Page<BookAdition> findAll(BasicFilter filter, Pageable pageable);
	

}
