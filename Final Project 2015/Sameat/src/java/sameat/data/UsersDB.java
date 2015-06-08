
package sameat.data;

import java.sql.*;
import java.util.ArrayList;
import sameat.business.*;

public class UsersDB {
    
    public static int updateData(String uid , String addr , String city , String phone , String email) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
        try {
            cs=connection.prepareCall("{call updateProfile(? , ? , ? , ? , ?)}");
            cs.setString(1, uid);
            cs.setString(2, addr);
            cs.setString(3, city);
            cs.setString(4, phone);
            cs.setString(5, email);
            
            return cs.executeUpdate();
            
        } catch(SQLException ex) {
            System.err.println(ex);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static int setData(User user , String hashp , String salt) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        int result=-1;
        
        try {
            cs=connection.prepareCall("{call newUser(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)}");
            cs.setString(1, user.getUserID());
            cs.setString(2, user.getFirstName());
            cs.setString(3, user.getLastName());
            cs.setInt(4, user.getUGender());
            cs.setString(5, user.getUserBDay());
            cs.setString(6 ,user.getUserAddress());
            cs.setString(7, user.getUserCity());
            cs.setString(8, user.getUserPhone());
            cs.setString(9, user.getUserEmail());
            cs.setString(10, user.getUserName());
            cs.setString(11, hashp);
            cs.setString(12, salt);
            cs.setInt(13, -3);
            cs.registerOutParameter(13, java.sql.Types.INTEGER);
            
            cs.executeUpdate();

            result=cs.getInt(13);
            
            return result;
                
            
        } catch(SQLException ex) {
            System.err.println(ex);
            return result;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
    
    }
    
    public static User getData(String uid , String uname) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        
        try {
            cs=connection.prepareCall("{call getUser(? , ?)}");
            cs.setString(1, uid);
            cs.setString(2, uname);
            rs=cs.executeQuery();
            
            if(rs.next()) {
                
                User user=new User();
                user.setUserID(rs.getString("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setUserGender(rs.getInt("UserGender"));
                user.setUserBDay(rs.getString("UserBirthday"));
                user.setUserAddress(rs.getString("Address"));
                user.setUserCity(rs.getString("City"));
                user.setUserPhone(rs.getString("Phone"));
                user.setUserEmail(rs.getString("Email"));
                user.setUserName(rs.getString("UserName"));
                user.setUserType(rs.getInt("UserType"));
                
                return user;
            }
            else
                return null;
            
        } catch(SQLException ex) {
            
            System.err.println(ex);
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
        
        
    }
    
     public static ArrayList<User> GetAllCustomers() {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<User> customers=new ArrayList<>();

        try {
            cs=connection.prepareCall("{call GetAllCustomers()}");
            rs=cs.executeQuery();
            while(rs.next()) {
                   User c=new User(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4) ,rs.getString(5) ,
                                    rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9) , 
                                    rs.getString(10) , rs.getInt(1));
                   customers.add(c);
                }
                return customers;
            } catch(SQLException ex) {
                System.err.println(ex);
                return null;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(cs);
                pool.freeConnection(connection);
            }
    }  
      
    public static ArrayList<User> GetStrongestCustomers() {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<User> customers=new ArrayList<>();

        
        try {
                cs=connection.prepareCall("{call UsersWhoHaveTheMost()}");
                rs=cs.executeQuery();
                while(rs.next()) {
                       User c=new User(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4) ,rs.getString(5) ,
                                        rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9) , 
                                        rs.getString(10) , rs.getInt(1));
                       customers.add(c);
                    }
                    return customers;
                } catch(SQLException ex) {
                    System.err.println(ex);
                    return null;
                } finally {
                    DBUtil.closeResultSet(rs);
                    DBUtil.closePreparedStatement(cs);
                    pool.freeConnection(connection);
                }
    }       
    
    public static ArrayList<User> GetweakesttCustomers() {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<User> customers=new ArrayList<>();

        
        try {
                cs=connection.prepareCall("{call UsersWhoHaveTheLeast()}");
                rs=cs.executeQuery();
                while(rs.next()) {
                       User c=new User(rs.getString(1) , rs.getString(2) , rs.getString(3) , rs.getInt(4) ,rs.getString(5) ,
                                        rs.getString(6) , rs.getString(7) , rs.getString(8) , rs.getString(9) , 
                                        rs.getString(10) , rs.getInt(1));
                       customers.add(c);
                    }
                    return customers;
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
