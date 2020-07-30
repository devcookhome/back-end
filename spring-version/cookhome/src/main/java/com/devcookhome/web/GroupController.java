package com.devcookhome.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.devcookhome.model.GroupRepository;

@Controller
public class GroupController {
	
	@Autowired
  	private GroupRepository repository;	

	@GetMapping("/group")
	public String group(Model model) {
		model.addAttribute("list", repository.findAll());
		return "group";
	}
}