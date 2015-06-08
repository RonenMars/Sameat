/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.controllers;

import com.google.gson.Gson;
import sameat.business.Products;
import sameat.util.ProductsDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sameat.business.*;
import sameat.data.ConnectionPool;
import sameat.data.DBUtil;

/**
 *
 * @author matan_naman
 */
@WebServlet(name = "StorageController", urlPatterns = {"/StorageController"})
public class StorageController extends HttpServlet {

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
         String func=request.getParameter("Functype");
            
        if (func.equals("0")) {
            newIngredient(request, response);
        } else if (func.equals("1")) {
            GetIngredient(request, response);
        }
        else
            UpdateIngredient(request, response);
            

    }

    private void newIngredient(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            String name = request.getParameter("ProductName");
            out = response.getWriter();
            Products product = new Products();
            product.setProductName(request.getParameter("ProductName"));
            product.setPricePer100g(request.getParameter("price1"));
            product.setPricePerUnit((request.getParameter("price2")));
            product.setAmoutOfProduct((request.getParameter("Amount")));
            int result = ProductsDB.insertProduct(product, response);
            if (result == 1) {
                out.print("1");
            } else if (result == 0) {
                out.print("0");
            } else {
                out.print("-1");
            }

        } catch (IOException ex) {
            Logger.getLogger(StorageController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }

    }

    private void GetIngredient(HttpServletRequest request, HttpServletResponse response) {
         PrintWriter out = null;
        try {
            out = response.getWriter();
         
                    
            ProductsDB.GetProduct(response);
        } catch (IOException ex) {
            Logger.getLogger(StorageController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void UpdateIngredient(HttpServletRequest request, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Products product = new Products();
            product.setProductName(request.getParameter("ProductName"));
            product.setPricePer100g(request.getParameter("price1"));
            product.setPricePerUnit((request.getParameter("price2")));
            product.setAmoutOfProduct((request.getParameter("Amount")));
            int result = ProductsDB.UpdateProduct(product, response);
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
}
