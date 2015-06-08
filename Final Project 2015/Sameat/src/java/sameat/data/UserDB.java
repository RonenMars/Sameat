
package sameat.data;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author plotk_000
 */
public class UserDB {
    
    public static ArrayList<String> getData(ArrayList<String> data) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        ArrayList<String> user=new ArrayList<>();
        try {

            cs=connection.prepareCall("{call getLoginInfo(?,?)}");
            cs.setString(1, data.get(0));
            cs.setString(2, data.get(1));
            rs=cs.executeQuery();
            
            if(rs.next()) {
                user.add(0, rs.getString("HashedAndSaltedPassword"));
                user.add(1 , rs.getString("Salt"));
                return user;
            }
            else {
                user.add(0 , "Error1");
                return user;
            }
            
        } catch(SQLException ex) {
            System.err.println(ex);
            user.add(0, "Error2");
            return user;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
        
    }
            
}
