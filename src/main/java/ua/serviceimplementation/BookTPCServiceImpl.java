package ua.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import filter.BookTPCFilter;
import ua.entity.BookTopicPidCat;
import ua.repository.BookTPCRepository;
import ua.service.BookTPCService;
import ua.specification.BookTPCSpecification;

@Service
public class BookTPCServiceImpl implements BookTPCService{
 @Autowired
 private BookTPCRepository btpcrepository;
	@Override
	public List<BookTopicPidCat> findAll() {
		return btpcrepository.findAll();
	}

	@Override
	public void delete(int id) {
		btpcrepository.delete(id);
		
	}

	@Override
	public void save(BookTopicPidCat form) {
		btpcrepository.save(form);
		
	}

	@Override
	public BookTopicPidCat findOne(int id) {
		return btpcrepository.findOne(id);
	}

	@Override
	public BookTopicPidCat findOne(String name) {
		return btpcrepository.findByBooktpc(name);
	}

	@Override
	public Page<BookTopicPidCat> findAll(BookTPCFilter filter, Pageable pageable) {
		Page<BookTopicPidCat> btpc = btpcrepository.findAll(new BookTPCSpecification(filter), pageable);
		return btpc;
	}

	@Override
	public List<BookTopicPidCat> findAllBtpc(Integer id) {
		return btpcrepository.findAllBtpc(id);
	}

}
