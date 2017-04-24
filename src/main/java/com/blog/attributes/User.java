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
    public String name;
    public String password;
    public String email;
    public String tagAdmin;
    public String createdAt;
    
    public User(String name, String password, String email, String tagAdmin, String createdAt){
        this.name = name;
        this.password = password;
        this.email = email;
        this.tagAdmin = tagAdmin;
        this.createdAt = createdAt;
    }

}
