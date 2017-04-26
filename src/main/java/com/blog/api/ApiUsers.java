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
import static javax.ws.rs.HttpMethod.*;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.*;

/**
 *
 * @author jerome.lombard
 */
@WebServlet(name = "ApiTest", urlPatterns = {"/ApiTest"})
public class ApiUsers extends HttpServlet {
    
    @OPTIONS
    @Path("/api/user")
    public Response getOptions() {
        return Response.ok()
        .header("Access-Control-Allow-Origin", "*")
        .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
        .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
  }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listUsers = null;
        DbUsers user = null;
        try {
            user = new DbUsers(Singleton.getInstance());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApiUsers.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String data = request.getParameter("data");
        PrintWriter out = response.getWriter();
        out.print(data);
        
    }


}
