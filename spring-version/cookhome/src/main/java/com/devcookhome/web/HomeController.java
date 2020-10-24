package com.devcookhome.web;

import com.devcookhome.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@Autowired
	private RecipeService recipeService;

	@GetMapping(value={"/home", "/inicio"})
	public String home(Model model) {
		
		model.addAttribute("recipes", recipeService.findAll());
		return "home";
	}

	@GetMapping("/storage")
	public String storage(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "storage";
	}


}