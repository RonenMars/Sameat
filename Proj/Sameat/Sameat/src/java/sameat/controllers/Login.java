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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
    
    CheckData cd=new CheckData();

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
       String username=request.getParameter("username");
       String userid=request.getParameter("id");
       String password=request.getParameter("password");
       String appType=request.getParameter("appType");
       
       //CheckData -- Check for empty strings
       if(username.isEmpty() || userid.isEmpty() || password.isEmpty() ) {
           
           //WebSite -- Type 1
           if (appType.equals("1")) {
               
               String url="/login.jsp";
               String Message="One or more of the fields is empty!";
               request.setAttribute("Message", Message);
               
               this.getServletContext().getRequestDispatcher(url).forward(request, response);
           }
           
       }
       int result=cd.checkLogin(username, userid, password);
       /*Success Login to the system*/
       if(result==1) {
           
           //WebSite -- Type 1
           if(appType.equals("1")) {
               String url="/success.jsp";
               
               
               this.getServletContext().getRequestDispatcher(url).forward(request, response);
           }
           
           //StandaloneApp -- Type 2 || MobileApp -- Type 3
           if(appType.equals("2") || appType.equals("3")) {
               
               response.setContentType("application/json");
               response.setCharacterEncoding("utf-8");
               PrintWriter out = response.getWriter();
               
               //Response Gason - Jason Object
               
               User user=UsersDB.getData(new String[]{userid , username});
               Gson jObj=new Gson();
               String jasonObj=jObj.toJson(user);
               out.print(jasonObj);
               
           }
       }
       else if(result==0) {
           //WebSite -- Type 1
           if(appType.equals("1")) {
               String url="/login.jsp";
               String Message="One or more of the values is wrong , try again!";
               request.setAttribute("Message", Message);
               this.getServletContext().getRequestDispatcher(url).forward(request, response);
               
           }
           
           //StandaloneApp -- Type 2 || MobileApp -- Type 3
           if(appType.equals("2") || appType.equals("3")) {
               
               response.setContentType("application/json");
               response.setCharacterEncoding("utf-8");
               PrintWriter out = response.getWriter();
               
               //Response Gason - Jason Object

               Gson jObj=new Gson();
               String jasonObj=jObj.toJson("");
               out.print(jasonObj);
               
           }
       }
       else if(result==-1) {
           
       }
       
    }
}