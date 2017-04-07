package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.BookLanguage;

public interface BookLanguageRepository extends JpaRepository<BookLanguage, Integer>, JpaSpecificationExecutor<BookLanguage>{

	List<BookLanguage> findAll();
	BookLanguage findByLanguage(String name);
	
}
