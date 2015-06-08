/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.data;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import sameat.business.CourseSa;
import sameat.data.ConnectionPool;
import sameat.data.DBUtil;

/**
 *
 * @author liron
 */
public class CourseSDB {
    
   
    public static void GetCourse(HttpServletResponse response)throws IOException 
    {
        PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        
         try {
             
            cs=connection.prepareCall("{call GetAllCourses ()}");
            rs=cs.executeQuery();
            List <CourseSa> courses = new ArrayList<>();

             while(rs.next()) {
                
                courses.add(new CourseSa(rs.getString("Name"),rs.getString("Description"),Float.parseFloat(rs.getString("Price")) ,rs.getString("IsInMenu")));
            }
            
             Gson jObj=new Gson();
              
             String jasonObj=jObj.toJson(courses);
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
    public static int UpdateCourse(CourseSa course,HttpServletResponse response)throws IOException 
    {
         PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
         try {

            cs=connection.prepareCall("{call updateCourse(?,?,?,?,?)}"); 
            cs.setString(1, course.getcName());
            cs.setString(2,course.getcDescription());
            cs.setFloat(3, course.getcPrice());
            int x = Integer.parseInt(course.getcIsInMenu());
            cs.setInt(4,x);
            cs.registerOutParameter(5, Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(5);
               
        } catch(SQLException ex) {
             out.print(ex.getMessage());
            System.err.println(ex);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
             
        }
    }
    
    
   public static int AddIngredientsToCourse(String courseName,String IngredientName,int Amount,HttpServletResponse response)throws IOException
   {
        PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
         try {
         cs=connection.prepareCall("{call AddCourses2Products(?,?,?,?)}"); 
            cs.setString(1,courseName);
            cs.setString(2,IngredientName);
            cs.setInt(3,Amount);
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
   
   public static int AddCourse(CourseSa course,HttpServletResponse response)throws IOException
   {
         PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
         try {

            cs=connection.prepareCall("{call insertCourse(?,?,?,?,?)}"); 
            cs.setString(1, course.getcName());
            cs.setString(2,course.getcDescription());
            cs.setFloat(3, course.getcPrice());
            int x = Integer.parseInt(course.getcIsInMenu());
            cs.setInt(4,x);
            cs.registerOutParameter(5, Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(5);
               
        } catch(SQLException ex) {
             out.print(ex.getMessage());
            System.err.println(ex);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
             
        }
   }
   
  public static int DeleteCourse(String cname,HttpServletResponse response)throws IOException
  {
         PrintWriter out = null;
        out = response.getWriter();
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
         try {

            cs=connection.prepareCall("{call delete_course(?,?)}"); 
            cs.setString(1, cname);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.executeUpdate();
            return cs.getInt(2);
               
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
