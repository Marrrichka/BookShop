package ua.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import filter.BasicFilter;
import ua.entity.BookLanguage;
import ua.repository.BookLanguageRepository;
import ua.service.BookLanguageService;
import ua.specification.BookLanguageSpecification;
@Service
public class BookLanguageServiceImpl implements BookLanguageService{

	@Autowired
	private BookLanguageRepository booklanguageRepository;

	@Override
	public List<BookLanguage> findAll() {
		return booklanguageRepository.findAll();
	}

	@Override
	public void delete(int id) {
		booklanguageRepository.delete(id);
		
	}

	@Override
	public void save(BookLanguage form) {
		booklanguageRepository.save(form);
		
	}

	@Override
	public BookLanguage findOne(int id) {
		return booklanguageRepository.findOne(id);
	}

	@Override
	public BookLanguage findOne(String name) {
		return booklanguageRepository.findByLanguage(name);
	}

	@Override
	public Page<BookLanguage> findAll(BasicFilter filter, Pageable pageable){
		return booklanguageRepository.findAll(new BookLanguageSpecification(filter), pageable);
	}


}