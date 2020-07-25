package com.devcookhome.dao;

import com.devcookhome.model.Entity;
import com.devcookhome.model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.ParameterizedType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GenericDAO<T extends Entity>{
    private static final String TABLE = "group1";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static Connection connection = ConnectionManager.getInstance().getConnection();

    private T instance;

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("JPATest");
            entityManager = factory.createEntityManager();
        }catch (Exception ex){
            ex.printStackTrace();
        } 

        return entityManager;
    }

    public T saveAndUpdate(T entity){
        EntityManager entityManager = getEntityManager();

        try {
           entityManager.getTransaction().begin();

           if(entity.getId() == null) {
            entityManager.persist(entity);
        } else {
            entityManager.merge(entity);
        }
        entityManager.getTransaction().commit();
    } 
    finally { 
        entityManager.close();
    }return entity;
}


private T newInstance(Class<T> clazz){
    try{
        return clazz.newInstance();
    }catch(InstantiationException | IllegalAccessException ex){
        ex.printStackTrace();            
        return null;
    }
}

public List<T>  list(Class<T> clazz){  

    T entity = newInstance(clazz);

    String sql = "SELECT * FROM " + entity.getTableName();

    List<T> list = new ArrayList<>();

    PreparedStatement pstm = null;
    ResultSet result = null;

    try {

        pstm = connection.prepareStatement(sql);

        result = pstm.executeQuery();


        while(result.next()){

            entity.setId(result.getLong(FIELD_ID));
            entity.setFieldValue(result.getString(entity.getFieldName()));
            list.add(entity);
            entity = newInstance(clazz);

        }
    }catch (Exception ex) {
        ex.printStackTrace();
    }finally{

        try{

            if(result != null){
                result.close();
            }

            if(pstm != null){
                pstm.close();
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }

        return list;
    } 
}

public Boolean delete(Long id, Class<T> clazz) {
    EntityManager entityManager = getEntityManager();
    try {
        entityManager.getTransaction().begin();
        T entity = entityManager.find(clazz, id);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        return true;
    } catch(Exception ex){
        return false;
    }finally {
      entityManager.close();
  }
}

public T getById(Long id, Class <T> clazz) {
    EntityManager entityManager = getEntityManager();
    T entity = null;
    try {
      entity = entityManager.find(clazz, id);
  } finally {
      entityManager.close();
  }
  return entity;
}

}