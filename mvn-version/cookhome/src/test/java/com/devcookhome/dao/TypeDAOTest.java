package com.devcookhome.dao;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.devcookhome.model.Type;
import java.sql.Connection;
import java.util.List;

public class TypeDAOTest extends TestCase{

	 public void setUp() {
    	Type t = new Type();
		
		t.setType("Teste");

		try{
			new GenericDAO<Type>().saveAndUpdate(t);
		}catch (Exception ex){
			ex.printStackTrace();
		}

		System.out.println("... Setup OK");
    }

	public void testSave(){
		
		Type t = new Type();
		t.setType("Teste");
		try{
			new GenericDAO<Type>().saveAndUpdate(t);
		}catch (Exception ex){
			ex.printStackTrace();
		}

		System.out.println("... OK");
	}

	public void testUpdate(){
		
		Type t = new Type();
		t.setType("Teste Update");
		try{
			new GenericDAO<Type>().saveAndUpdate(t);
		}catch (Exception ex){
			ex.printStackTrace();
		}

		System.out.println("... OK");
	}

	/*public void testList(){

		System.out.print("TypeDAOTest#list");

		GenericDAO<Type> dao = new GenericDAO<>();

		List<Type> types = dao.list(Type.class);

		if (types.size() == 0){
			throw new RuntimeException("Expected Types size > 0 ");
		}

		System.out.println("... OK");
	}*/

	/*public void testExcluir(){

		System.out.print("TypeDAOTest#delete");

		GenericDAO<Type> dao = new GenericDAO<>();

		List<Type> types = dao.list(Type.class);

		Type t = types.get(0);
		Integer size = types.size();

		//assert dao.excluir(t);
		//assert size > dao.list(Type.class).size();
		try{
			new GenericDAO<Type>().excluir(t);
		}catch (Exception ex){
			ex.printStackTrace();
		}

		System.out.println("... OK");

	}*/

	public void testGetById(){

		testSave();

		System.out.print("TypeDAOTest#getById");

		GenericDAO<Type> dao = new GenericDAO<>();

		Long id = dao.list(Type.class).get(0).getId();

		Type t = dao.getById(id, Type.class);

		assert t.getType().equals("Teste Update");

		System.out.println("... OK");
	}
}
