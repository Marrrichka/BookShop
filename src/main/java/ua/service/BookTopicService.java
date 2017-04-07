package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BasicFilter;
import ua.entity.BookTopic;


public interface BookTopicService {
	List<BookTopic> findAll();

	void delete(int id);

	void save(BookTopic form);

	BookTopic findOne(int id);
	
	BookTopic findOne(String name);

	Page<BookTopic> findAll(BasicFilter filter, Pageable pageable);

	
	
}
