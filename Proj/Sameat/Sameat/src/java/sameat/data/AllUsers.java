package sameat.data;

import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import sameat.data.UsersDB;

import sameat.util.CheckData;
import sameat.business.User;

/**
 *
 * @author plotk_000
 */
@WebServlet(name = "AllUsers", urlPatterns = {"/AllUsers"})
public class AllUsers extends HttpServlet {
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request , response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ConnectionPool pool=ConnectionPool.getInstance();
        Connection connection=pool.getConnection();
        ResultSet rs=null;
       CallableStatement cs=null;
        
        try {
            String Message="One or more of the values is wrong , try again!";
            String url="/Admin.jsp";
            request.setAttribute("Message",Message);
            //this.getServletContext().getRequestDispatcher(url).forward(request, response);
            cs=connection.prepareCall("{CALL `GetAllUsers`()}");            
            rs=cs.executeQuery();
            if(rs.next())
            {
                Message=rs.getString("UserID");
                request.setAttribute("Message",Message);
                this.getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            else
            {
                request.setAttribute("Message", Message);
                this.getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            
            
        } catch(Exception ex) {
            System.err.println(ex);
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(cs);
            pool.freeConnection(connection);
        }
    }
            
}
