package com.devcookhome.dao;

import com.devcookhome.model.Group;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


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
}