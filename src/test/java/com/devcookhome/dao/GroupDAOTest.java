package com.devcookhome.dao;

import com.devcookhome.model.Group;
import java.sql.Connection;
import java.util.List;

public class GroupDAOTest{

	
	public static void main(String[] args) {
	
		testSave();
		testList();
		testUpdate();
		testDelete();

	}

	public static void testSave(){

		System.out.print("GroupDAOTest#save");

		Group g = new Group();
		g.setName("Vegetais");

		GroupDAO.save(g);

		assert g.getId() != null && g.getId() > 0;

		System.out.println("... OK");
	}

	public static void testList(){

		System.out.print("GroupDAOTest#list");

		List<Group> groups = GroupDAO.list();

		if (groups.size() == 0){
			throw new RuntimeException("Expected Groups size > 0 ");
		}

		System.out.println("... OK");
	}

	public static void testUpdate(){

		System.out.print("GroupDAOTest#update");

		List<Group> groups = GroupDAO.list();

		Group g = groups.get(0);
		g.setName("Carnes");

		Boolean b = GroupDAO.update(g);

		assert b;

		System.out.println("... OK");
	}

	public static void testDelete(){

		System.out.print("GroupDAOTet#delete");

		List<Group> groups = GroupDAO.list();

		Group g = groups.get(0);
		Integer size = groups.size();

		assert GroupDAO.delete(g);
		assert size > GroupDAO.list().size();

		System.out.println("... OK");


	}
}
