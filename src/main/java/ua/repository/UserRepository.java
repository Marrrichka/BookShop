package ua.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import ua.entity.User;


public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User>{
	@Query("SELECT u FROM User u WHERE u.username=:username")
	User findByUsername(@Param("username")String username);
	@Query("SELECT u FROM User u WHERE u.email=:email")
	User findByEmail(@Param("email")String email);
	@Query(value="SELECT i FROM User i LEFT JOIN FETCH i.books u WHERE i.username=:username")
	User showbucket(@Param("username")String username);
	@Query("SELECT u FROM User u WHERE u.id=:id")
	User findOne(@Param("id")int id);
	@Query(value="SELECT i FROM User i LEFT JOIN FETCH i.books u WHERE u.id=:id")
	User deletebuy(@Param("id")int id);
	
}
