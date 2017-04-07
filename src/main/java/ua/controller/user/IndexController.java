package ua.controller.user;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


import java.math.BigDecimal;
import java.security.Principal;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import filter.GlobalFilter;
import filter.UserFilter;
import form.UserForm;
import ua.entity.Book;
import ua.entity.User;
import ua.service.BookPromoService;
import ua.service.BookService;
import ua.service.BookTPCService;
import ua.service.BookTopicService;
import ua.service.UserService;
import ua.validator.UserValidator;

@Controller
public class IndexController {

	@Autowired
	private UserService userService;
	@Autowired
	private BookTPCService btpcService;
	@Autowired
	private BookService bService;
	@Autowired
	private BookTopicService btService;
	@Autowired
	private BookPromoService bpService;
	
	@ModelAttribute("formm")
	public UserForm getForm(){
		return new UserForm();
	}
	
	@InitBinder("formm")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(new UserValidator(userService));		
	}
	
	@ModelAttribute("filter")
	public UserFilter getFilter(){
		return new UserFilter();
	}
	@ModelAttribute("globalfilter")
	public GlobalFilter getGlobalFilter(){
		return new GlobalFilter();
	}
	@RequestMapping("/")
	public String index(Principal principal, Model model, @ModelAttribute("globalfilter") GlobalFilter globalfilter, @PageableDefault Pageable pageable){
		if(principal!=null)
		System.out.println(principal.getName());
		model.addAttribute("bookpromos", bpService.findAll());
		model.addAttribute("topics", btService.findAll());
        return "user-index";
	}
	
	@RequestMapping("/globalsearch")
	public String globalsearch( Model model, @PageableDefault Pageable pageable, @ModelAttribute("globalfilter") GlobalFilter globalfilter){
		if(globalfilter.getGlobal().isEmpty()){return "user-globalsearchempty";}
		if(!globalfilter.getGlobal().isEmpty()){
		model.addAttribute("page", bService.findAll(globalfilter, pageable));
			}
		return "user-globalsearch";
	}
	@RequestMapping("/globalsearchempty")
	public String globalsearchempty( Model model, @PageableDefault Pageable pageable, @ModelAttribute("globalfilter") GlobalFilter globalfilter){
		if(globalfilter.getGlobal().isEmpty()){return "user-globalsearchempty";}
		if(!globalfilter.getGlobal().isEmpty()){			
		model.addAttribute("page", bService.findAll(globalfilter, pageable));
		return "user-globalsearch";		
		}
		return "user-globalsearchempty";
	}
	
	@RequestMapping("/admin")
	public String admin(){
		return "admin-admin";
	}
	
	@RequestMapping("/login")
	public String login(){
		return "user-login";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "user-registration";
	}
	
	@RequestMapping(value="/registration", method=POST)
	public String registration(@ModelAttribute("formm") @Valid UserForm user, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			System.out.println("POMYLKA");
			model.addAttribute("user", new User());			
			return "user-registration";
		}		
		userService.save(user);		
		status.setComplete();
		return "redirect:/login";
	}
	
	@RequestMapping("/about")
	public String about(){
		return "user-about";
	}
	
	@RequestMapping("/dostavka")
	public String dostavka(){
		return "user-dostavka";
	}
	@RequestMapping("/pokupky")
	public String pokupky(){
		return "user-pokupky";
	}
	@RequestMapping("/privatecab")
	public String privatecab(Principal principal, Model model){
		String user= principal.getName();
		int id= userService.findByUsername(user).getId();
		System.out.println(user);
		model.addAttribute("user", userService.findOne(id));		
		return "user-privatecab";
	}

	@RequestMapping("/privatecab/update/{id}")
	public String update(@PathVariable int id,Model model, Principal principal){
		model.addAttribute("user", userService.findOne(id));		
		return "user-privatecab";
	}
	
	@RequestMapping("/buy/{id}")
		public String buy(@PathVariable int id, Principal principal){
		if(principal==null){ return "user-pokupky";}
		userService.buy(id, principal);
		return "redirect:/showbucket";
	}
	
	@RequestMapping("/topic/{id}")
	public String topic(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") UserFilter filter){
		model.addAttribute("booktpcs", btpcService.findAllBtpc(id));		
		String t = btService.findOne(id).toString();
		filter.setFindTopic(t);		
		model.addAttribute("page", bService.findAll(filter, pageable));
	return "user-topic";
}
	@RequestMapping("/booktpc/{id}")
	public String booktpc(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") UserFilter filter){
		String bt=btpcService.findOne(id).toString();
		filter.setFindTopic(bt);
		model.addAttribute("page", bService.findAllBTPC(filter, pageable));
		return"user-booktpc";
	}
	@RequestMapping("/promo/{id}")
	public String promo(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") UserFilter filter){
		String bp=bpService.findOne(id).toString();
		filter.setFindTopic(bp);
		System.out.println(bp);
		model.addAttribute("page", bService.findAllPromo(filter, pageable));
		return "user-promo";
	}
	
	@RequestMapping("/novynka")
	public String novynka(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") UserFilter filter){
		model.addAttribute("promos", bpService.findAll());
		return "user-novynka";
	}
	@RequestMapping("/showbucket/deletebuy/{id}")
	public String deletebuy(@PathVariable int id, Principal principal){
		
		userService.deletebuy(id, principal);
		return "redirect:/showbucket/";
	}
	@Transactional
	@RequestMapping("/buscet")
	public String buscet(Principal principal){
		String user= principal.getName();

		List <Book> b = userService.showbucket(principal).getBooks();
		int c=userService.showbucket(principal).getNumber();
		String d=userService.showbucket(principal).getEmail();
		String s="Назва книги(ціна,рік видання)";
		BigDecimal price = new BigDecimal(0);
		for (Book book : b) {
		String u=book.getBookname()+"("+book.getBookPrice()+"грн"+","+book.getBookYear()+"року"+"), ";
		s=s+u;
		price=price.add(book.getBookPrice());
		}
		System.out.println("Нове замовлення"+ "marrrichka@gmail.com"+user+" "+c+" "+d+" "+s);
		userService.sendMail("Нове замовлення", "marrrichka@gmail.com", user+" "+c+" "+d+" "+s+".Загальна сума - "+price+" грн.");
		userService.sendMail("Дякуємо за замовлення", d, "Ваше замовлення:"+s+".Загальна сума - "+price+" грн.");
		for (Book book : b) {
			userService.deletebuy(book.getId(), principal);
		
		}		
		return "user-buscet";
	}
	@RequestMapping("/emptybuscet")
	public String emptybuscet(){
		return "user-emptybuscet";
	}
	@RequestMapping("/showbucket")
        public String showbucket(Model model, Principal principal){
		try{
		principal.equals(null);
		}
		catch (NullPointerException e) {
			System.out.println("new");
			return "user-emptybuscet";
		}
				if(!principal.equals(null)){
					model.addAttribute("users", userService.showbucket(principal));
		        	BigDecimal price = new BigDecimal(0);
		        	for(Book b: userService.showbucket(principal).getBooks()){
		        		price=price.add(b.getBookPrice());
		        	}
		        	model.addAttribute("sum", price);
		        	return "user-showbucket";
				}						
			return  "user-emptybuscet";
	}
}
	

