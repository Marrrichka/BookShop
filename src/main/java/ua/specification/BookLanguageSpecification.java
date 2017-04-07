package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import filter.BasicFilter;
import ua.entity.BookLanguage;

public class BookLanguageSpecification implements Specification<BookLanguage>{

	private final BasicFilter filter;

	public BookLanguageSpecification(BasicFilter filter) {
		super();
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<BookLanguage> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	if(filter.getSearch().isEmpty()) return null;
	return cb.like(root.get("language"), filter.getSearch()+"%");
	}
	
}
