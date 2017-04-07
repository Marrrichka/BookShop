package ua.service;

import java.security.Principal;
import java.util.List;

import form.UserForm;
import ua.entity.Book;
import ua.entity.User;

public interface UserService {
	void save(UserForm user);
	void buy(int id, Principal principal);
    User showbucket(Principal principal);
    User findByUsername(String username);
    User findByEmail(String email);

	void deletebuy(int id, Principal principal);
	
	List<Book> findByPromoId(int id);
		public void sendMail(String content, String email, String mailBody);
		
	User findOne(int id);
	
}
