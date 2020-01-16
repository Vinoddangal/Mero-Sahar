/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.LocationTabl;
import entity.UserTbl;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LocationTablJpaController;
import service.UserTblJpaController;

/**
 *
 * @author Rukesh
 */
@WebServlet(name = "SignupController", urlPatterns = {"/signup","/register"})
public class SignupController extends HttpServlet {

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
        EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("mero_sahar_emf");
        String servletPath = request.getServletPath();
         String location = "";
        //String dispatchString = "";
        switch(servletPath){
            case "/signup":
                LocationTablJpaController loc =new LocationTablJpaController(emf);
                List<LocationTabl> locs= loc.findLocationTablEntities();
                request.setAttribute("locs", locs);
                location = "/WEB-INF/signup.jsp";             
                break;
            case "/register":
                //insert data to database
                UserTblJpaController user=new UserTblJpaController(emf);
                UserTbl data=new UserTbl();
                data.setFirstname(request.getParameter("firstname"));
                data.setLastname(request.getParameter("lastname"));
                data.setLocationid(new Integer(request.getParameter("address")));
                data.setContact(new Long(request.getParameter("contact")));
                data.setEmail(request.getParameter("email"));
                data.setPassword(request.getParameter("password"));
                
                user.create(data);
                location = "/login.jsp";
                break;
            default:
                location = "/login.jsp";
                
        }
       
        dispatchRequest(request, response, location);
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
            throws ServletException, IOException {
        processRequest(request, response);     
   
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

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
        request.getRequestDispatcher(location).forward(request, response);
    }

    
   
}
