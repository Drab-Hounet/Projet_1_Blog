/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.blog.beans.SaveBlogPosts;

/**
 *
 * @author jerome.lombard
 */
@WebServlet(name = "EditPostBlog", urlPatterns = {"/EditPostBlog"})
public class EditPostBlog extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");        
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
        String displayMessageSucces = "hidden";
        String displayMessageFail = "hidden";
        request.setAttribute("displayAlertSuccess", displayMessageSucces);
        request.setAttribute("displayAlertFail", displayMessageFail);

        this.getServletContext().getRequestDispatcher("/adminEditPost.jsp").forward(request, response); 
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
        String displayMessageSucces = "hidden";
        String displayMessageFail = "hidden";

        if( request.getParameter("save") != null){
            SaveBlogPosts saveBlogPosts = new SaveBlogPosts(request.getParameter("title"), request.getParameter("content"), request.getParameter("pictureFile"));

            boolean successSaving = saveBlogPosts.createPost();
            
            if (successSaving){
                displayMessageSucces = "";
                displayMessageFail = "hidden";
                request.setAttribute("displayAlertSuccess", displayMessageSucces);
                request.setAttribute("displayAlertFail", displayMessageFail);
            }else{
                displayMessageSucces = "hidden";
                displayMessageFail = "";
                request.setAttribute("displayAlertSuccess", displayMessageSucces);
                request.setAttribute("displayAlertFail", displayMessageFail);
            }
            this.getServletContext().getRequestDispatcher("/adminEditPost.jsp").forward(request, response); 
        }
        if( request.getParameter("cancel") != null){
            request.setAttribute("displayAlertSuccess", displayMessageSucces);
            request.setAttribute("displayAlertFail", displayMessageFail);
            this.getServletContext().getRequestDispatcher("/adminEditPost.jsp").forward(request, response); 
        }
        
        
        
        //String title = request.getParameter("save");
        //PrintWriter out = response.getWriter();
        //out.print(title);
        
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
