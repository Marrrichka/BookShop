package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import ua.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book>{

	@Query("SELECT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage  LEFT JOIN FETCH b.bookpromo  "
			+ "LEFT JOIN FETCH b.booktpc")
	List<Book>findAll();
	
	@Query("SELECT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage  LEFT JOIN FETCH b.bookpromo  "
			+ "LEFT JOIN FETCH b.booktpc WHERE b.id=:id")
	Book findOne(@Param("id") int id);
	@Query(value="SELECT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage  LEFT JOIN FETCH b.bookpromo  "
			+ "LEFT JOIN FETCH b.booktpc", countQuery="SELECT count(b.id) FROM Book b")
	Page<Book> findAll(Pageable pageable);
	
	Book findByBookname(String name);
	
	
	@Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH  b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage LEFT JOIN FETCH b.booktpc LEFT JOIN FETCH b.bookpromo bp WHERE bp.promo=:bookpromo")
    List<Book> findByPromo(@Param("bookpromo")String promo);
	
	@Query("SELECT u FROM Book u WHERE u.id=:id")
	Book findById(@Param("id")int id);
	
	@Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH  b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage LEFT JOIN FETCH b.bookpromo LEFT JOIN FETCH b.booktpc bp WHERE bp.booktpc=:booktpc")
    List<Book> findByTopic(@Param("booktpc")String booktpc);
	
	@Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage LEFT JOIN FETCH b.bookpromo LEFT JOIN FETCH b.booktpc bp LEFT JOIN FETCH bp.topic n WHERE n.topic=:topic")
	List<Book> findcategory(@Param("topic")String topic);
	
	@Query("SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.bookadition LEFT JOIN FETCH b.bookautors  "
			+ "LEFT JOIN FETCH b.bookcover  LEFT JOIN FETCH b.booklanguage LEFT JOIN FETCH b.bookpromo LEFT JOIN FETCH b.booktpc bp LEFT JOIN FETCH bp.topic n WHERE n.id=?1")
	List<Book> findcategoryId(int id);
	@Query("SELECT i FROM Book i LEFT JOIN FETCH i.booklanguage LEFT JOIN FETCH i.bookpromo WHERE i.bookpromo.id= ?1")
	List<Book> findByPromoId(int id);
	
}
