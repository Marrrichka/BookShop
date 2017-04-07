package ua.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import filter.BasicFilter;
import ua.entity.BookCover;
import ua.repository.BookCoverRepository;
import ua.service.BookCoverService;
import ua.specification.BookCoverSpecification;
@Service
public class BookCoverServiceImpl implements BookCoverService  {

	@Autowired
	private BookCoverRepository bookcoverRepository;
	
	@Override
	public List<BookCover> findAll() {
		return bookcoverRepository.findAll();
	}

	@Override
	public void delete(int id) {
		bookcoverRepository.delete(id);
		
	}

	@Override
	public void save(BookCover form) {
		bookcoverRepository.save(form);
		
	}

	@Override
	public BookCover findOne(int id) {
		return bookcoverRepository.findOne(id);
	}

	@Override
	public BookCover findOne(String name) {
		return bookcoverRepository.findByCover(name);
	}

	@Override
	public Page<BookCover> findAll(BasicFilter filter, Pageable pageable) {
		return bookcoverRepository.findAll(new BookCoverSpecification(filter), pageable);
	}


}
