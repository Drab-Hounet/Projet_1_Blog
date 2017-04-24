/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jerome.lombard
 */
public abstract class DAO<T> {
    protected Connection connection = null;
    
    public DAO(Connection connection){
        this.connection = connection;
    }
    
    public abstract String getAll() throws SQLException, ClassNotFoundException;
    public abstract boolean create(Map<String, String> element);

}
