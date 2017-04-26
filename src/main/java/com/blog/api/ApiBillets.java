/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.api;

import com.blog.db.DbBlogPosts;
import com.blog.db.Singleton;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author rital
 */
@WebServlet(name = "ApiTest", urlPatterns = {"/ApiTest"})
public class ApiBillets extends HttpServlet{
        
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
        String listBlogPost = null;
        DbBlogPosts blogPost = null;
        try {
            blogPost = new DbBlogPosts(Singleton.getInstance());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ApiBillets.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listBlogPost = blogPost.getAllJson();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
        }
        // Create a new instance of Gson

        PrintWriter out = response.getWriter();
        out.print(listBlogPost);
    }

}
