package com.devcookhome.web;

import com.devcookhome.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class UserController {

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/registration";
    }

    @GetMapping("/user/login")
    public String showLoginForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user/login";
    }
}