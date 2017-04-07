package ua.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;


import filter.BookTPCFilter;
import ua.entity.BookTopicPidCat;

public class BookTPCSpecification implements Specification<BookTopicPidCat>{
	private final BookTPCFilter filter;
	public final List<Predicate> predicates = new ArrayList<>();
	
	public BookTPCSpecification(BookTPCFilter filter) {
		super();
		this.filter = filter;
	}
	private void filterByTopic(Root<BookTopicPidCat> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getTopicIds().isEmpty()){
			predicates.add(root.get("topic").in(filter.getTopicIds()));
		}
	}

	private void filterBySearch(Root<BookTopicPidCat> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("booktpc"), filter.getSearch()+"%"));
		}
	}
	private void fetch(Root<BookTopicPidCat> root, CriteriaQuery<?> query){
		if(query.getResultType()!=Long.class){
			root.fetch("topic", JoinType.LEFT);
			
		}
	}
	@Override
	public Predicate toPredicate(Root<BookTopicPidCat> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root,query);
		query.distinct(true);
		filterBySearch(root, query, cb);
		filterByTopic(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate [] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	}

}
