/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supbartering.servlet;

import com.supinfo.supbartering.entity.Item;
import com.supinfo.supbartering.service.ItemService;
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
@WebServlet(name = "RemoveItem", urlPatterns = {"/admin/delete"})
public class RemoveItemServlet extends HttpServlet {

    @EJB
    private ItemService itemService;
    
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
            out.println("<title>Servlet RemoveItem</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveItem at " + request.getContextPath() + "</h1>");
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
        Long idItem = Long.parseLong(request.getParameter("idItem"));
        Item itemToDelete = itemService.findItemById(idItem);
        request.setAttribute("itemToDelete", itemToDelete);
        this.getServletContext().getRequestDispatcher("/jsp/confirmationDeleteItem.jsp").forward(request, response);
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
        String searchLikeThis = request.getParameter("searchLikeThis");
        if (searchLikeThis != null) {
            //List<Item> foundItems = itemService.searchItemByString(searchLikeThis);
            request.setAttribute("search", searchLikeThis);
            response.sendRedirect(getServletContext().getContextPath() + "/search?search="+searchLikeThis);
            return;
        }
        String sItemToBeDeleted = request.getParameter("itemToDeleteConfirmated");
        if ( sItemToBeDeleted != null ) {
            Long itemToDeleteConfirmated = Long.parseLong(request.getParameter("itemToDeleteConfirmated"));
            if ( itemToDeleteConfirmated != 0 ) {
                Item itemToDelete = itemService.findItemById(itemToDeleteConfirmated);
                itemService.deleteItem(itemToDelete);
            }
        }
        response.sendRedirect(getServletContext().getContextPath() + "/admin");        
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
