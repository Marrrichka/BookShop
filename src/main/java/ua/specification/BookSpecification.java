package ua.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import ua.entity.BookAutor;
import filter.BookFilter;
import ua.entity.Book;

public class BookSpecification implements Specification<Book> {
	private final BookFilter filter;
	public final List<Predicate> predicates= new ArrayList<>();
	

	public BookSpecification(BookFilter filter) {
		super();
		this.filter = filter;
	}
	
	private void filterByAdition(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getBaddIds().isEmpty()){
			predicates.add(root.get("bookadition").in(filter.getBaddIds()));
		}
	}
	private void filterByCover(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getBcIds().isEmpty()){
			predicates.add(root.get("bookcover").in(filter.getBcIds()));
		}
	}

	private void filterByLanguage(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getBlIds().isEmpty()){
			predicates.add(root.get("booklanguage").in(filter.getBlIds()));
		}
	}
	private void filterByPromo(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getBpIds().isEmpty()){
			predicates.add(root.get("bookpromo").in(filter.getBpIds()));
		}
	}

	private void filterByTPC(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getBtpcIds().isEmpty()){
			predicates.add(root.get("booktpc").in(filter.getBtpcIds()));
		}
	}
	
	private void filterByPrice(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxPr()!=null&&filter.getMinPr()!=null){
			predicates.add(cb.between(root.get("bookPrice"), filter.getMinPr(), filter.getMaxPr()));
		}else if(filter.getMaxPr()!=null){
			predicates.add(cb.lessThanOrEqualTo(root.get("bookPrice"), filter.getMaxPr()));
		}else if(filter.getMinPr()!=null){
			predicates.add(cb.greaterThanOrEqualTo(root.get("bookPrice"), filter.getMinPr()));
		}
	}
	private void filterByPages(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxPa()!=null&&filter.getMinPages()!=null){
			predicates.add(cb.between(root.get("bookPages"), filter.getMinPa(), filter.getMaxPa()));
		}else if(filter.getMaxPa()!=null){
			predicates.add(cb.lessThanOrEqualTo(root.get("bookPages"), filter.getMaxPa()));
		}else if(filter.getMinPa()!=null){
			predicates.add(cb.greaterThanOrEqualTo(root.get("bookPages"), filter.getMinPa()));
		}
	}
	private void filterByYear(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxY()!=null&&filter.getMinY()!=null){
			predicates.add(cb.between(root.get("bookYear"), filter.getMinY(), filter.getMaxY()));
		}else if(filter.getMaxY()!=null){
			predicates.add(cb.lessThanOrEqualTo(root.get("bookYear"), filter.getMaxY()));
		}else if(filter.getMinY()!=null){
			predicates.add(cb.greaterThanOrEqualTo(root.get("bookYear"), filter.getMinY()));
		}
	}
	private void filterBySearchName(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearchName().isEmpty()){
			predicates.add(cb.like(root.get("bookname"), filter.getSearchName()+"%"));
		}
	}
	private void filterBySearchAutor(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearchAutor().isEmpty()){
			Join<Book, BookAutor> ba = root.join("bookautors");
		predicates.add(cb.like(ba.get("autor"), filter.getSearchAutor()+"%"));
		}
	}
	private void fetch(Root<Book> root, CriteriaQuery<?> query){
		if(query.getResultType()!=Long.class){
			root.fetch("bookadition", JoinType.LEFT);
			root.fetch("bookcover", JoinType.LEFT);
			root.fetch("bookautors", JoinType.LEFT);
			root.fetch("booklanguage", JoinType.LEFT);
			root.fetch("bookpromo", JoinType.LEFT);
			root.fetch("booktpc", JoinType.LEFT);
		}
			
	}
	
	@Override
	public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		query.distinct(true);
		filterByAdition(root, query, cb);
		filterByCover(root, query, cb);
		filterByLanguage(root, query, cb);
		filterByPages(root, query, cb);
		filterByPrice(root, query, cb);
		filterByPromo(root, query, cb);
		filterBySearchAutor(root, query, cb);
		filterBySearchName(root, query, cb);
		filterByTPC(root, query, cb);
		filterByYear(root, query, cb);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	}

}
