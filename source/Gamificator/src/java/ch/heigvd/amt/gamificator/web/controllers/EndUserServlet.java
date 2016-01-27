/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamificator.web.controllers;

import ch.heigvd.amt.gamificator.model.entities.EndUser;
import ch.heigvd.amt.gamificator.model.entities.Event;
import ch.heigvd.amt.gamificator.services.dao.EndUserDAOLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bastien Rouiller
 */
public class EndUserServlet extends HttpServlet
{
    @EJB
    EndUserDAOLocal endUserDAO;   
    
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
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            String apiKey = request.getParameter("apiKey");
            String userIdentifier = request.getParameter("userIdentifier");
            
            EndUser eu = endUserDAO.findByIdentifier(apiKey, userIdentifier);
            List<Event> events = eu.getEvents();
            
            int scoreUser = 0;
            
            for(Event e : events)
            {
                scoreUser += e.getScore();
            }
            
            request.setAttribute("pageTitle", "Hello EndUser");
            request.setAttribute("apiKey", apiKey);
            request.setAttribute("userIdentifer", userIdentifier);
            request.setAttribute("scoreUser", scoreUser);
            
            request.getRequestDispatcher("/WEB-INF/pages/endUser.jsp").forward(request, response);
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
            throws ServletException, IOException
    {
        processRequest(request, response);
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
