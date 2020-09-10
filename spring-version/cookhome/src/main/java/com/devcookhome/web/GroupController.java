package com.devcookhome.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
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
	@GetMapping("/group/edit/{id}")
	public String groupEdit(Model model, @PathVariable("id")Long id) {
		Group group = service.findById(id);
		model.addAttribute("group", group);
		return "editgroup";
	}

	@PutMapping("/group/edit/{id}")
	public ModelAndView groupEdit(Model model, @PathVariable("id")Long id, Group groupUpdate) {
		try{
			Group group = service.findById(id);
			group.setName(groupUpdate.getName());
			service.save(group);
			return new ModelAndView("redirect:/group/edit/sucess");
		}catch(Exception ex){
			return new ModelAndView("redirect:/group/edit/" + id + "?error=true");
		}
	}

	@GetMapping("/group/edit/sucess") // Se der certo a edição, sera redirecionado para este link
	public String editGroupSucess(Model model) {
		model.addAttribute("list", service.findAll());
		return "editgroupsucess";
	}

	/*@DeleteMapping("/group/edit/{id}")
	public ModelAndView groupDelete(Model model, @PathVariable("id")Long id, Group groupDelete) {
		Group group = service.findById(id);
		group.setName(groupDelete.getName());
		service.delete(group);
		return new ModelAndView("redirect:/group/delete/sucess");
	}

	@GetMapping("/group/delete/sucess") // Se der certo a exclusão, sera redirecionado para este link
	public String deleteGroupSucess(Model model) {
		model.addAttribute("list", service.findAll());
		return "deletegroupsucess";
	}*/
}