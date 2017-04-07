package form;

import java.util.ArrayList;
import java.util.List;



import ua.entity.Book;
import ua.entity.Role;

public class UserForm {
	
	private int id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private String card;
	
	private String number;
	
	private Role role;

	private List<Book> books = new ArrayList<>();
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	

}
