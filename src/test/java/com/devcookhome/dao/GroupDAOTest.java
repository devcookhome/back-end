package com.devcookhome.dao;

import com.devcookhome.model.Group;
import java.sql.Connection;

public class GroupDAOTest{

	
	public static void main(String[] args) {
	
		testSave();

	}

	public static void testSave(){

		System.out.print("GroupDAOTest#save");

		Group g = new Group();
		g.setName("Vegetais");

		GroupDAO.save(g);

		assert g.getId() != null && g.getId() > 0;

		System.out.println("... OK");
	}


}