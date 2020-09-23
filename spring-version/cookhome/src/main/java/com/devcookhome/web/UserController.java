package com.devcookhome.web;

import com.devcookhome.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import com.devcookhome.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class UserController {
    @Autowired
	private UserService service;

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }

    @PostMapping("/user/registration")
	public ModelAndView save(Model model, User user) {
		service.save(user);
		return new ModelAndView("redirect:/group/new/sucess");
	}


    @GetMapping("/user/login")
    public String showLoginForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/login";
    }
}