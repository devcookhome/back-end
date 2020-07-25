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

		try{
			new GenericDAO<Group>().saveAndUpdate(g);
		}catch (Exception ex){
			ex.printStackTrace();
		}

		System.out.println("... Setup OK");
    }

	public void testSave(){

		Group g = new Group();
		g.setName("Vegetais");

		try{
			new GenericDAO<Group>().saveAndUpdate(g);
		}catch (Exception ex){
			ex.printStackTrace();
		}

	}


	public void testUpdate(){

		GenericDAO<Group> dao = new GenericDAO<>();

		List<Group> groups = dao.list(Group.class);

		Group g = groups.get(0);

		g.setName("Carnes");

		Group result = dao.saveAndUpdate(g);

		assertEquals("Carnes",result.getName());

	}

	/*public void testList(){


		System.out.print("GroupDAOTest#list");

		GenericDAO<Group> dao = new GenericDAO<>();

		List<Group> groups = dao.list(Group.class);

		if (groups.size() == 0){
			throw new RuntimeException("Expected Groups size > 0 ");
		}

		System.out.println("... OK");
	}*/

	public void testGetById(){

		testUpdate();

		GenericDAO<Group> dao = new GenericDAO<>();

		Long id = dao.list(Group.class).get(0).getId();

		System.out.println("ID " + id);

		Group g = dao.getById(id, Group.class);

		System.out.println("************ \n" + g.getName() + id + "\n************" );

		assertEquals("Carnes",g.getName());

	}

	public void testDelete(){

		GenericDAO<Group> dao = new GenericDAO<>();

		List<Group> groups = dao.list(Group.class);

		Group g = groups.get(0);
		Integer size = groups.size();

		assert dao.delete(g.getId(), Group.class);
		assert size > dao.list(Group.class).size();
	}
}
