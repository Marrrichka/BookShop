package ua.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import filter.BasicFilter;
import ua.entity.BookAutor;

public class BookAutorSpecification implements Specification<BookAutor> {
 private final BasicFilter filter;

public BookAutorSpecification(BasicFilter filter) {
	super();
	this.filter = filter;
}

@Override
public Predicate toPredicate(Root<BookAutor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
	if(filter.getSearch().isEmpty()) return null;
	return cb.like(root.get("autor"), filter.getSearch()+"%");
}
 
 
}
