package com.devcookhome.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.devcookhome.dao.GenericDAO;
import com.devcookhome.model.Group;
import java.util.List;

@Controller
public class GroupController {
	public void listGroup(){
		List<Group> groups = new GenericDAO<Group>().list(Group.class);
		for(Group g:groups){
			g.getName();
		}
	}

	@GetMapping("/groups")
	public String groups(
		@RequestParam(list=listGroup())List list, Model model) {
		model.addAttribute("list", list);
		return "groups";
	}
}