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
import ua.entity.BookAdition;
import ua.service.BookAditionService;
import ua.validator.BookAditionValidator;

@Controller
@RequestMapping("/admin/badd")
@SessionAttributes(names="bookadition")
public class BookAditionController {


	@Autowired
	private BookAditionService baddService;
	
	@ModelAttribute("bookadition")
	protected BookAdition getForm(){
		return new BookAdition();
	}
	
	@InitBinder("bookadition")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new BookAditionValidator(baddService));
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	
	@RequestMapping
	public String show( Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", baddService.findAll(filter,pageable));
		return "admin-adition";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		try{		
		baddService.delete(id);
		}
		catch (Exception e){			
		return "admin-exception";
		}
		return "redirect:/admin/badd"+getParams(pageable, filter);
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("bookadition", baddService.findOne(id));
		model.addAttribute("page", baddService.findAll(filter,pageable));
		return "admin-adition";
	}
	
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("bookadition")@Valid BookAdition bookadition,BindingResult br,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", baddService.findAll(filter,pageable));
			return "admin-adition";
		}
		baddService.save(bookadition);
		status.setComplete();
		return "redirect:/admin/badd"+getParams(pageable, filter);
	}
	@RequestMapping("/admin/exception")
	public String exception(){
		return "admin-exception";
	}
}
