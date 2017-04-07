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
import ua.entity.BookCover;
import ua.service.BookCoverService;
import ua.validator.BookCoverValidator;

@Controller
@RequestMapping("/admin/bc")
@SessionAttributes(names="bookcover")
public class BookCoverController {
	@Autowired
	private BookCoverService bookcoverService;
	
	@InitBinder("bookcover")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new BookCoverValidator(bookcoverService));
	}

	@ModelAttribute("bookcover")
	public BookCover getForm(){
		return new BookCover();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", bookcoverService.findAll(filter, pageable));
		return "admin-cover";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		try{
			bookcoverService.delete(id);
		}
		catch (Exception e){
		return "admin-exception";
		}
		return "redirect:/admin/bc"+getParams(pageable, filter);		
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("bookcover", bookcoverService.findOne(id));
		model.addAttribute("page", bookcoverService.findAll(filter,pageable));
		return "admin-cover";
	}
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("bookcover")@Valid BookCover bookcover,BindingResult br,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", bookcoverService.findAll(filter,pageable));
			return "admin-cover";
		}
		bookcoverService.save(bookcover);
		status.setComplete();
		return "redirect:/admin/bc"+getParams(pageable, filter);
	}
	@RequestMapping("/admin/exception")
	public String exception(){
		return "admin-exception";
	}
}
