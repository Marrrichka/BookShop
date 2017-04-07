package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.BookPromo;

public interface BookPromoRepository extends JpaRepository<BookPromo, Integer>, JpaSpecificationExecutor<BookPromo>{

	BookPromo findByPromo(String name);
	
	List<BookPromo> findAll();
	
}
