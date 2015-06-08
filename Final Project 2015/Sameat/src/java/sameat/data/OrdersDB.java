/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.data;


import java.sql.*;
import java.util.ArrayList;
import sameat.business.*;

public class OrdersDB {
    
    public static int rateOrderCourse(int ordid , int cid , int rating) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
        try {
            
            cs=connection.prepareCall("{call rateOrderCourse(? , ? , ?)}");
            cs.setInt(1, ordid);
            cs.setInt(2, cid);
            cs.setInt(3, rating);
            
            return cs.executeUpdate();
        } catch(SQLException ex) {
            System.err.println(ex);
           return -1;
        } finally {
           DBUtil.closePreparedStatement(cs);
           pool.freeConnection(connection);
        }

    }
    public static ArrayList<Order> getOrdersHistory(String custid) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<Order> orders=new ArrayList<>();
        
        try {
            cs=connection.prepareCall("{call getOrdersHistory(?)}");
            cs.setString(1, custid);
            rs=cs.executeQuery();
            
            while(rs.next()) {
                
                if(orders.isEmpty() || !orderExist(orders , rs.getInt(1))) {
                    
                    Order ord=new Order();
                    ord.setId(rs.getInt(1));
                    ord.setCustomerId(rs.getString(2));
                    ord.setOrderDate(rs.getString(3));
                    ord.setPrice(rs.getFloat(4));
                    ord.setIsRated(rs.getInt(5));
                    
                    //Add Course to Order 
                    
                    Course c=new Course();
                    c.setId(rs.getInt(7));
                    c.setName(rs.getString(8));
                    c.setDesc(rs.getString(9));
                    c.setPrice(rs.getFloat(10));
                    c.setRating(rs.getInt(11));
                    
                    Item item=new Item();
                    item.setQuantity(rs.getInt(6));
                    item.setCourse(c);
                    
                    ord.addItem(item);
                    
                    orders.add(ord);
                    
                } else {
                    for( Order ord : orders) {
                        if(ord.getId()==rs.getInt(1)) {
                            Course c=new Course();
                            c.setId(rs.getInt(7));
                            c.setName(rs.getString(8));
                            c.setDesc(rs.getString(9));
                            c.setPrice(rs.getFloat(10));
                             c.setRating(rs.getInt(11));
                    
                            Item item=new Item();
                            item.setQuantity(rs.getInt(6));
                            item.setCourse(c);
                    
                            ord.addItem(item);
                            
                        }
                    }
                }
                
                
            }
            return orders;
            
        } catch(SQLException ex) {
            System.err.println(ex);
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static int updateStock(int ingid , int amount) {
         
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
        try {
            cs=connection.prepareCall("{call updateStock(? , ?)}");
            cs.setInt(1, ingid);
            cs.setInt(2, amount);
            
            return cs.executeUpdate();
            
        } catch(SQLException ex) {
           System.err.println(ex);
           return -1;
        } finally {
           DBUtil.closePreparedStatement(cs);
           pool.freeConnection(connection);
        }
    }
    public static int addCoursesToOrder(int ordid , int cid) {

        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
        try {
            cs=connection.prepareCall("{call addCourseToOrder(? , ?)}");
            cs.setInt(1, ordid);
            cs.setInt(2, cid);
            
            return cs.executeUpdate();
           
        } catch(SQLException ex) {
           System.err.println(ex);
           return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
    }
    public static int addOrder(String uid , String odate , float oprice) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
        try {
            cs=connection.prepareCall("{call addOrder(? , ? , ? ,?)}");
            cs.setString(1 , uid);
            cs.setString(2, odate);
            cs.setFloat(3 , oprice);
            cs.registerOutParameter(4, java.sql.Types.INTEGER);
            
            cs.executeUpdate();
            
            return cs.getInt(4);
            
        } catch(SQLException ex) {
            System.err.println(ex);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
    }

    private static boolean orderExist(ArrayList<Order> orders, int ordID) {
       for(Order ord : orders) {
           if(ord.getId()==ordID) {
               return true;
           }   
       }
       return false;
    }
}
