
package sameat.business;

import java.sql.*;
import sameat.business.*;
import sameat.data.ConnectionPool;
import sameat.data.DBUtil;

/**
 *
 * @author plotk_000
 */
public class AllUsers {
    
    public static String[] getData(String[] data) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        
        try {

            cs=connection.prepareCall("{call GetAllUsers()}");
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
