
package sameat.util;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import sameat.business.Products;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import sameat.business.*;
import sameat.data.ConnectionPool;
import sameat.data.DBUtil;
import sameat.data.DBUtil;

/**
 *
 * @author matan_naman
 */
public class ProductsDB {
    
    public static int insertProduct(Products product,HttpServletResponse response) throws IOException {
        PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
     
         try {

            cs=connection.prepareCall("{call insertProduct(?,?,?,?)}"); 
            cs.setString(1,product.getProductName());
            cs.setFloat(2, Float.parseFloat(product.getPricePerUnit()));
            cs.setInt(3, Integer.parseInt(product.getAmoutOfProduct()));
            cs.registerOutParameter(4, Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
               
        } catch(SQLException ex) {
             out.print(ex.getMessage());
            System.err.println(ex);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
             
        }
        
    }
     public static void GetProduct(HttpServletResponse response) throws IOException {
        PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
     
         try {
             
            cs=connection.prepareCall("{call GetAllProducts()}");
            rs=cs.executeQuery();
            List <Products> products = new ArrayList<Products>();

             while(rs.next()) {
                
                products.add(new Products(rs.getString("Name"),rs.getString("Price"),rs.getString("Inventory"),rs.getString("IsActive")));
            }
            
             Gson jObj=new Gson();
              
             String jasonObj=jObj.toJson(products);
             out.print(jasonObj);
             
           

             
        } catch(SQLException ex) {
             out.print(ex.getMessage());
            System.err.println(ex);
           
        } finally {
             DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
             
        }
     }
     public static int UpdateProduct(Products product,HttpServletResponse response) throws IOException {
        PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
     
         try {

            cs=connection.prepareCall("{call UpdateProduct(?,?,?,?)}"); 
            cs.setString(1,product.getProductName());
            cs.setFloat(2, Float.parseFloat(product.getPricePerUnit()));
            cs.setInt(3, Integer.parseInt(product.getAmoutOfProduct()));
            cs.registerOutParameter(4, Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(4);
               
        } catch(SQLException ex) {
             out.print(ex.getMessage());
            System.err.println(ex);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
             
        }
        
    }
}

