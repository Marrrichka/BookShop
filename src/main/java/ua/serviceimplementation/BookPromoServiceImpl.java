package ua.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import filter.BasicFilter;
import ua.entity.BookPromo;
import ua.repository.BookPromoRepository;
import ua.service.BookPromoService;
import ua.specification.BookPromoSpecification;
@Service
public class BookPromoServiceImpl implements BookPromoService{
	@Autowired
	private BookPromoRepository bookpromoRepository;

	@Override
	public List<BookPromo> findAll() {
		return bookpromoRepository.findAll();
	}

	@Override
	public void delete(int id) {
		bookpromoRepository.delete(id);
		
	}

	@Override
	public void save(BookPromo form) {
		bookpromoRepository.save(form);
		
	}

	@Override
	public BookPromo findOne(int id) {
		return bookpromoRepository.findOne(id);
	}

	@Override
	public BookPromo findOne(String name) {
		return bookpromoRepository.findByPromo(name);
	}

	@Override
	public Page<BookPromo> findAll(BasicFilter filter, Pageable pageable) {
		return bookpromoRepository.findAll(new BookPromoSpecification(filter), pageable);
	}


}
