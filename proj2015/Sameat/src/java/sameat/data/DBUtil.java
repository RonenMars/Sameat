
package sameat.data;

import java.sql.*;

/**
 *
 * @author plotk_000
 */
public class DBUtil {
    
    public static void closeStatement(Statement s) {
        
        try {
            if(s!=null) {
                s.close();
            }
        } catch(SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public static void closePreparedStatement(Statement ps ) {
        
        try {
            if(ps!=null) {
                ps.close();
            }
        } catch(SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public static void closeResultSet(ResultSet rs) {
        
        try {
            if(rs!=null) {
                rs.close();
            }
            
        }catch(SQLException ex) {
            System.err.println(ex);
        }
    }
}
