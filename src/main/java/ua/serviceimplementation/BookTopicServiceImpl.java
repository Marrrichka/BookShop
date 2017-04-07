package ua.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import filter.BasicFilter;
import ua.entity.BookTopic;
import ua.repository.BookTopicRepository;
import ua.service.BookTopicService;
import ua.specification.BookTopicSpecification;
@Service
public class BookTopicServiceImpl implements BookTopicService {

	@Autowired
	private BookTopicRepository booktopicRepository;
	@Override
	public List<BookTopic> findAll() {
		return booktopicRepository.findAll();
	}

	@Override
	public void delete(int id) {
		booktopicRepository.delete(id);
	}

	@Override
	public void save(BookTopic form) {
		booktopicRepository.save(form);
	}

	@Override
	public BookTopic findOne(int id) {
		return booktopicRepository.findOne(id);
	}

	@Override
	public BookTopic findOne(String name) {
		return booktopicRepository.findByTopic(name);
	}

	@Override
	public Page<BookTopic> findAll(BasicFilter filter, Pageable pageable) {
		return booktopicRepository.findAll(new BookTopicSpecification(filter), pageable);
	}

	
}
	