/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.ArticalTbl;
import entity.LocationTabl;
import entity.UserTbl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.ArticalTblJpaController;
import utils.FileUploadDTO;
import utils.FileUploadUtil;

/**
 *
 * @author Rukesh
 */
@WebServlet(name = "update_articalcontroller", urlPatterns = {"/update_artical"})
@MultipartConfig

public class update_articalcontroller extends HttpServlet {

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
            throws ServletException, IOException, Exception {
       response.setContentType("text/html;charset=UTF-8");
        EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("mero_sahar_emf");
        String servletPath = request.getServletPath();
         String location = "";
        
        switch(servletPath){
            case "/updateartical":
                HttpSession session = request.getSession(false);
                UserTbl loggedInUser = session != null ? (UserTbl) session.getAttribute("loggedInUser") : null;
                ArticalTblJpaController artical = new ArticalTblJpaController(emf);
                ArticalTbl data = new ArticalTbl();

//                 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
//                 LocalDateTime now = LocalDateTime.now();  
//                 
//                  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                FileUploadDTO fileUpload = FileUploadUtil.fileUpload(request, response, "photo");
                String[] tags = request.getParameterValues("tag");
                String taglist ="";
                for(int i=0;i<tags.length; i++)
                {
                    if(i==0)
                    taglist = tags[i];
                    
                    else
                    {
                        taglist = taglist + "," +tags[i];
                    }
                }
                
                UserTbl userid = new UserTbl();
                userid.setId(loggedInUser.getId());
                LocationTabl locid =new LocationTabl();
                locid.setId(new Integer(request.getParameter("address")));
                
                data.setHeading(request.getParameter("heading"));
                data.setSubheading(request.getParameter("subheading"));
                data.setLocationid(locid);
                data.setContent(request.getParameter("content"));
                data.setPhoto(fileUpload.getFileLocation());
                //data.setUserid(new UserTbl(loggedInUser.getId()));
                data.setUserid(userid);
                data.setTags(taglist);
                //System.out.println(taglist);
                //data.setTags(request.getParameter(""));
                data.setType(request.getParameter("type"));
                data.setDate(date);
                artical.edit(data);
                
               
                List<ArticalTbl> articalList=artical.findArticalTblEntities();
                //System.out.println(articalList.toString());
                request.setAttribute("articalList",articalList);
        
                
                location = "/WEB-INF/myartical.jsp";
                break;
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(update_articalcontroller.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(update_articalcontroller.class.getName()).log(Level.SEVERE, null, ex);
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

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String location) throws ServletException, IOException {
        request.getRequestDispatcher(location).forward(request, response);
    }

}
