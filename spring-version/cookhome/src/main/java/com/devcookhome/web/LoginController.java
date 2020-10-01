package com.devcookhome.web;

import javax.servlet.http.HttpSession;

import com.devcookhome.model.LoginDTO;
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
	public ModelAndView save(HttpSession session, Model model, LoginDTO login) {
        User user = service.findByUsername(login);
        if(user != null){
            session.setAttribute("username", user.getName());
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("redirect:/user/login/?error=true");
	}

    @GetMapping("/user/login/sucess")
    public String loginsucess (WebRequest request, Model model) {
        return "user/loginsucess";
    }
}