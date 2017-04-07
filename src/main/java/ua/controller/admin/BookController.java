package ua.controller.admin;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import filter.BookFilter;
import form.BookForm;
import ua.editor.BookAditionEditor;
import ua.editor.BookAutorEditor;
import ua.editor.BookCoverEditor;
import ua.editor.BookLanguageEditor;
import ua.editor.BookPromoEditor;
import ua.editor.BookTopicPidCatEditor;
import ua.entity.BookAdition;
import ua.entity.BookAutor;
import ua.entity.BookCover;
import ua.entity.BookLanguage;
import ua.entity.BookPromo;
import ua.entity.BookTopicPidCat;
import ua.service.BookAditionService;
import ua.service.BookAutorService;
import ua.service.BookCoverService;
import ua.service.BookLanguageService;
import ua.service.BookPromoService;
import ua.service.BookService;
import ua.service.BookTPCService;
import ua.validator.BookValidator;

@Controller
@RequestMapping("/admin/b")
@SessionAttributes(names="bookname")
public class BookController {
	@Autowired
	private BookAditionService baddService;
	@Autowired
	private BookAutorService baService;
	@Autowired
	private BookCoverService bcService;
	@Autowired
	private BookLanguageService blService;
	@Autowired
	private BookPromoService bpService;
	@Autowired
	private BookTPCService btpcService;
	@Autowired
	private BookService bService;
		
	
	@InitBinder("bookname")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(BookAdition.class,new BookAditionEditor(baddService));
		binder.registerCustomEditor(BookAutor.class, new BookAutorEditor(baService));
		binder.registerCustomEditor(BookCover.class,new BookCoverEditor(bcService));
		binder.registerCustomEditor(BookLanguage.class,new BookLanguageEditor(blService));
		binder.registerCustomEditor(BookPromo.class,new BookPromoEditor(bpService));
		binder.registerCustomEditor(BookTopicPidCat.class, new BookTopicPidCatEditor(btpcService));
			  binder.setValidator(new BookValidator());		
	}
	
	@ModelAttribute("bookname")
	public BookForm getForm(){
		return new BookForm();
	}

	@ModelAttribute("filter")
	public BookFilter getFilter(){
		return new BookFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BookFilter filter){
		model.addAttribute("page", bService.findAll(filter,pageable));
		model.addAttribute("bookautors", baService.findAll());
		model.addAttribute("booklanguages", blService.findAll());
		model.addAttribute("bookaditions", baddService.findAll());		
		model.addAttribute("bookcovers", bcService.findAll());		
		model.addAttribute("bookpromos", bpService.findAll());
		model.addAttribute("booktpcs", btpcService.findAll());
		return "admin-book";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BookFilter filter){
		bService.delete(id);		
		return "redirect:/admin/b"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BookFilter filter){
		model.addAttribute("bookname" , bService.findOne(id));	
		model.addAttribute("page", bService.findAll(filter,pageable));			
		model.addAttribute("bookautors", baService.findAll());
		model.addAttribute("bookaditions", baddService.findAll());
		model.addAttribute("booklanguages", blService.findAll());
		model.addAttribute("bookcovers", bcService.findAll());
		model.addAttribute("bookpromos", bpService.findAll());
		model.addAttribute("booktpcs", btpcService.findAll());		
		return "admin-book";
	}
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("bookname") @Valid BookForm book, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BookFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", bService.findAll(filter,pageable));
			model.addAttribute("bookaditions", baddService.findAll());
			model.addAttribute("bookautors", baService.findAll());
			model.addAttribute("booklanguages", blService.findAll());
			model.addAttribute("bookcovers", bcService.findAll());
			model.addAttribute("bookpromos", bpService.findAll());
			model.addAttribute("booktpcs", btpcService.findAll());			
			return "admin-book";
		}
		bService.save(book);
		status.setComplete();
		return "redirect:/admin/b"+getParams(pageable, filter);
	}

	
	
	private String getParams(Pageable pageable, BookFilter filter) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		if(!filter.getSearchName().isEmpty()){
			buffer.append("&searchName=");
			buffer.append(filter.getSearchName());
		}
		if(!filter.getSearchAutor().isEmpty()){
			buffer.append("&searchAutor=");
			buffer.append(filter.getSearchAutor());
		}
//		if(!filter.getMaxPrice().isEmpty()){
//			buffer.append("&maxPrice=");
//			buffer.append(filter.getMaxPrice());
//		}
//		if(!filter.getMinPrice().isEmpty()){
//			buffer.append("&minPrice=");
//			buffer.append(filter.getMinPrice());
//		}
		if(!filter.getMaxPages().isEmpty()){
			buffer.append("&maxPages=");
			buffer.append(filter.getMaxPages());
		}
		if(!filter.getMinPages().isEmpty()){
			buffer.append("&minPages=");
			buffer.append(filter.getMinPages());
		}
		if(!filter.getMaxYear().isEmpty()){
			buffer.append("&maxYear=");
			buffer.append(filter.getMaxYear());
		}
		if(!filter.getMinYear().isEmpty()){
			buffer.append("&minYear=");
			buffer.append(filter.getMinYear());
		}
		for(Integer id : filter.getBaddIds()){
			buffer.append("&aditionIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getBcIds()){
			buffer.append("&coverIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getBlIds()){
			buffer.append("&languageIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getBpIds()){
			buffer.append("&promoIds=");
			buffer.append(id);
		}
		for(Integer id : filter.getBtpcIds()){
			buffer.append("&tpcIds=");
			buffer.append(id);
		}		
		return buffer.toString();
	}
		
	}

