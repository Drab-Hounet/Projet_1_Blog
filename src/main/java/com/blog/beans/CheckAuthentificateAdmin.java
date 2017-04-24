/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.beans;

import com.blog.db.DbUsers;
import com.blog.db.Singleton;
import java.sql.SQLException;
import java.util.HashMap;


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
    
    public boolean IsItAdmin() throws ClassNotFoundException, SQLException{       
        try { 
            DbUsers getUsers = new DbUsers(Singleton.getInstance());
            HashMap<Integer, HashMap<String,String>> listAllUsers = getUsers.getInDb();
            
            for (HashMap<String, String> listUsers : listAllUsers.values()){
               
            }  
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }   
}
