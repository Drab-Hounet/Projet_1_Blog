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
import java.util.ArrayList;
import java.util.Hashtable;

public class DbUsers extends DAO{

    public DbUsers(Connection connection) {
        super(connection);
    }
    
    @Override
    public String getAll() throws ClassNotFoundException, SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT * from users";
        Hashtable<Integer, Hashtable<String,String>> list = new Hashtable<>();
        
        try {
            statement = Singleton.getInstance().createStatement();
            System.out.println(selectTableSQL);
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                Hashtable<String,String> temp = new Hashtable<>();
                
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
            System.out.println(list);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }
}