/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.api;

import com.blog.db.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author jerome.lombard
 */
@WebServlet(name = "ApiTest", urlPatterns = {"/ApiTest"})
public class GetAllUsers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //this.getServletContext().getRequestDispatcher("/bobo.jsp").forward(request, response);
        //String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        ArrayList<String> days = new ArrayList();
        try {
            days = Users.selectRecordsFromDbUserTable();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        // Create a new instance of Gson
        Gson gson = new Gson();
        String daysJson = gson.toJson(days);
        PrintWriter out = response.getWriter();
        out.print(daysJson);
    }


}
