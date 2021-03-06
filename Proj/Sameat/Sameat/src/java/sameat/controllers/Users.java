//package sameat.controllers;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import sameat.data.UsersDB;
//
//import sameat.util.CheckData;
//import sameat.business.User;
//import sameat.data.ConnectionPool;
//import sameat.data.DBUtil;
//
///**
// *
// * @author plotk_000
// */
//@WebServlet(name = "Users", urlPatterns = {"/Users"})
//public class Users extends HttpServlet {
//    
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//       doPost(request , response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        
//        ConnectionPool pool=ConnectionPool.getInstance();
//        Connection connection=pool.getConnection();
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//        
//        String query="SELECT *  FROM User "
//                + "WHERE UserID = ? AND UserName=?";
//        
//        try {
//            
//            ps=connection.prepareStatement(query);
//            ps.setString(1, data[0]);
//            ps.setString(2, data[1]);
//            rs=ps.executeQuery();
//            if(rs.next()) {
//                return new String[]{rs.getString("HashedAndSaltedPassword") , rs.getString("Salt") };
//            }
//            else
//                return null;
//        } catch(SQLException ex) {
//            System.err.println(ex);
//            return null;
//        } finally {
//            DBUtil.closeResultSet(rs);
//            DBUtil.closePreparedStatement(ps);
//            pool.freeConnection(connection);
//        }
//        
//        String url="/Admin.jsp";               
//        this.getServletContext().getRequestDispatcher(url).forward(request, response);           
//       }
////       /*Success Login to the system*/
////       if(result==1) {
////           
////           //WebSite -- Type 1
////           if(appType.equals("1")) {
////               String url="/success.jsp";
////               
////               
////               this.getServletContext().getRequestDispatcher(url).forward(request, response);
////           }
////           
////           //StandaloneApp -- Type 2 || MobileApp -- Type 3
////           if(appType.equals("2") || appType.equals("3")) {
////               
////               response.setContentType("application/json");
////               response.setCharacterEncoding("utf-8");
////               PrintWriter out = response.getWriter();
////               
////               //Response Gason - Jason Object
////               
////               User user=UsersDB.getData(new String[]{userid , username});
////               Gson jObj=new Gson();
////               String jasonObj=jObj.toJson(user);
////               out.print(jasonObj);
////               
////           }
////       }
////       else if(result==0) {
////           //WebSite -- Type 1
////           if(appType.equals("1")) {
////               String url="/login.jsp";
////               String Message="One or more of the values is wrong , try again!";
////               request.setAttribute("Message", Message);
////               this.getServletContext().getRequestDispatcher(url).forward(request, response);
////               
////           }
////           
////           //StandaloneApp -- Type 2 || MobileApp -- Type 3
////           if(appType.equals("2") || appType.equals("3")) {
////               
////               response.setContentType("application/json");
////               response.setCharacterEncoding("utf-8");
////               PrintWriter out = response.getWriter();
////               
////               //Response Gason - Jason Object
////
////               Gson jObj=new Gson();
////               String jasonObj=jObj.toJson("");
////               out.print(jasonObj);
////               
////           }
////       }
////       else if(result==-1) {
////           
////       }
//       
//}