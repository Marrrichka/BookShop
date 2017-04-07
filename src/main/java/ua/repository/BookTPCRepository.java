package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.BookTopicPidCat;

public interface BookTPCRepository extends JpaRepository<BookTopicPidCat, Integer>, JpaSpecificationExecutor<BookTopicPidCat> {


	BookTopicPidCat findByBooktpc(String name);

	@Query("SELECT a FROM BookTopicPidCat a LEFT JOIN FETCH a.topic")
	List<BookTopicPidCat> findAll();
	
	@Query("SELECT a FROM BookTopicPidCat a LEFT JOIN FETCH a.topic WHERE a.id = ?1")
	BookTopicPidCat findOne(Integer id);
	@Transactional
	@Modifying
	@Query("UPDATE Book i SET i.booktpc='1' WHERE i.booktpc.id=:id")
	void removDependencies(@Param("id")int id);
	@Query("SELECT a FROM BookTopicPidCat a LEFT JOIN FETCH a.topic t WHERE t.id =?1")
	List<BookTopicPidCat> findAllBtpc(Integer id);
}
	

