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