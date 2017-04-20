/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import java.sql.Connection;

/**
 *
 * @author jerome.lombard
 */
public abstract class DAO<T> {
    protected Connection connection = null;
    
    public DAO(Connection connection){
        this.connection = connection;
    }
    
    public abstract T find();
   
}
