/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.db;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

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

}
