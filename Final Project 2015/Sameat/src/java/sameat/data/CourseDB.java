
package sameat.data;

import java.sql.*;
import java.util.ArrayList;
import sameat.business.*;

public class CourseDB {
    
    public static Course chefCourse() {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        
        try {
            cs=connection.prepareCall("{call chefCourse()}");
            rs=cs.executeQuery();
            Course c=null;
            if(rs.next()) {
                c=new Course();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                c.setDesc(rs.getString(3));
                c.setPrice(rs.getFloat(4));
                c.setRating(rs.getInt(5));
            }
            return c;

        } catch(SQLException ex) {
            System.err.println(ex);
            return null;
        } finally { 
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
        
        
    }
    public static Course getCourse(int cid) {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        
        try {
            cs=connection.prepareCall("{call getCourse(?)}");
            cs.setInt(1, cid);
            rs=cs.executeQuery();
            Course c=null;
            if(rs.next())
            {
                c=new Course();
                c.setId(cid);
                c.setName(rs.getString(2));
                c.setDesc(rs.getString(3));
                c.setPrice(rs.getFloat(4));
                
            }
            return c;
        } catch(SQLException ex) {
            System.err.println(ex);
            return null;
        } finally { 
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
        
    }
    
    public static ArrayList<Course> getMenu() {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<Course> courses=new ArrayList<>();

        try {
            cs=connection.prepareCall("{call getMenu()}");
            rs=cs.executeQuery();
            while(rs.next()) {
                   Course c=new Course();
                   c.setId(rs.getInt(1));
                   c.setName(rs.getString(2));
                   c.setDesc(rs.getString(3));
                   c.setPrice(rs.getFloat(4));
                   c.setIsActive(rs.getBoolean(5));
                   c.setisInMenu(rs.getBoolean(6));
                   courses.add(c);
                }
                return courses;
            } catch(SQLException ex) {
                System.err.println(ex);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(cs);
                pool.freeConnection(connection);
            }
    }
    
    public static ArrayList<Course> GetAllCourses() {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<Course> courses=new ArrayList<>();

        try {
            cs=connection.prepareCall("{call GetAllCourses()}");
            rs=cs.executeQuery();
            while(rs.next()) {
                   Course c=new Course(rs.getInt(1),rs.getString(2),rs.getString(3),
                                            rs.getFloat(4),rs.getBoolean(6),rs.getBoolean(5)); 
                   courses.add(c);
                }
                return courses;
            } catch(SQLException ex) {
                System.err.println(ex);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(cs);
                pool.freeConnection(connection);
            }
    }   
    
    
   
    public static boolean InOutCourse(int courseID) 
    {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;

        try {
            cs=connection.prepareCall("{call InOutCourseMenu(?)}");
            cs.setInt(1, courseID);
            rs=cs.executeQuery();
            return true;

            } catch(SQLException ex) {
                System.err.println(ex);
                return false;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(cs);
                pool.freeConnection(connection);
            }
    }  
    

      
    public static ArrayList<Course> GetMostPopularCourses() {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<Course> courses=new ArrayList<>();

        try {
            cs=connection.prepareCall("{call GetMostOrderedCourses()}");
            rs=cs.executeQuery();
            while(rs.next()) {
                   Course c=new Course(rs.getInt(1),rs.getString(2),rs.getString(3),
                                            rs.getFloat(4),rs.getBoolean(6),rs.getBoolean(5)); 
                   courses.add(c);
                }
                return courses;
            } catch(SQLException ex) {
                System.err.println(ex);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(cs);
                pool.freeConnection(connection);
            }
    }       

}
