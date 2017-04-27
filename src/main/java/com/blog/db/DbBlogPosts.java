/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import com.blog.attributes.BlogPost;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jerome.lombard
 */
public class DbBlogPosts extends DAO {

    public DbBlogPosts(Connection connection) {
        super(connection);
    }

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    @Override
    public String getAllJson() throws SQLException, ClassNotFoundException {
        Statement statement = null;
        String selectTableSQL = "SELECT * from blogposts";
        HashMap<Integer, HashMap<String,String>> list = new HashMap<>();
        
        try {
            statement = Singleton.getInstance().createStatement();
            System.out.println(selectTableSQL);
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                HashMap<String,String> temp = new HashMap<>();

                String title = rs.getString("title");
                temp.put("titre", title);
                String content = rs.getString("content");
                temp.put("content", content);
                String picture = rs.getString("picture");
                temp.put("picture", picture);
                String createdAt = rs.getString("created_at");
                temp.put("created_at", createdAt);
                String updatedAt = rs.getString("updated_at");
                temp.put("updates_at", updatedAt);
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
    
        public ArrayList<BlogPost> getAllBlogPost() throws ClassNotFoundException, SQLException{
        ArrayList listBlogPost = new ArrayList();
        ResultSet rs = this.getResultSet();
        while (rs.next()) {
            String title = rs.getString("title");
            String content = rs.getString("content");
            String picture = rs.getString("picture");
            String createdAt = rs.getString("created_at");
            String updatedAt = rs.getString("updated_at");
            BlogPost blogPost = new BlogPost(title, content, picture, createdAt, updatedAt);
            listBlogPost.add(blogPost);
        }
        return listBlogPost;
    }

    @Override
    public boolean create(Map element) { 
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        String query =   "INSERT INTO blogposts (title, content, picture, created_at, updated_at, user_id) VALUES(?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, (String) element.get("title"));
            preparedStatement.setString(2, (String) element.get("content"));
            preparedStatement.setString(3, (String) element.get("pictureFile"));
            preparedStatement.setString(4, currentTime);
            preparedStatement.setString(5, currentTime);
            preparedStatement.setString(6, "1");            
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    public ResultSet getResultSet() throws ClassNotFoundException, SQLException{
        Statement statement = null;
        String selectTableSQL = "SELECT * from blogposts";
        
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
