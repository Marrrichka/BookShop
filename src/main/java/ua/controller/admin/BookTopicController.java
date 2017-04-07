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
import ua.entity.BookTopic;
import ua.service.BookTopicService;
import ua.validator.BookTopicValidator;

@Controller
@RequestMapping("/admin/bt")
@SessionAttributes(names="booktopic")
public class BookTopicController {

	@Autowired
	private BookTopicService btService;;
	
	@InitBinder("booktopic")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new BookTopicValidator(btService));
	}

	@ModelAttribute("booktopic")
	public BookTopic getForm(){
		return new BookTopic();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	@RequestMapping
	public String show( Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("page", btService.findAll(filter,pageable));
		return "admin-topic";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		try{
		btService.delete(id);
		}
		catch (Exception e) {
		return "admin-exception";
		}
		return "redirect:/admin/bt"+getParams(pageable, filter);
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("booktopic", btService.findOne(id));
		model.addAttribute("page", btService.findAll(filter,pageable));
		return "admin-topic";
	}
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("booktopic")@Valid BookTopic booktopic,BindingResult br,Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", btService.findAll(filter,pageable));
			return "admin-topic";
		}
		btService.save(booktopic);
		status.setComplete();
		return "redirect:/admin/bt"+getParams(pageable, filter);
	}
	@RequestMapping("/admin/exception")
	public String exception(){
		return "admin-exception";
	}
}
