
package sameat.data;

import java.sql.*;
import sameat.business.*;

public class IngredientDB {
    
    
    public static int checkStock(Ingredient ing) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        
        try {
            cs=connection.prepareCall("{call checkIngAmountInStock(? , ? ,?)}");
            cs.setInt(1, ing.getId());
            cs.setInt(2, ing.getInventory());
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            
            cs.executeUpdate();
            
            return cs.getInt(3);
            
        } catch(SQLException ex) {
            System.err.println(ex);
            return -1;
        } finally {
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
    }
    
    public static Course_Ingredients getCourseIngredients(Course course) {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        CallableStatement cs=null;
        ResultSet rs=null;
        
        
        
        try {
            cs=connection.prepareCall("{call getCourseIngredients(?)}");
            cs.setInt(1, course.getId());
            Course_Ingredients ci=new Course_Ingredients();
            ci.setCourse(course);
            rs=cs.executeQuery();
            
            while(rs.next()) {
               Ingredient ing=new Ingredient();
               ing.setId(rs.getInt(3));
               ing.setName(rs.getString(4));
               ing.setPrice(rs.getFloat(5));
               ing.setInventory(rs.getInt(6));
               ci.addIngredient(ing);
            }
            return ci;
            
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
