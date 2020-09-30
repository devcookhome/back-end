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
public class LoginController {
    @Autowired
	private UserService service;

    @GetMapping("/user/login")
    public String showLoginForm(WebRequest request, Model model) {
        return "user/login";
    }

    @PostMapping("/user/login")
	public ModelAndView showLoginForm(Model model, WebRequest request) {
        User username = service.findByUsername(username);
        service.findByUsername(username);
		return new ModelAndView("user/login");
	}

}