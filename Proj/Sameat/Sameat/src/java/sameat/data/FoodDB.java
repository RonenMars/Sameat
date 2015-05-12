/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.data;
import java.sql.*;
import sameat.business.*;
/**
 *
 * @author userty5
 */
public class FoodDB {


    public static User getData(String[] data) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        String query="GetFoodMenu()";
        try {
            
            ps=connection.prepareStatement(query);
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
}
