package com.devcookhome.dao;

import com.devcookhome.model.Group;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GroupDAO{
    private static final String TABLE = "group1";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static Connection connection = ConnectionManager.getInstance().getConnection();

    public static Group save(Group group){
        if(group == null) return group;
        //Ha outras maneiras mais elegante para concatenar strings. 
        //Inclusive a melhor maneira é setar as variaveis em preparedStatement para evitar
        //SQL Injections.
        //Essa abordagem trivial está sendo utilizado com efeito didático.
        String sql = "INSERT INTO " + TABLE + "(" + FIELD_NAME + ") VALUES ('"
        + group.getName() + "');";
        try{
            //Prepara o objeto que exectua os comandos no banco    
            Statement statement = connection.createStatement();
            //Executa a instrução no banco
            statement.executeUpdate(sql);
            //ler último id inserido para inserir no objeto criado
            ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() AS lastId;");

            while(result.next()) {
                group.setId(result.getLong("lastId"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return group;
    }   

    public static List<Group> list(){

        String sql = "SELECT * FROM " + TABLE;

        List<Group> groups = new ArrayList<Group>();

        PreparedStatement pstm = null;
        ResultSet result = null;

        try {

            pstm = connection.prepareStatement(sql);

            result = pstm.executeQuery();


            while(result.next()){

                Group group = new Group();
                group.setId(result.getLong(FIELD_ID));
                group.setName(result.getString(FIELD_NAME));
                groups.add(group);

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

            return groups;
        } 
    }

    public static Boolean update(Group group){

        String sql = "UPDATE " + TABLE + " SET " + FIELD_NAME + " = ? WHERE " + FIELD_ID + " = ?";

        PreparedStatement pstm = null;
        
        try {

            pstm = connection.prepareStatement(sql);

            pstm.setString(1, group.getName());
            pstm.setLong(2, group.getId());

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
}