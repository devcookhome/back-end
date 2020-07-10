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


public class GenericDAO<T extends Entity>{
    private static final String TABLE = "group1";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static Connection connection = ConnectionManager.getInstance().getConnection();

    private T instance;

    public static Entity save(Entity entity){
        if(entity == null) return entity;
        //Ha outras maneiras mais elegante para concatenar strings. 
        //Inclusive a melhor maneira é setar as variaveis em preparedStatement para evitar
        //SQL Injections.
        //Essa abordagem trivial está sendo utilizado com efeito didático.
        String sql = "INSERT INTO " + entity.getTableName() + "(" + entity.getFieldName() + ") VALUES ('"
        + entity.getFieldValue() + "');";
        try{
            //Prepara o objeto que exectua os comandos no banco    
            Statement statement = connection.createStatement();
            //Executa a instrução no banco
            statement.executeUpdate(sql);
            //ler último id inserido para inserir no objeto criado
            ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() AS lastId;");

            while(result.next()) {
                entity.setId(result.getLong("lastId"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return entity;
    }   

    private T newIntance(Class<T> clazz){
        try{
            return clazz.newInstance();
        }catch(InstantiationException | IllegalAccessException ex){
            ex.printStackTrace();            
            return null;
        }
    }

    public List<T>  list(Class<T> clazz){  

        T entity = newIntance(clazz);

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
                entity = newIntance(clazz);

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

    public Boolean update(T entity){

        String sql = "UPDATE " + entity.getTableName() + " SET " + entity.getFieldName() + " = ? WHERE " + FIELD_ID + " = ?";

        PreparedStatement pstm = null;
        
        try {

            pstm = connection.prepareStatement(sql);

            pstm.setString(1, entity.getFieldValue());
            pstm.setLong(2, entity.getId());

            pstm.execute();
            pstm.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Boolean delete(Group group){

        String sql = "DELETE FROM " + TABLE + " WHERE " + FIELD_ID + " = ?";

        PreparedStatement pstm = null;

        try {

            pstm = connection.prepareStatement(sql);

            pstm.setLong(1, group.getId());

            pstm.execute();
            pstm.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Group getById(Long id){
        String sql = "SELECT * FROM " + TABLE + " WHERE " + FIELD_ID + " = ?";

        PreparedStatement pstm = null;

        try{

            pstm = connection.prepareStatement(sql);

            pstm.setLong(1, id);

            ResultSet result = pstm.executeQuery();

            Group group = null;

            while(result.next()){
                group = new Group();
                group.setName(result.getString(FIELD_NAME));
                group.setId(result.getLong(FIELD_ID));
            }

            pstm.close();
            result.close();
            return group;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}