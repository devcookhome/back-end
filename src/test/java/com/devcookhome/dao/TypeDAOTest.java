package com.devcookhome.dao;

import com.devcookhome.model.Type;
import java.sql.Connection;
import java.util.List;

public class TypeDAOTest{

	
	public static void main(String[] args) {
	
		testSave();
		testList();
		testUpdate();
		testGetById();
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

		GenericDAO<Type> dao = new GenericDAO<>();

		List<Type> types = dao.list(Type.class);

		if (types.size() == 0){
			throw new RuntimeException("Expected Types size > 0 ");
		}

		System.out.println("... OK");
	}

	public static void testUpdate(){

		System.out.print("TypeDAOTest#update");

		GenericDAO<Type> dao = new GenericDAO<>();

		List<Type> types = dao.list(Type.class);

		Type t = types.get(0);
		t.setType("Teste Update");

		Boolean b = dao.update(t);

		assert b;

		System.out.println("... OK");
	}

	public static void testDelete(){

		System.out.print("TypeDAOTest#delete");

		GenericDAO<Type> dao = new GenericDAO<>();

		List<Type> types = dao.list(Type.class);

		Type t = types.get(0);
		Integer size = types.size();

		assert dao.delete(t);
		assert size > dao.list(Type.class).size();

		System.out.println("... OK");


	}

	public static void testGetById(){

		System.out.print("TypeDAOTest#getById");

		GenericDAO<Type> dao = new GenericDAO<>();

		Long id = dao.list(Type.class).get(0).getId();

		Type t = dao.getById(id, Type.class);

		assert t.getType().equals("Teste Update");

		System.out.println("... OK");
	}
}
