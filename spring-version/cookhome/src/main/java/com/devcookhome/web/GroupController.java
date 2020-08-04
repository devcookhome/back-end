package com.devcookhome.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import com.devcookhome.services.GroupService;
import com.devcookhome.model.Group;


@Controller
public class GroupController {
	@Autowired
	private GroupService service;

	@GetMapping("/group")
	public String group(Model model) {
		model.addAttribute("list", service.findAll());
		return "group";
	}

	@PostMapping("/group")
	public ModelAndView save(Model model, Group group) {
		service.save(group);
		return new ModelAndView("redirect:/group/new/sucess");
	}

	@GetMapping("/group/new")
	public String groupNew(Model model) {
		model.addAttribute("list", service.findAll());
		return "newgroup";
	}

	@GetMapping("/group/new/sucess") // Se der certo sera redirecionado para este link
	public String groupNewSucess(Model model) {
		model.addAttribute("list", service.findAll());
		return "newgroupsucess";
	}

}