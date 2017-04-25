/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.admin;

import com.blog.attributes.User;
import com.blog.beans.CheckAuthentificateAdmin;
import com.blog.db.DbUsers;
import com.blog.db.Singleton;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jerome.lombard
 */
@WebServlet(name = "HomeAdmin", urlPatterns = {"/HomeAdmin"})
public class HomeAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        this.getServletContext().getRequestDispatcher("/adminHome.jsp").forward(request, response); 
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CheckAuthentificateAdmin checkAuthentificateAdmin = new CheckAuthentificateAdmin(
                request.getParameter("login"),
                request.getParameter("password"));
        
        User adminConnected = null;
        
        try {
            adminConnected = checkAuthentificateAdmin.IsItAdmin();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(HomeAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (adminConnected.pseudo != null){
            String stateConnected = "";
            String displayMessageSucces = "hidden";
            String displayMessageFail = "hidden";
            request.setAttribute("stateConnected", stateConnected);
            request.setAttribute("displayAlertSuccess", displayMessageSucces);
            request.setAttribute("displayAlertFail", displayMessageFail);
            request.setAttribute("adminConnected", adminConnected.pseudo);
            this.getServletContext().getRequestDispatcher("/adminEditPost.jsp").forward(request, response); 
        }else{
            String stateErrorLogin = "";
            request.setAttribute("stateErrorLogin", stateErrorLogin);
            request.setAttribute("adminConnected", adminConnected.pseudo);
            this.getServletContext().getRequestDispatcher("/adminHome.jsp").forward(request, response); 
        }       
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
