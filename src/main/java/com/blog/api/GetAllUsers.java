/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.api;

import com.blog.db.DbBlogPosts;
import com.blog.db.Singleton;
import com.blog.db.DbUsers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerome.lombard
 */
@WebServlet(name = "ApiTest", urlPatterns = {"/ApiTest"})
public class GetAllUsers extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listUsers = null;
        DbUsers user = null;
        try {
            user = new DbUsers(Singleton.getInstance());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetAllUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listUsers = user.getAllJson();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        // Create a new instance of Gson

        PrintWriter out = response.getWriter();
        out.print(listUsers);
    }


}
