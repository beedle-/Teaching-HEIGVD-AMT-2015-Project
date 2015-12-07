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

/**
 *
 * @author Bastien Rouiller
 */
public class AccountServlet extends HttpServlet
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
            if(request.getSession().getAttribute("connected") == null)
            {
                request.setAttribute("pageTitle", "Registration");
                request.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(request, response);
            }
            else
            {
                Account myAccount = accountDAO.findByEmail((String) request.getSession().getAttribute("connected"));

                request.setAttribute("email", myAccount.getEmail());
                request.setAttribute("firstName", myAccount.getFirstName());
                request.setAttribute("lastName", myAccount.getLastName());

                request.setAttribute("pageTitle", "Edit your account details");
                request.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(request, response);
            }
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
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter())
        {            
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String password = request.getParameter("password");
            String confirmPwd = request.getParameter("confirmPwd");
            String message;     
            boolean success = false;
            boolean connected = request.getSession().getAttribute("connected") == null;
            
            /*
            request.setAttribute("email", email);
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("password", password);
            request.setAttribute("confirmPwd", confirmPwd);
            */
            
            String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
            
            if(!password.equals(confirmPwd))
            {
                message = "Password confirmation doesn't match";
            }
            else if(!password.matches(pattern))
            {
                message = "Password must contains at least 8 character, one lower case, one uppercase and one digit";
            }
            else
            {
                if(connected)
                {
                    //Look if the account already exist
                    Account a = accountDAO.findByEmail(email);

                    if(a == null)
                    {
                        accountDAO.create(new Account(email, firstName, lastName, password));
                        message = "Congratulations " + firstName + " " + lastName 
                                + ". You have succesfully created an account. You can now login.";
                        success = true;
                    }
                    else
                    {
                        message = "Sorry, there is already an account linked to this email";
                    }
                }
                else
                {
                    accountDAO.update(null);
                    //update account
                    message = "You information have been updated.";
                }
            }
           
            request.setAttribute("success", message);
            request.setAttribute("pageTitle", "Gamificator");
            
            if(success)
                request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
            else
                request.getRequestDispatcher("/WEB-INF/pages/account.jsp").forward(request, response);
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
