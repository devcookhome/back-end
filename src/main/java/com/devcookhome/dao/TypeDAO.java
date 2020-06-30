package com.devcookhome.dao;

import com.devcookhome.model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeDAO{
    private static final String TABLE = "type";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "type";
    private static Connection connection = ConnectionManager.getInstance().getConnection();

    public static Type save(Type type){
         if(type == null) return type;
        
        String sql = "INSERT INTO " + TABLE + "(" + FIELD_NAME + ") VALUES ('"
        + type.getType() + "');";
        try{
               
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            ResultSet result = statement.executeQuery("SELECT LAST_INSERT_ID() AS lastId;");

            while(result.next()) {
                type.setId(result.getLong("lastId"));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return type;
    }   

    public static List<Type> list(){

        String sql = "SELECT * FROM " + TABLE;

        List<Type> types = new ArrayList<Type>();

        PreparedStatement pstm = null;
        ResultSet result = null;

        try {

            pstm = connection.prepareStatement(sql);

            result = pstm.executeQuery();


            while(result.next()){

                Type type = new Type();
                type.setId(result.getLong(FIELD_ID));
                type.setType(result.getString(FIELD_NAME));
                types.add(type);

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

            return types;
        } 
    }

    public static Boolean update(Type type){

        String sql = "UPDATE " + TABLE + " SET " + FIELD_NAME + " = ? WHERE " + FIELD_ID + " = ?";

        PreparedStatement pstm = null;
        
        try {

            pstm = connection.prepareStatement(sql);

            pstm.setString(1, type.getType());
            pstm.setLong(2, type.getId());

            pstm.execute();
            pstm.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Boolean delete(Type type){

        String sql = "DELETE FROM " + TABLE + " WHERE " + FIELD_ID + " = ?";

        PreparedStatement pstm = null;

        try {

            pstm = connection.prepareStatement(sql);

            pstm.setLong(1, type.getId());

            pstm.execute();
            pstm.close();
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}