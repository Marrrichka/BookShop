package ua.serviceimplementation;
import java.security.Principal;
import java.util.Iterator;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import form.UserForm;
import ua.entity.Book;
import ua.entity.Role;
import ua.entity.User;
import ua.repository.BookRepository;
import ua.repository.UserRepository;
import ua.service.BookService;
import ua.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService{
	protected static final String USERNAME = null;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BookRepository bookrepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private BookService bService;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public void save(UserForm form) {
		User u = new User();
		u.setId(form.getId());
		u.setUsername(form.getUsername());
		u.setPassword(encoder.encode(form.getPassword()));
		u.setEmail(form.getEmail());
		u.setNumber(Integer.valueOf(form.getNumber()));
		u.setRole(Role.ROLE_USER);
		userRepository.save(u);
	}
	
	@PostConstruct
	public void admin(){
		User user = userRepository.findByUsername("admin");
		if(user==null){
			user = new User();
			user.setEmail("");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			user.setUsername("admin");
			userRepository.save(user);
		}
	}

	@Override
	@Transactional
	public void buy(int id,Principal principal) {		
		User user=userRepository.findByUsername(principal.getName());
		Book b = bService.findById(id);
		user.getBooks().add(b);
		userRepository.save(user);
		
	}

	

	@Override
	public User showbucket(Principal principle) {
		if(principle!=null){
			String name = principle.getName();
			return userRepository.showbucket(name);
		}
		return new User();
	}

	@Override
	@Transactional
	public void deletebuy(int id, Principal principal){
		User user = userRepository.findByUsername(principal.getName());
		Book b = bService.findById(id);
		Iterator <Book> iter= user.getBooks().iterator();
		while(iter.hasNext()){
			if(iter.next().equals(b)){
				iter.remove();
				break;
			}
		}
	}

	@Override
	public java.util.List<Book> findByPromoId(int id) {
		return bookrepository.findByPromoId(id);
	}

	@Override
	public void sendMail(String content, String email, String mailBody) {
		Properties properties= System.getProperties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
		new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("login", "password");
		}
		});
		try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("marrrichka"));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(
		email));
		message.setSubject(content, "UTF-8");
		message.setText(mailBody);
		Transport.send(message);
		} catch (MessagingException å) {
		å.printStackTrace();
		}
		}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	
		
	}

	

