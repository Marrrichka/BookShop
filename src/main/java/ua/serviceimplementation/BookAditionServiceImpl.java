package ua.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import filter.BasicFilter;
import ua.entity.BookAdition;
import ua.repository.BookAditionRepository;
import ua.service.BookAditionService;
import ua.specification.BookAditionSpecification;

@Service
public class BookAditionServiceImpl  implements BookAditionService {

	@Autowired
	private BookAditionRepository bookaditionRepository;
	@Override
	public List<BookAdition> findAll() {
		return bookaditionRepository.findAll();
	}

	@Override
	public void delete(int id) {
		bookaditionRepository.delete(id);
		
	}

	@Override
	public void save(BookAdition form) {
		bookaditionRepository.save(form);
		
	}

	@Override
	public BookAdition findOne(int id) {
		return bookaditionRepository.findOne(id);
	}

	@Override
	public BookAdition findOne(String name) {
		return bookaditionRepository.findByAdition(name);
	}

	@Override
	public Page<BookAdition> findAll(BasicFilter filter, Pageable pageable) {
		return bookaditionRepository.findAll(new BookAditionSpecification(filter), pageable);
	}

	

}
