package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import filter.BasicFilter;
import ua.entity.BookTopic;

public class BookTopicSpecification implements Specification<BookTopic>{
	private final BasicFilter filter;

	public BookTopicSpecification(BasicFilter filter) {
		super();
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<BookTopic> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(filter.getSearch().isEmpty()) return null;
		return cb.like(root.get("topic"), filter.getSearch()+"%");
	}
	
	

}
