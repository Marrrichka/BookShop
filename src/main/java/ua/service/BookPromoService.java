package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BasicFilter;
import ua.entity.BookPromo;


public interface BookPromoService {
	List<BookPromo> findAll();

	void delete(int id);

	void save(BookPromo form);

	BookPromo findOne(int id);
	
	BookPromo findOne(String name);

	Page<BookPromo> findAll(BasicFilter filter, Pageable pageable);

	

	
}
