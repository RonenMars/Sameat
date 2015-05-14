/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sameat.util.CheckData;
/**
 *
 * @author plotk_000
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    CheckData checkobj=new CheckData();
    /**
     * 
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
       
        
        String type=request.getParameter("reqType");
        
        if(type.equals("0")) {
            NewUser(request , response);
        }
        
    }

    private void NewUser(HttpServletRequest request , HttpServletResponse response) {
        
        String fname=request.getParameter("FirstName");
        String lname=request.getParameter("LastName");
        String id=request.getParameter("ID");
        String gender=request.getParameter("gender");
        String bday=request.getParameter("bday");
        String add=request.getParameter("Addresss");
        String city=request.getParameter("City");
        String phone=request.getParameter("Phone");
        String email=request.getParameter("Email");
        String usern=request.getParameter("UserName");
        String password=request.getParameter("Password");
        
        
        
    }


}
