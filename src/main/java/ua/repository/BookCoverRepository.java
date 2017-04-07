package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.BookCover;


public interface BookCoverRepository extends JpaRepository<BookCover, Integer>, JpaSpecificationExecutor<BookCover>{

	List<BookCover> findAll();
	BookCover findByCover(String name);
	
}
