package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.BookAutor;

public interface BookAutorRepository extends JpaRepository<BookAutor, Integer>, JpaSpecificationExecutor<BookAutor>{
	BookAutor findByAutor(String name);

	List<BookAutor> findAll();


}
