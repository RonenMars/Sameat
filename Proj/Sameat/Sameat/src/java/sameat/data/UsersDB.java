package sameat.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sameat.business.*;

public class UsersDB {
    
    public static User getData(String[] data) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        String query="SELECT * FROM Users "
                +"WHERE UserID = ? AND UserName=?";
        try {
            
            ps=connection.prepareStatement(query);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            rs=ps.executeQuery();
            if(rs.next()) {
                
                User user=new User();
                user.setUserID(rs.getString("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setUserGender(rs.getInt("UserGender"));
                user.setUserBDay(rs.getDate("UserBirthday"));
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
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        
        
    }
    
    public static List<User> getListAllUsers() {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<User> userList= new ArrayList();

        
        String query="{call GetAllUsers()}";
        try {
            
            ps=connection.prepareStatement(query);

            rs=ps.executeQuery();

            while (rs.next()) {
                User user=new User();
                user.setUserID(rs.getString("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setUserGender(rs.getInt("UserGender"));
                user.setUserBDay(rs.getDate("UserBirthday"));
                user.setUserAddress(rs.getString("Address"));
                user.setUserCity(rs.getString("City"));
                user.setUserPhone(rs.getString("Phone"));
                user.setUserEmail(rs.getString("Email"));
                user.setUserName(rs.getString("UserName"));
                user.setUserType(rs.getInt("UserType"));
                
                userList.add(user);
            }
            return userList;
            
        } catch(SQLException ex) {
            
            System.err.println(ex);
            return null;
            
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}

