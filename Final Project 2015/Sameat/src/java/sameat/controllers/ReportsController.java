/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sameat.business.Course;
import sameat.business.User;
import sameat.data.CourseDB;
import sameat.data.ReportsDB;
import sameat.data.UsersDB;


/**
 *
 * @author userty5
 */
public class ReportsController extends HttpServlet {

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
            out.println("<title>Servlet ReportsController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReportsController at " + request.getContextPath() + "</h1>");
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
              doPost(request , response); //New
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
        
         String requestURI = request.getRequestURI();
        
         if(requestURI.endsWith("/balance")) {
            Balance(request , response);
        } else if(requestURI.endsWith("/popular-courses")) {
           GetPopCourses(request , response);
        }  else if(requestURI.endsWith("/strong-customers")) {
           GetStrongestCustomers(request , response);
        } else if(requestURI.endsWith("/weakest-customers")) {
           GetWeakestCustomers(request , response);
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

    private void Balance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
       
        String url;
        
        if(session==null) {
            url="/admin/index.jsp"; //TODO
        } else if(session.getAttribute("user")==null)
        {
            url="/admin/index.jsp";
        } else {
             url="/index.jsp";
        }
        
        float Balance = ReportsDB.GetBalance();
               
        request.setAttribute("balance", Balance);
        
        this.getServletContext().getRequestDispatcher(url).forward(request, response); 
        
    }
    
    private void GetPopCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
       
        String url;
        
        if(session==null) {
            url="/admin/index.jsp"; //TODO
        } else if(session.getAttribute("user")==null)
        {
            url="/admin/index.jsp";
        } else {
             url="/index.jsp";
        }
        
        ArrayList<Course> popCourses = CourseDB.GetMostPopularCourses();
               
        request.setAttribute("popCourses", popCourses);        
        this.getServletContext().getRequestDispatcher(url).forward(request, response); 
        
    }
    
   
    private void GetStrongestCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
       
        String url;
        
        if(session==null) {
            url="/admin/index.jsp"; //TODO
        } else if(session.getAttribute("user")==null)
        {
            url="/admin/index.jsp";
        } else {
             url="/index.jsp";
        }
        
        ArrayList<User> strongCustomers = UsersDB.GetStrongestCustomers();
               
        request.setAttribute("strongCustomers", strongCustomers);        
        this.getServletContext().getRequestDispatcher(url).forward(request, response); 
        
    }    

    private void GetWeakestCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
                
        HttpSession session=request.getSession(false);
       
        String url;
        
        if(session==null) {
            url="/admin/index.jsp"; //TODO
        } else if(session.getAttribute("user")==null)
        {
            url="/admin/index.jsp";
        } else {
             url="/index.jsp";
        }
        
        ArrayList<User> weakestCustomers = UsersDB.GetStrongestCustomers();
               
        request.setAttribute("weakestCustomers", weakestCustomers);        
        this.getServletContext().getRequestDispatcher(url).forward(request, response); 
    }

}
