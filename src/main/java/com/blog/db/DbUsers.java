/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import com.blog.attributes.User;
import com.blog.db.Singleton;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DbUsers extends DAO{

    public DbUsers(Connection connection) {
        super(connection);
    }
    
    @Override
    public String getAllJson() throws ClassNotFoundException, SQLException{
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        ResultSet rs = this.getResultSet();
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
                list.add(temp);
            }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
    
    public ArrayList<User> getAllUsers() throws ClassNotFoundException, SQLException{
        ArrayList listUser = new ArrayList();
        ResultSet rs = this.getResultSet();
        while (rs.next()) {
            String pseudo = rs.getString("pseudo");
            String email = rs.getString("email");
            String password = rs.getString("password");
            String tagAdmin = rs.getString("tag_admin");
            String createdAt = rs.getString("created_at");
            User user = new User(pseudo, password, email, tagAdmin, createdAt);
            listUser.add(user);
        }
        return listUser;
    }


    @Override
    public boolean create(Map element) {
        return true;
    }
        
    public ResultSet getResultSet() throws ClassNotFoundException, SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT * from users";
        
        ResultSet rs = null;
        try {
            statement = Singleton.getInstance().createStatement();
            //System.out.println(selectTableSQL);
            // execute select SQL stetement
            rs = statement.executeQuery(selectTableSQL);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        return rs;
    }
    
    
}