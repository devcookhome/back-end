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
    public String showRegistrationForm(Model model) {
        //User user = new User();
        model.addAttribute("user");
        return "user/registration";
    }

    @PostMapping("/user/registration")
	public ModelAndView save(Model model, User user) {
		try{
            service.save(user);
		    return new ModelAndView("redirect:/user/registration/sucess");
        }catch(Exception ex){
            return new ModelAndView("redirect:/user/registration/?error=true");
        }
    }

    @GetMapping("/user/registration/sucess") // Se der certo sera redirecionado para este link
    public String userRegistrationSucess(Model model) {
            model.addAttribute("user");
            return "user/registrationsucess";
    }

    @GetMapping("/user/login")
    public String showLoginForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/login";
    }
}