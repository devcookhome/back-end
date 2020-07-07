package com.devcookhome.dao;

import com.devcookhome.model.Type;
import java.sql.Connection;
import java.util.List;

public class TypeDAOTest{

	
	public static void main(String[] args) {
	
		testSave();
		testList();
		testUpdate();
		testDelete();

	}

	public static void testSave(){

		System.out.print("TypeDAOTest#save");

		Type t = new Type();
		t.setType("Teste");

		GenericDAO.save(t);

		assert t.getId() != null && t.getId() > 0;

		System.out.println("... OK");
	}

	public static void testList(){

		System.out.print("TypeDAOTest#list");

		List<Type> types = TypeDAO.list();

		if (types.size() == 0){
			throw new RuntimeException("Expected Types size > 0 ");
		}

		System.out.println("... OK");
	}

	public static void testUpdate(){

		System.out.print("TypeDAOTest#update");

		List<Type> types = TypeDAO.list();

		Type t = types.get(0);
		t.setType("Teste Update");

		Boolean b = TypeDAO.update(t);

		assert b;

		System.out.println("... OK");
	}

	public static void testDelete(){

		System.out.print("TypeDAOTet#delete");

		List<Type> types = TypeDAO.list();

		Type t = types.get(0);
		Integer size = types.size();

		assert TypeDAO.delete(t);
		assert size > TypeDAO.list().size();

		System.out.println("... OK");


	}
}
