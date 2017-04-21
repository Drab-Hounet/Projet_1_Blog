/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

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
    public String getAll() throws SQLException, ClassNotFoundException {
        Statement statement = null;
        String selectTableSQL = "SELECT * from blogposts";
        Hashtable<Integer, Hashtable<String,String>> list = new Hashtable<>();
        
        try {
            statement = Singleton.getInstance().createStatement();
            System.out.println(selectTableSQL);
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                Hashtable<String,String> temp = new Hashtable<>();

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
}
