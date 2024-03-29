/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.servlet;

import com.sun.faces.action.RequestMapping;
import com.supinfo.supbartering.entity.Item;
import com.supinfo.supbartering.service.ItemService;
import com.supinfo.supbartering.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@RequestMapping
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

    @EJB
    private ItemService itemService;
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
            out.println("<title>Servlet HomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
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
        if ( session.getAttribute("user") != null ) {
            response.sendRedirect(getServletContext().getContextPath() + "/admin");                    
            return;
        }

        if ( session.getAttribute("user") == null ) {
            //Long numberOfUsers = userService.countNumberOfUser();
            //int numberOfUsers = userService.getAllUsers().size();
            List<Item> allItems = itemService.getAllItems();
            //request.setAttribute("numberOfUsers", numberOfUsers);
            request.setAttribute("items", allItems);
            this.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
        }
        else {
            response.sendRedirect(getServletContext().getContextPath() + "/admin");        
        }
        
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
            throws ServletException, IOException {        //processRequest(request, response);
        String searchLikeThis = request.getParameter("searchLikeThis");
        if (searchLikeThis != null) {
            //List<Item> foundItems = itemService.searchItemByString(searchLikeThis);
            request.setAttribute("search", searchLikeThis);
            response.sendRedirect("search?search="+searchLikeThis);        
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
