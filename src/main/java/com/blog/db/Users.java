/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import com.blog.db.Singleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users {
    
    public static void main(String[] argv) throws ClassNotFoundException {

        try {
            selectRecordsFromDbUserTable();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
	}
    }
    public static ArrayList<String> selectRecordsFromDbUserTable() throws SQLException, ClassNotFoundException {
        Statement statement = null;
        String selectTableSQL = "SELECT * from users";
        ArrayList<String> list = new ArrayList();
        
        try {
            statement = Singleton.getInstance().createStatement();
            System.out.println(selectTableSQL);
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                String username = rs.getString("pseudo");
                list.add(username);
                System.out.println("username : " + username);
            }
            System.out.println(list);
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