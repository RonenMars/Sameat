/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author userty5
 */
public class ReportsDB {
        
    public static float GetBalance() {
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        float Balance=-1;

        try {
            cs=connection.prepareCall("{call Earnings_Report()}");
            rs=cs.executeQuery();
            if(rs.next()) {
                   Balance = rs.getFloat(1);
                }
                return Balance;
            } catch(SQLException ex) {
                System.err.println(ex);
                return -1;
            } finally {
                DBUtil.closeResultSet(rs);
                DBUtil.closePreparedStatement(cs);
                pool.freeConnection(connection);
            }
    }    
}
