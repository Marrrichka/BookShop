package ua.controller.admin;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.utils.ParamBuilder.getParams;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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


import filter.BasicFilter;
import ua.entity.BookAutor;
import ua.service.BookAutorService;
import ua.validator.BookAutorValidator;

@Controller
@RequestMapping("/admin/ba")
@SessionAttributes(names="bookautors")
public class BookAutorController {
	@Autowired
	private BookAutorService bookautorService;
	
	@ModelAttribute("bookautors")
	protected BookAutor getForm(){
		return new BookAutor();
	}
	
	@InitBinder("bookautors")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new BookAutorValidator(bookautorService));
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	
	@RequestMapping
	public String show( Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", bookautorService.findAll(filter,pageable));
		return "admin-autor";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){

		try{
		bookautorService.delete(id);
		}
		catch (Exception e){
		return "admin-exception";
		}
		return "redirect:/admin/ba"+getParams(pageable, filter);
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("bookautors", bookautorService.findOne(id));
		model.addAttribute("page", bookautorService.findAll(filter,pageable));
		return "admin-autor";
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("bookautors")@Valid BookAutor bookautor,BindingResult br,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", bookautorService.findAll(filter,pageable));
		
			return "admin-autor";
		}
		bookautorService.save(bookautor);
		status.setComplete();
		return "redirect:/admin/ba"+getParams(pageable, filter);
	}
	@RequestMapping("/admin/exception")
	public String exception(){
		return "admin-exception";
	}
	
}
