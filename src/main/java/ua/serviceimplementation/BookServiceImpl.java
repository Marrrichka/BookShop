package ua.serviceimplementation;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import filter.BookFilter;
import filter.GlobalFilter;
import filter.UserFilter;
import form.BookForm;
import ua.repository.BookRepository;
import ua.service.BookService;
import ua.service.FileWriter;
import ua.service.FileWriter.Folder;
import ua.specification.BookSpecification;
import ua.specification.GlobalSpecification;
import ua.specification.PromoSpecification;
import ua.specification.SubTopicSpecification;
import ua.specification.UserSpecification;
import ua.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookrepository;
	@Autowired
	private FileWriter fileWriter;

	@Override
	@Transactional
	public BookForm findOne(int id) {
		
		Book b= (Book) bookrepository.findOne(id); 
		BookForm form = new BookForm(); 

		form.setBookadition(b.getBookadition()); 
		 form.setBookautors(b.getBookautors()); 

		form.setBookcover(b.getBookcover()); 
		form.setBooklanguage(b.getBooklanguage()); 
		form.setBookpromo(b.getBookpromo()); 
		form.setBooktpc(b.getBooktpc());  
		form.setBookname(b.getBookname()); 		
		form.setBookPages(String.valueOf(b.getBookPages())); 
		form.setBookYear(String.valueOf(b.getBookYear())); 
		form.setBookPrice(String.valueOf(b.getBookPrice())); 
		form.setId(b.getId()); 
		return form; 
			}
	
	@Override
	@Transactional
	public void save(BookForm form) {
	
				Book b=new Book(); 
				b.setID(form.getId()); 
				b.setBookadition(form.getBookadition()); 
				b.setBookcover(form.getBookcover()); 
				b.setBooklanguage(form.getBooklanguage()); 
				b.setBookpromo(form.getBookpromo()); 
				b.setBooktpc(form.getBooktpc()); 
				b.setBookname(form.getBookname()); 
				
				b.setBookPages(Integer.valueOf(form.getBookPages())); 
				b.setBookYear(Integer.valueOf(form.getBookYear())); 
				b.setBookPrice(new BigDecimal(form.getBookPrice().replace(',','.'))); 
				b.setBookautors(form.getBookautors());			
				b=bookrepository.saveAndFlush(b);
			if(fileWriter.write(Folder.Bookname, form.getFile(), b.getId())){
				if(b.getVersion()==null)b.setVersion(0);
				else b.setVersion(b.getVersion()+1);
			}
			bookrepository.save(b); 
		
	}

	@Override
	public List<Book> findAll() {
		return bookrepository.findAll();
	}

	@Override
	public void delete(int id) {
		bookrepository.delete(id);
		
	}

	@Override
	public Page<Book> findAll(BookFilter filter, Pageable pageable) {
		Page<Book> b = bookrepository.findAll(new BookSpecification(filter), pageable);
		return b;
	}

	@Override
	public List<Book> findByPromo(String promo) {
		return bookrepository.findByPromo(promo);
	}

	@Override
	public Book findById(int id) {
		return bookrepository.findById(id);
	}

	@Override
	public List<Book> findByTopic(String topic) {
		return bookrepository.findByTopic(topic);
	}

	@Override
	public List<Book> findcategory(String topic) {
		return bookrepository.findcategory(topic);
	}

	@Override
	public List<Book> findcategoryId(int id) {
		return bookrepository.findcategoryId(id);
	
	}

	@Override
	@Transactional
	public Page<Book> findAll(UserFilter filter, Pageable pageable) {
		Page<Book> b = bookrepository.findAll(new UserSpecification(filter), pageable);
		return b;
	}

	@Override
	public Page<Book> findAll(GlobalFilter globalfilter, Pageable pageable) {
		Page<Book> b =bookrepository.findAll(new GlobalSpecification(globalfilter), pageable);
		return b;
	}

	@Override
	public Page<Book> findAllBTPC(UserFilter filter, Pageable pageable) {
		Page<Book> b = bookrepository.findAll(new SubTopicSpecification(filter), pageable);
		return b;
	}

	@Override
	public Page<Book> findAllPromo(UserFilter filter, Pageable pageable) {
		Page<Book> b = bookrepository.findAll(new PromoSpecification(filter), pageable);
		return b;
	}


	
}
