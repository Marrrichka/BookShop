package ua.controller.admin;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.service.UserService;
@Controller
@RequestMapping("/admin/buscet")
public class BuscetController {

	@Autowired
	private UserService userService;
	@RequestMapping
    public String showbucket(Model model, Principal principal){
	model.addAttribute("users", userService.showbucket(principal));
	return "admin-buscet";
	}
}
