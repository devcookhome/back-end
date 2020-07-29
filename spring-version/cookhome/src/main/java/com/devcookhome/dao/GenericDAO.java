package com.devcookhome.dao;

import com.devcookhome.model.Entity;
import com.devcookhome.model.Group;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<T extends Entity>{

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;

    private EntityManager getEntityManager() {
        
        if(GenericDAO.entityManager == null){
            try {
                GenericDAO.factory = Persistence.createEntityManagerFactory("JPATest");
                GenericDAO.entityManager = factory.createEntityManager();
            }catch (Exception ex){
                ex.printStackTrace();
            } 
        }

        return GenericDAO.entityManager;
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
    } catch(Exception ex){

    }
    return entity;
}

public List<T>  list(Class<T> clazz){  

    return entityManager.createQuery("FROM " + clazz.getName()).getResultList();
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
    }
}

public T getById(Long id, Class <T> clazz) {
    EntityManager entityManager = getEntityManager();
    T entity = null;
    try {
      entity = entityManager.find(clazz, id);
  } catch(Exception ex){

  }
  return entity;
}

}