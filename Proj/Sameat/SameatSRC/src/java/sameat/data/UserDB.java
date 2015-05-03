
package sameat.data;

import java.sql.*;
import sameat.business.*;

/**
 *
 * @author plotk_000
 */
public class UserDB {
    
    public static String[] getData(String[] data) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        String query="SELECT *  FROM User "
                + "WHERE UserID = ? AND UserName=?";
        
        try {
            
            ps=connection.prepareStatement(query);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            rs=ps.executeQuery();
            if(rs.next()) {
                return new String[]{rs.getString("HashedAndSaltedPassword") , rs.getString("Salt") };
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
