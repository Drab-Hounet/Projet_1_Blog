/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import com.blog.db.Singleton;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DbUsers extends DAO{

    public DbUsers(Connection connection) {
        super(connection);
    }
    
    @Override
    public String getAllJson() throws ClassNotFoundException, SQLException{
        HashMap<Integer, HashMap<String,String>> list = this.getInDb();
        
        
        
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }


    @Override
    public boolean create(Map element) {
        return true;
    }
        
    public HashMap<Integer, HashMap<String,String>> getInDb() throws ClassNotFoundException, SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT * from users";
        HashMap<Integer, HashMap<String,String>> list = new HashMap<>();
        
        try {
            statement = Singleton.getInstance().createStatement();
            //System.out.println(selectTableSQL);
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                HashMap<String,String> temp = new HashMap<>();
                
                String pseudo = rs.getString("pseudo");
                temp.put("pseudo", pseudo);
                String email = rs.getString("email");
                temp.put("email", email);
                String tagAdmin = rs.getString("tag_admin");
                temp.put("tagAdmin", tagAdmin);
                String createdAt = rs.getString("created_at");
                temp.put("createdAt", createdAt); 
                String password = rs.getString("password");
                temp.put("password", password); 
                list.put(rs.getInt("id"),temp);
            }
            //System.out.println(list);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return list;
    }
}