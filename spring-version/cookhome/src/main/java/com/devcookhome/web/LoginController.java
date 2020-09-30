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
    
    @PostMapping("/user/login/{username}")
	public ModelAndView showLoginForm(Model model, @PathVariable("username") User username) {
		User user = service.findByUsername(username);
		user.setUsername(user.getUsername());
        System.out.println(user);
        return new ModelAndView("redirect:/user/login/sucess");
    }
    
    @GetMapping("/user/login/sucess")
    public String loginsucess (WebRequest request, Model model) {
        return "user/loginsucess";
    }

}