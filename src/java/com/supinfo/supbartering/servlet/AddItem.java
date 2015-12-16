/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.servlet;

import com.supinfo.supbartering.entity.Item;
import com.supinfo.supbartering.entity.User;
import com.supinfo.supbartering.service.ItemService;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Laurent
 */
@WebServlet(name = "AddObject", urlPatterns = {"/admin/add-object"})
public class AddItem extends HttpServlet {

    @EJB
    private ItemService objectService;
    
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
            out.println("<title>Servlet AddObject</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddObject at " + request.getContextPath() + "</h1>");
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
        /*
        HttpSession session = request.getSession();
        if ( session.getAttribute("user") == null ) 
            this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        else
            this.getServletContext().getRequestDispatcher("/jsp/addObject.jsp").forward(request, response);
        */
        this.getServletContext().getRequestDispatcher("/jsp/addObject.jsp").forward(request, response);
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
        String nameObject = request.getParameter("name");
        String descriptionObject = request.getParameter("description");
        float priceObject = Float.parseFloat(request.getParameter("price"));
        String typeObject = request.getParameter("type");
        String pictureObject = request.getParameter("picturePath");
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        /*
        Boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if ( isMultipart ) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(4 * 1024);
            factory.setRepository(new File("\tmp"));
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(50 * 1024);
            
        }
        */
        
        if ( nameObject != null 
                && descriptionObject != null 
                && typeObject != null
                && pictureObject != null ) {
            Item object = new Item();
            object.setName(nameObject);
            object.setDescription(descriptionObject);
            object.setPrice(priceObject);
            object.setType(typeObject);
            object.setPicturePath(pictureObject);
            object.setIdCreator(user.getId());
            object.setDateCreation(dateFormat.format(date));
            
            objectService.addObject(object);
            
            response.sendRedirect(getServletContext().getContextPath() + "/admin");        
        } else {
            response.sendRedirect(getServletContext().getContextPath() + "/admin/add-object");        
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
