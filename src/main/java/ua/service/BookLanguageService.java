package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BasicFilter;
import ua.entity.BookLanguage;


public interface BookLanguageService {
	List<BookLanguage> findAll();

	void delete(int id);

	void save(BookLanguage form);

	BookLanguage findOne(int id);
	
	BookLanguage findOne(String name);

	Page<BookLanguage> findAll(BasicFilter filter, Pageable pageable);
	
}
