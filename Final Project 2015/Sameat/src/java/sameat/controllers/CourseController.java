/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sameat.business.CourseSa;
import sameat.data.CourseSDB;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import sameat.business.Product;


/**
 *
 * @author liron
 */
@WebServlet(name = "CourseController", urlPatterns = {"/CourseController"})
public class CourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        
        
        PrintWriter out = null;
        out = response.getWriter();
        String Functype = request.getParameter("Functype");
     
        if(Functype.equals("4"))
        {
            GetCourse(request, response);
        } else if(Functype.equals("2"))
        {
             UpdateCourse(request, response);
        }else if(Functype.equals("5"))
        {
            AddIngredientsToCourse(request, response);
        }else if(Functype.equals("0"))
        {
            AddCourse(request, response);
        }else if(Functype.equals("1"))
        {
           DeleteCourse(request, response);
        }
        
        
        
    }
    private void AddCourse(HttpServletRequest request, HttpServletResponse response)
    {
                PrintWriter out = null;
        try {
            out = response.getWriter();
            CourseSa courseTOupdate = new CourseSa();
            courseTOupdate.setcName(request.getParameter("NewCourseName"));
            courseTOupdate.setcDescription(request.getParameter("description"));
            courseTOupdate.setcPrice(Float.parseFloat(request.getParameter("price")));
            courseTOupdate.setcIsInMenu(request.getParameter("IsInMenu"));
            int result = CourseSDB.AddCourse(courseTOupdate,response);
            
            JSONArray jsonArray = new JSONArray(request.getParameter("Ingredients"));
            List <Product> ProductsToNewCourse = new ArrayList<>();
            
            for(int i=0;i<jsonArray.length();i++){
                  JSONObject jsonObject=(JSONObject) jsonArray.get(i);
                  ProductsToNewCourse.add(new Product(jsonObject.getString("ProductName"),jsonObject.getInt("AmoutOfProduct")));
              }
           
            int result2 = 0 ;
            for(int i = 0; i < ProductsToNewCourse.size() ; i++ ){
                result2 =  CourseSDB.AddIngredientsToCourse(courseTOupdate.getcName(),ProductsToNewCourse.get(i).getProductName(),ProductsToNewCourse.get(i).getAmoutOfProduct(),response);
                if(result2 == 0)
                    break;
            }
            
            
            if (result == 1 && result2 ==1 ) {
                out.print("1");
            } else if (result == 0 || result2 == 0 ) {
                out.print("0");
            } else {
                out.print("-1");
            }
    }
           catch (IOException ex) {
            Logger.getLogger(StorageController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
    
    private void AddIngredientsToCourse(HttpServletRequest request, HttpServletResponse response)
    {
         PrintWriter out = null;
        try {
            out = response.getWriter();
            String courseName = request.getParameter("CourseName");
            String IngredientName = request.getParameter("Ingredient");
            int Amount =Integer.parseInt(request.getParameter("Amount"));
            int result = CourseSDB.AddIngredientsToCourse(courseName,IngredientName,Amount,response);
            if (result == 1) {
                 out.print("1");
            } else if (result == 0) {
                 out.print("0");
            } else {
                 out.print("-1");
            }
         } catch (IOException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            out.close();
        }
        
    }
    
    private void GetCourse(HttpServletRequest request, HttpServletResponse response)
    {
         PrintWriter out = null;
        try {
            out = response.getWriter();
            CourseSDB.GetCourse(response);
          
         } catch (IOException ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void UpdateCourse(HttpServletRequest request, HttpServletResponse response)
    {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            CourseSa courseTOupdate = new CourseSa();
            courseTOupdate.setcName(request.getParameter("NewCourseName"));
            courseTOupdate.setcDescription(request.getParameter("description"));
            courseTOupdate.setcPrice(Float.parseFloat(request.getParameter("price")));
            courseTOupdate.setcIsInMenu(request.getParameter("IsInMenu"));
            int result = CourseSDB.UpdateCourse(courseTOupdate,response);
            if (result == 1) {
                out.print("1");
            } else if (result == 0) {
                out.print("0");
            } else {
                out.print("-1");
            }
    }
           catch (IOException ex) {
            Logger.getLogger(StorageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
    
    private void DeleteCourse(HttpServletRequest request, HttpServletResponse response)
    {
         PrintWriter out = null;
        try {
            out = response.getWriter();
            String cname = request.getParameter("CourseName");
            int result = CourseSDB.DeleteCourse(cname,response);
            if (result == 1) {
                out.print("1");
            } else if (result == 0) {
                out.print("0");
            } else {
                out.print("-1");
            }
    }
           catch (IOException ex) {
            Logger.getLogger(StorageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
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
