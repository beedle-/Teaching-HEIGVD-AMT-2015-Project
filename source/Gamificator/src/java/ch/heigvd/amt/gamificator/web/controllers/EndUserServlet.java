/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamificator.web.controllers;

import ch.heigvd.amt.gamificator.model.entities.Action;
import ch.heigvd.amt.gamificator.model.entities.EndUser;
import ch.heigvd.amt.gamificator.model.entities.Event;
import ch.heigvd.amt.gamificator.model.entities.Trophy;
import ch.heigvd.amt.gamificator.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.gamificator.services.dao.EndUserDAOLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    @EJB
    ApplicationDAOLocal applicationDAO;

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
            //Determining endUser and application
            String apiKey = request.getParameter("apiKey");
            String userIdentifier = request.getParameter("userIdentifier");
            EndUser eu = endUserDAO.findByIdentifier(apiKey, userIdentifier);
            
            //Retrieving user's action
            List<Action> actions = eu.getActions();

            int scoreUser = 0;

            //----------- Determine Score
            // and extract events from all the action the user has made
            List<Event> events = new ArrayList<>();
            for (Action a : actions)
            {
                scoreUser += a.getEvent().getScore();
                events.add(a.getEvent());
            }

            //----------- Determine Trophies
            String trophyResult = "";

            for (Trophy t : applicationDAO.getTrophiesList(apiKey))
            {
                Event eventRequired = null;
                
                //Determine event related to the trophy
                for(Event tempEvent : applicationDAO.findByApiKey(apiKey).getEvents())
                {
                   for(Trophy tempTrophy : tempEvent.getTrophies())
                   {
                       if(tempTrophy.getName().equals(t.getName()))
                           eventRequired = tempEvent;
                   }
                }
                                
                // read the "rule" to know how many events "=" trophy
                int requiredOccurence = t.getOccurenceEvent();
                int effectiveOccurence= 0;

                //Count occurence required event to see if trophy is awarded and how many times
                for(Event e : events)
                {
                    if(e.getName().equals(eventRequired.getName()))
                        effectiveOccurence++;
                }
                
                int numberOfAward =  effectiveOccurence / requiredOccurence;
                   
                trophyResult += " " + t.getName() + " was awarded "+ numberOfAward + " x | ";
            }

            //Transfer information to the JSP
            request.setAttribute("pageTitle", "Hello EndUser");
            request.setAttribute("applicationName", applicationDAO.findByApiKey(apiKey).getName());
            request.setAttribute("userIdentifer", userIdentifier);
            request.setAttribute("scoreUser", scoreUser);
            request.setAttribute("trophyResult", trophyResult);

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
