package ua.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import filter.BasicFilter;
import ua.entity.BookAutor;
import ua.repository.BookAutorRepository;
import ua.service.BookAutorService;
import ua.specification.BookAutorSpecification;

@Service
public class BookAutorServiceImpl implements BookAutorService{
	
	@Autowired
	private BookAutorRepository bookautorRepository;

	@Override
	public List<BookAutor> findAll() {
		return bookautorRepository.findAll();
	}

	@Override
	public void delete(int id) {
	bookautorRepository.delete(id);
		
	}

	@Override
	public void save(BookAutor form) {
		bookautorRepository.save(form);
		
	}

	@Override
	public BookAutor findOne(int id) {
		return bookautorRepository.findOne(id);
	}

	@Override
	public BookAutor findOne(String name) {
		return bookautorRepository.findByAutor(name);
	}

	@Override
	public Page<BookAutor> findAll(BasicFilter filter, Pageable pageable) {
		return bookautorRepository.findAll(new BookAutorSpecification(filter), pageable);
	}



}
