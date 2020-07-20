package com.devcookhome.dao;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.devcookhome.model.Entity;
import com.devcookhome.model.Group;
import java.sql.Connection;
import java.util.List;


public class GroupDAOTest extends TestCase{

    public void setUp() {
    	Group g = new Group();
		
		g.setName("Vegetais");

		GenericDAO.save(g);

		System.out.println("... Setup OK");
    }

	public void testSave(){

		System.out.print("GroupDAOTest#save");

		Group g = new Group();
		g.setName("Vegetais");

		GenericDAO.save(g);

		assert g.getId() != null && g.getId() > 0;

		System.out.println("... OK");
	}

	public void testList(){


		System.out.print("GroupDAOTest#list");

		GenericDAO<Group> dao = new GenericDAO<>();

		List<Group> groups = dao.list(Group.class);

		if (groups.size() == 0){
			throw new RuntimeException("Expected Groups size > 0 ");
		}

		System.out.println("... OK");
	}

	public void testUpdate(){


		System.out.print("GroupDAOTest#update");

		GenericDAO<Group> dao = new GenericDAO<>();

		List<Group> groups = dao.list(Group.class);

		Group g = groups.get(0);
		g.setName("Carnes");

		Boolean b = dao.update(g);

		assert b;

		System.out.println("... OK");
	}

	public void testGetById(){


		System.out.print("GroupDAOTest#getById");

		GenericDAO<Group> dao = new GenericDAO<>();

		Long id = dao.list(Group.class).get(0).getId();

		Group g = dao.getById(id, Group.class);

		assert g.getName().equals("Carnes");

		System.out.println("... OK");
	}

	public void testDelete(){


		System.out.print("GroupDAOTest#delete");

		GenericDAO<Group> dao = new GenericDAO<>();

		List<Group> groups = dao.list(Group.class);

		Group g = groups.get(0);
		Integer size = groups.size();

		assert dao.delete(g);
		assert size > dao.list(Group.class).size();

		System.out.println("... OK");
	}
}
