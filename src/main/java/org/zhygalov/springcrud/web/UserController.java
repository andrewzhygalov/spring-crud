package org.zhygalov.springcrud.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import org.zhygalov.springcrud.service.UserService;
import org.zhygalov.springcrud.model.User;
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public String printUsers(ModelMap model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("emptyUser", new User());
		return "users";
	}
	@PostMapping
	public String addUser(User user, ModelMap model) {
		userService.create(user);
		return printUsers(model);
	}
	@PostMapping("/delete")
	public String deleteUser(User user) {
		userService.delete(user);
		return "redirect:/users";
	}
	@PostMapping("/update")
	public String updateUser(User user, ModelMap model) {
		model.addAttribute("user", user);
		return "updateUser";
	}
	@PostMapping("/update/process")
	public String processUpdate(User user) {
		userService.update(user);
		return "redirect:/users";
	}
}