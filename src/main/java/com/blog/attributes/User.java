/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.attributes;

/**
 *
 * @author jerome.lombard
 */
public class User {
    public String pseudo;
    public String password;
    public String email;
    public String tagAdmin;
    public String createdAt;
    
    public User(String pseudo, String password, String email, String tagAdmin, String createdAt){
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.tagAdmin = tagAdmin;
        this.createdAt = createdAt;
    }
     public User(){
        this.pseudo = null;
        this.password = null;
        this.email = null;
        this.tagAdmin = null;
        this.createdAt = null;
     }

}
