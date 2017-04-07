package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import filter.BookTPCFilter;
import ua.entity.BookTopicPidCat;


public interface BookTPCService {
	List<BookTopicPidCat> findAll();

	void delete(int id);

	void save(BookTopicPidCat form);

	BookTopicPidCat findOne(int id);
	
	BookTopicPidCat findOne(String name);

	Page<BookTopicPidCat> findAll(BookTPCFilter filter, Pageable pageable);
	
	List<BookTopicPidCat> findAllBtpc(Integer id);

}
