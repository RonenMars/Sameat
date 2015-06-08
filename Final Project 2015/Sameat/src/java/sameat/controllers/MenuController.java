/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import sameat.business.Course;
import sameat.data.CourseDB;


public class MenuController extends HttpServlet {

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
       doPost(request , response);
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
        
        
        if(requestURI.endsWith("/getmenu")) {
           foodMenu(request , response);
        } else if(requestURI.endsWith("/getmenuapp")) {
            foodMenuApp(request , response);
        } else if(request.getParameter("req")!=null) {
            chefCourse(request , response);
        } else if(requestURI.endsWith("/courses")) {            
            AllCourses(request , response);
        }
        else if(requestURI.endsWith("/in-out-course/")) { 
            InOutCourse(request , response);
        }
        
       
    }

    private void foodMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
       
        String url;
        
        if(session==null) {
             url="/foodmenu/index.jsp";
        } else if(session.getAttribute("user")==null)
        {
             url="/foodmenu/index.jsp";
        } else {
             url="/foodmenu/catalog.jsp";
        }
        
        ArrayList<Course> courses=CourseDB.getMenu();       
        
        request.setAttribute("courses", courses);
        this.getServletContext().getRequestDispatcher(url).forward(request, response);   
        
    }

    private void foodMenuApp(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        ArrayList<Course> courses=CourseDB.getMenu();
        
        String menuj=new Gson().toJson(courses);
        
        response.setContentType("application/json");
        PrintWriter out =response.getWriter();
        
        out.print(menuj);
        out.flush();
    }

    private void chefCourse(HttpServletRequest request, HttpServletResponse response) {
        Course c=CourseDB.chefCourse();
        request.setAttribute("ccourse", c);
    }
    
     private void AllCourses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Course> courses=CourseDB.GetAllCourses();       
        
        request.setAttribute("courses", courses);
        this.getServletContext().getRequestDispatcher("/admin/index.jsp").forward(request, response);   
    }    
    
    
    private void InOutCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);
       
        
        int cid=Integer.parseInt(request.getParameter("courseid"));
        
        boolean result = CourseDB.InOutCourse(cid);       

        String site = "http://localhost:8081/Sameat/admin/courses";
        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", site); 
        
    }    


}
