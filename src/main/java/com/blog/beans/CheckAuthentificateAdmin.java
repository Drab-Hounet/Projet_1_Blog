/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.beans;

import com.blog.attributes.User;
import com.blog.db.DbUsers;
import com.blog.db.Singleton;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author jerome.lombard
 */
public class CheckAuthentificateAdmin {
    private final String login ;
    private final String password;
            
    public CheckAuthentificateAdmin(String login, String password){
        this.login = login;
        this.password = password;
    }
    
    public User IsItAdmin() throws ClassNotFoundException, SQLException{       
        try { 
            DbUsers getUsers = new DbUsers(Singleton.getInstance());
            ArrayList<User> listAllUsers = getUsers.getAllUsers();
            
            for (User user : listAllUsers){
               if((((user.email.equals(this.login)) || (user.pseudo.equals(this.login)))) 
                       && (user.password.equals(this.password)) && (user.tagAdmin.equals("admin"))){
                   return user;
               }
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return new User();
    }   
    
}
