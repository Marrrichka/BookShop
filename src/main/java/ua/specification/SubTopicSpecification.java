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

import filter.UserFilter;
import ua.entity.Book;
import ua.entity.BookAdition;
import ua.entity.BookAutor;
import ua.entity.BookLanguage;
import ua.entity.BookTopicPidCat;

public class SubTopicSpecification implements Specification<Book> {
		private final UserFilter filter;
	
	
	public final List<Predicate> predicates= new ArrayList<>();


	public SubTopicSpecification(UserFilter filter) {
		super();
		this.filter = filter;
	}
	public void findAllTopic(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		Join<Book, BookTopicPidCat> bt=root.join("booktpc");
		predicates.add(cb.like(bt.get("booktpc"),filter.getFindTopic()));
	}
	

	private void filterLanguage(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getLanguage().isEmpty()){
			Join<Book, BookLanguage> bl=root.join("booklanguage");
			predicates.add(cb.like(bl.get("language"), filter.getLanguage()+"%"));
		}
	}
	private void filterAdition(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getAddition().isEmpty()){
			Join<Book, BookAdition> ba=root.join("bookadition");
			predicates.add(cb.like(ba.get("adition"), filter.getAddition()+"%"));
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
			findAllTopic(root, query, cb);		
			filterLanguage(root, query, cb);
			filterByPages(root, query, cb);
			filterByPrice(root, query, cb);
			filterAdition(root, query, cb);
			filterBySearchAutor(root, query, cb);
			filterBySearchName(root, query, cb);
			
			filterByYear(root, query, cb);
			Predicate[]array=new Predicate[predicates.size()];
			predicates.toArray(array);
			return cb.and(array);
		}
	
	
}
