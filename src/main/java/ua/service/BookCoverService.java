package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BasicFilter;
import ua.entity.BookCover;

public interface BookCoverService {
	
	List<BookCover> findAll();

	void delete(int id);

	void save(BookCover form);

	BookCover findOne(int id);
	
	BookCover findOne(String name);

	Page<BookCover> findAll(BasicFilter filter, Pageable pageable);
	
}
