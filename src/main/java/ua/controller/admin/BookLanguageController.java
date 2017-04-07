package ua.controller.admin;
import static ua.utils.ParamBuilder.getParams;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
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
import ua.entity.BookLanguage;
import ua.service.BookLanguageService;
import ua.validator.BookLanguageValidator;

@Controller
@RequestMapping("/admin/bl")
@SessionAttributes(names="booklanguage")
public class BookLanguageController {
	
	@Autowired
	private BookLanguageService booklService;
	
	@InitBinder("booklanguage")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new BookLanguageValidator(booklService));
	}

	@ModelAttribute("booklanguage")
	public BookLanguage getForm(){
		return new BookLanguage();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", booklService.findAll(filter, pageable));
		return "admin-language";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		try{
		booklService.delete(id);
		}
		catch (Exception e){		
		return "admin-exception";
	}		
		return "redirect:/admin/bl"+getParams(pageable, filter);
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("booklanguage", booklService.findOne(id));
		model.addAttribute("page", booklService.findAll(filter,pageable));
		return "admin-language";
	}
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("booklanguage")@Valid BookLanguage booklanguage,BindingResult br,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", booklService.findAll(filter,pageable));
			return "admin-language";
		}
		booklService.save(booklanguage);
		status.setComplete();
		return "redirect:/admin/bl"+getParams(pageable, filter);
	}
	@RequestMapping("/admin/exception")
	public String exception(){
		return "admin-exception";
	}

}
