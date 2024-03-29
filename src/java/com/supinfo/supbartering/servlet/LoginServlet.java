/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.servlet;

import com.supinfo.supbartering.entity.User;
import com.supinfo.supbartering.form.LoginForm;
import com.supinfo.supbartering.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Laurent
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @EJB
    private UserService userService;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        if ( session.getAttribute("user") == null ) 
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        else
            response.sendRedirect("admin");        
            //this.getServletContext().getRequestDispatcher("/adminManage.jsp").forward(request, response);
        
        //this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
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
        //processRequest(request, response);
        /*
        String usernameLogin = request.getParameter("username");
        String passwordUser = request.getParameter("password");
        
        User user = new User();
        */
        
        LoginForm loginForm = new LoginForm();
        
        User userForm = loginForm.registerUser(request);
        User user = new User();
        if ( userForm.getUserName() != null && userForm.getPassword() != null ) 
           user = userService.getUserConnection(userForm.getUserName(), userForm.getPassword());
        
        try {
            if (user.getId() != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                
                response.sendRedirect(getServletContext().getContextPath() + "/admin");        
            } else {
                String alreadyAdded = "This user doesn't exist !";
                request.setAttribute("userDoesNotExist", alreadyAdded);
                response.sendRedirect(getServletContext().getContextPath() + "/login");        
            }
        } catch (Exception e) {
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
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
