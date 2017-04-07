package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.BookAdition;



public interface BookAditionRepository extends JpaRepository<BookAdition, Integer>, JpaSpecificationExecutor<BookAdition>{

	List<BookAdition> findAll();
	BookAdition findByAdition(String name);
	
}
