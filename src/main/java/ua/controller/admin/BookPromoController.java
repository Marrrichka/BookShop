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
import ua.entity.BookPromo;
import ua.service.BookPromoService;
import ua.validator.BookPromoValidator;

@Controller
@RequestMapping("/admin/bp")
@SessionAttributes(names="bookpromo")
public class BookPromoController {

	@Autowired
	private BookPromoService bpService;
	
	@InitBinder("bookpromo")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new BookPromoValidator(bpService));
	}

	@ModelAttribute("bookpromo")
	public BookPromo getForm(){
		return new BookPromo();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@RequestMapping
	public String show(Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", bpService.findAll(filter, pageable));
		return "admin-promo";
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		try{			
		bpService.delete(id); }
		catch (Exception e) {
			return "admin-exception";
		}
		return "redirect:/admin/bp"+getParams(pageable, filter);
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("bookpromo", bpService.findOne(id));
		model.addAttribute("page", bpService.findAll(filter,pageable));
		return "admin-promo";
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("bookpromo")@Valid BookPromo bookpromo,BindingResult br,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", bpService.findAll(filter,pageable));
			return "admin-promo";
		}
		bpService.save(bookpromo);
		status.setComplete();
		return "redirect:/admin/bp"+getParams(pageable, filter);
	}
	@RequestMapping("/admin/exception")
	public String exception(){
		return "admin-exception";
	}
}
