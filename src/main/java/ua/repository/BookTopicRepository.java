package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.BookTopic;



public interface BookTopicRepository extends JpaRepository<BookTopic, Integer>, JpaSpecificationExecutor<BookTopic>{
	BookTopic findByTopic(String name);
	
	List<BookTopic> findAll();
	

}
