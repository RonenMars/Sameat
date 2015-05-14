/**
 * Server API : NewUser Servlet
 * 
 * The main propose of this servlet it's to get user request 
 * for registration to the site.
 * 
 */
package sameat.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sameat.business.User;
import sameat.util.CheckData;
import sameat.util.PasswordUtil;
/**
 *
 * @author plotk_000
 */
@WebServlet(name = "UpdateUser", urlPatterns = {"/UpdateUser"})
public class UpdateUser extends HttpServlet {

    CheckData check=new CheckData();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String url="/update.jsp";
      
        
        String userID=request.getParameter("userID");
        String firstN=request.getParameter("fName");
        String lastN=request.getParameter("lName");
        int uGender=Integer.parseInt(request.getParameter("gender"));
        String uBDay=request.getParameter("uBDay");
        String uAddr=request.getParameter("uAddr");
        String uCity=request.getParameter("uCity");
        String uPhone=request.getParameter("uPhone");
        String uEmail=request.getParameter("uEmail");
        String userN=request.getParameter("userN");
        String password=request.getParameter("password");
        int uType=Integer.parseInt(request.getParameter("uType"));
        
        
        //Check Data from the request
        if(userID==null || userID.isEmpty() || firstN==null || firstN.isEmpty()
                || lastN==null || lastN.isEmpty() || uBDay==null || uBDay.isEmpty() 
                || uAddr==null || uAddr.isEmpty() || uCity==null || uCity.isEmpty() 
                || uPhone==null || uPhone.isEmpty() || uEmail==null || uEmail.isEmpty()
                || userN==null || userN.isEmpty()) {
            String Message="One or more of the fields is empty , fill them and try again!";
            request.setAttribute("Message", Message);
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if(!check.checkID(userID)&&!check.checkBDay(uBDay)) {
            String Message="The ID must be 9 characters long and/or the birthday date is in wrong , please try again !";
            request.setAttribute("Message", Message);
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
            
        }
        else if(!check.checkPasswordStrength(password)) {
            String Message="The Password must be 8 characteres long!";
            request.setAttribute("Message", Message);
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else {
            User user=new User(userID , firstN , lastN , uGender , uBDay , uAddr , uCity , uPhone , uEmail , userN , uType);
            String salt=PasswordUtil.getSalt();
            try { 
                String hspassword=PasswordUtil.hashAndSaltPassword(password, salt);
            } catch(NoSuchAlgorithmException ex) {
                
            }
            
            url="/thanks.jsp";
            request.setAttribute("user", user);
            if(uType==2)
            {
              this.getServletContext().getRequestDispatcher(url).forward(request, response);
            }
        }
            
    }
}
