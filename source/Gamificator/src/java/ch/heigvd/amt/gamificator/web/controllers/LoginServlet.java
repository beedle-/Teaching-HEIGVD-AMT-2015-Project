/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.gamificator.web.controllers;

import ch.heigvd.amt.gamificator.model.entities.Account;
import ch.heigvd.amt.gamificator.services.dao.AccountDAOLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bastien Rouiller
 */
public class LoginServlet extends HttpServlet
{

    @EJB
    AccountDAOLocal accountDAO;

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
        HttpSession session = request.getSession(false);
        
        if(session != null)
            session.invalidate();
        
        request.getRequestDispatcher("/index.jsp").forward(request,response);
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
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter())
        {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String message;
            boolean success = false;

            //Look if the login information are correct
            Account a = accountDAO.verifyLogin(email, password);

            if (a != null)
            {
                message = "sucessfully connected";
                success = true;
            } else
            {
                message = "Wrong email or password. Please try again!";
            }

            request.setAttribute("success", message);
            request.setAttribute("pageTitle", "Account created");

            if (success)
            {
                request.getSession().setAttribute("connected", email);
                request.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
            } else
            {
                request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
            }
        }
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
    }

}
