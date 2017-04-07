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

import filter.GlobalFilter;
import ua.entity.Book;
import ua.entity.BookAdition;
import ua.entity.BookAutor;
import ua.entity.BookCover;
import ua.entity.BookLanguage;
import ua.entity.BookPromo;
import ua.entity.BookTopic;
import ua.entity.BookTopicPidCat;

public class GlobalSpecification implements Specification<Book>{
	
	private final GlobalFilter globalfilter;

	public final List<Predicate> predicates= new ArrayList<>();
	public GlobalSpecification(GlobalFilter globalfilter) {
		super();
		this.globalfilter = globalfilter;
	}
	
			
		private void filterBySearchName(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb){
			if(!globalfilter.getGlobal().isEmpty()){
				Predicate bn=cb.like(root.get("bookname"), globalfilter.getGlobal()+"%");
				
				Join<Book, BookAutor> ba = root.join("bookautors");
				Predicate booka= cb.like(ba.get("autor"), globalfilter.getGlobal()+"%");
				
				Join<Book, BookLanguage> bl=root.join("booklanguage");
				Predicate bookl=cb.like(bl.get("language"), globalfilter.getGlobal()+"%");
				
				Join<Book, BookPromo> bp=root.join("bookpromo");
				Predicate bookp=cb.like(bp.get("promo"), globalfilter.getGlobal()+"%");
				
				Join<Book, BookAdition> badd=root.join("bookadition");
				Predicate bookadd=cb.like(badd.get("adition"), globalfilter.getGlobal()+"%");
				
				Join<Book, BookCover> bc=root.join("bookcover");
				Predicate bookc=cb.like(bc.get("cover"), globalfilter.getGlobal()+"%");
				
				Join<Book, BookTopicPidCat> bt=root.join("booktpc");
				Join<BookTopicPidCat, BookTopic> bookt=bt.join("topic");
				Predicate booktopic=cb.like(bookt.get("topic"),globalfilter.getGlobal()+"%");
				
				Join<Book, BookTopicPidCat> booktopicpidc=root.join("booktpc");
				Predicate booktpc=cb.like(booktopicpidc.get("booktpc"), globalfilter.getGlobal()+"%");
			
				predicates.add(cb.or(bn, booka, bookl, bookp, bookadd, bookc, booktopic, booktpc));

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
		filterBySearchName(root, query, cb);
		Predicate[]array=new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	}
	

}
