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
    }

	public void testSave(){
		
		Type t = new Type();
		t.setType("Teste");
		try{
			new GenericDAO<Type>().saveAndUpdate(t);
		}catch (Exception ex){
			ex.printStackTrace();
		}
	}

	public void testUpdate(){

		GenericDAO<Type> dao = new GenericDAO<>();

		List<Type> types = dao.list(Type.class);

		Type t = types.get(0);

		t.setType("Teste Update");

		Type result = dao.saveAndUpdate(t);

		assertEquals("Teste Update",result.getType());
	}

	public void testList(){

	GenericDAO<Type> dao = new GenericDAO<>();

	List<Type> types = dao.list(Type.class);

	if (types.size() == 0){
		throw new RuntimeException("Expected Types size > 0 ");
		}
		assertTrue(types.get(0).getId() != null);
	}


	public void testGetById(){

		testUpdate();

		GenericDAO<Type> dao = new GenericDAO<>();

		Long id = dao.list(Type.class).get(0).getId();

		Type t = dao.getById(id, Type.class);

		assertEquals("Teste Update",t.getType());
	}
	
	public void testDelete(){

		GenericDAO<Type> dao = new GenericDAO<>();

		List<Type> types = dao.list(Type.class);

		Type t = types.get(0);
		Integer size = types.size();

		assert dao.delete(t.getId(), Type.class);
		assert size > dao.list(Type.class).size();
	}

}
