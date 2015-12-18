/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.servlet;

import com.supinfo.supbartering.entity.User;
import com.supinfo.supbartering.form.RegisterForm;
import com.supinfo.supbartering.service.UserService;
import java.io.IOException;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @EJB
    private UserService userService;


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
        HttpSession session = request.getSession();
        if ( session.getAttribute("user") == null ) 
            this.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(request, response);
        else
            response.sendRedirect("admin");        
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
        /*
        User user = new User();
        user.setMailAddress(request.getParameter("mail"));
        user.setUserName(request.getParameter("username"));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setPostalCode(Integer.parseInt(request.getParameter("postalCode")));
        user.setPassword(request.getParameter("password"));
        */
        RegisterForm registerForm = new RegisterForm();
        
        User user = registerForm.registerUser(request);
        
        if ( user.getMailAddress() != null
                && user.getFirstName() != null
                && user.getLastName() != null
                && user.getPostalCode() != null
                && user.getPassword() != null ) {
            
            User userCheck = userService.findUserByUsername(user.getUserName());
            try {
                //userService.findUserByUsername(user.getUserName());
                if( userCheck == null ) {
                    userService.addUser(user);
                    request.setAttribute("form", registerForm);
                    response.sendRedirect(getServletContext().getContextPath() + "/login");
                } else {
                    String alreadyAdded = "This user is already taken !";
                    request.setAttribute("user", alreadyAdded);
                    response.sendRedirect(getServletContext().getContextPath() + "/register");                
                }
            } catch ( Exception e ) {
                response.sendRedirect(getServletContext().getContextPath() + "/register");                
            }
        } else 
            response.sendRedirect(getServletContext().getContextPath() + "/register");
            
    }
}
