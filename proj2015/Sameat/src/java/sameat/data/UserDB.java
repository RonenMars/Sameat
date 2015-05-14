
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
        CallableStatement cs=null;
        ResultSet rs=null;
        
        try {

            cs=connection.prepareCall("{call getUser(?,?)}");
            cs.setString(1, data[0]);
            cs.setString(2, data[1]);
            rs=cs.executeQuery();
            
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
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
        
    }
            
}
