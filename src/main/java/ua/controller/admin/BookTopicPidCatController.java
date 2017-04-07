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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import filter.BookTPCFilter;
import ua.editor.BookTopicEditor;
import ua.editor.BookTopicPidCatEditor;
import ua.entity.BookTopic;
import ua.entity.BookTopicPidCat;
import ua.service.BookTPCService;
import ua.service.BookTopicService;
import ua.validator.BookTPCValidator;

@Controller
@RequestMapping("/admin/btpc")
@SessionAttributes("booktpc")
public class BookTopicPidCatController {
	
	@Autowired
	private BookTPCService btpcService;
	
	@Autowired
	private BookTopicService btService;
	
	@InitBinder("booktpc")
	protected void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(BookTopic.class, new BookTopicEditor(btService));
		binder.setValidator(new BookTPCValidator(btpcService));
	}
	
	@ModelAttribute("booktpc")
	public BookTopicPidCat getForm(){
		return new BookTopicPidCat();
	}

	@ModelAttribute("filter")
	public BookTPCFilter getFilter(){
		return new BookTPCFilter();
	}
	@GetMapping
	public String show(Model model,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BookTPCFilter filter){
		model.addAttribute("topics", btService.findAll());
		model.addAttribute("page", btpcService.findAll(filter, pageable));
		return "admin-booktpc";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id,  @PageableDefault Pageable pageable, @ModelAttribute("filter") BookTPCFilter filter){
		
		try{		
		btpcService.delete(id);}
		catch (Exception e) {
		return "admin-exception";
		}
		return "redirect:/admin/btpc"+ getParams(pageable, filter);
	}
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model model,@PageableDefault Pageable pageable, @ModelAttribute("filter") BookTPCFilter filter){
		model.addAttribute("booktpc", btpcService.findOne(id));
		show(model, pageable, filter);
		return "admin-booktpc";
	}
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("booktpc") @Valid BookTopicPidCat booktpc, BindingResult br, Model model, SessionStatus status, @PageableDefault Pageable pageable, @ModelAttribute("filter") BookTPCFilter filter){
		if(br.hasErrors()){
			model.addAttribute("page", btpcService.findAll(filter, pageable));
			model.addAttribute("topics",btService.findAll());
			model.addAttribute("booktpcs", btpcService.findAll());
			System.out.println("Errors");
			return "admin-booktpc";
			}
			btpcService.save(booktpc);
			System.out.println("Not errors");
			status.setComplete();
		return "redirect:/admin/btpc"+getParams(pageable, filter);
	
	}
	private String getParams(Pageable pageable, BookTPCFilter filter) {
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
		if(!filter.getSearch().isEmpty()){
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
		for(Integer id : filter.getTopicIds()){
			buffer.append("&topicIds=");
			buffer.append(id);
		}
		return buffer.toString();
	}
	@RequestMapping("/admin/exception")
	public String exception(){
		return "admin-exception";
	}
	
}
