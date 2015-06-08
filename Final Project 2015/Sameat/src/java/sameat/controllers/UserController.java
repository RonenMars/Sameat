/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sameat.business.User;
import sameat.data.UsersDB;

import sameat.util.PasswordUtil;
import sameat.util.SendEmail;
import sameat.util.Validation;
/**
 *
 * @author plotk_000
 */

public class UserController extends HttpServlet {

    /**
     * 
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
       
        
        String requestURI = request.getRequestURI();
        
        
        if(requestURI.endsWith("/join")) {
            NewUser(request , response);
        } else if(requestURI.endsWith("/login")) {
            login(request , response);
        } else if(requestURI.endsWith("/profile")) {
            HttpSession session=request.getSession(false);
            String message="you must be a registered user to view your profile!";
            if(session==null) {
                request.setAttribute("message", message);
                this.getServletContext().getRequestDispatcher("/un_join.jsp").forward(request, response);
            } else if(session.getAttribute("user")==null) {
                request.setAttribute("message", message );
                this.getServletContext().getRequestDispatcher("/un_join.jsp").forward(request, response);
            } else {
                this.getServletContext().getRequestDispatcher("/client/profile.jsp").forward(request, response);
            }
        } else if(requestURI.endsWith("/main")) {
            this.getServletContext().getRequestDispatcher("/welcome/main.jsp").forward(request, response);
        } else if(requestURI.endsWith("/loginreq")) {
            loginreq(request , response);
        } else if(requestURI.endsWith("/new")) {
           User user=UsersDB.getData(request.getParameter("uid") , request.getParameter("uname"));
           HttpSession session=request.getSession(true);
           session.setAttribute("user", user);
             this.getServletContext().getRequestDispatcher("/welcome/main.jsp").forward(request, response);  
        } else if(requestURI.endsWith("/update")) {
            profile(request , response);
        } else if(requestURI.endsWith("/logout")) {
            HttpSession session=request.getSession();
            if(session!=null) {
                session.invalidate();
                response.sendRedirect(request.getContextPath());
            }
        } else if(requestURI.endsWith("/contact")) {
            contactUs(request , response);
        } else if(requestURI.endsWith("/customers")) {
            GetCustomers(request , response);
        }
        
    }

    private void NewUser(HttpServletRequest request , HttpServletResponse response) 
            throws ServletException, IOException {
        
        String fname=request.getParameter("FirstName");
        String lname=request.getParameter("LastName");
        String id=request.getParameter("ID");
        String gender=request.getParameter("gender");
        String bday=request.getParameter("userBDay");
        String add=request.getParameter("Address");
        String city=request.getParameter("City");
        String phone=request.getParameter("Phone");
        String email=request.getParameter("Email");
        String usern=request.getParameter("UserName");
        String password=request.getParameter("Password");
        
        
        if(Validation.newUser(fname , lname , id , bday , add , city , phone , email , usern , password)) {
            
            User user=new User(id , fname , lname , Integer.parseInt(gender) , bday , add , city , phone , email , usern , 2);
            String salt=PasswordUtil.getSalt();
            String hashp=null;
            try {
                hashp=PasswordUtil.hashAndSaltPassword(password, salt);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int result=UsersDB.setData(user, hashp, salt);
            String errm;
            if(result==-1) { //SQLException
                errm="There was some problem with our server , please try later!";
                request.setAttribute("errm", errm);
                request.getServletContext().getRequestDispatcher("/join.jsp").forward(request, response);
            } else if(result==0) { // ID Exists
                errm="There is in the system a user with this ID!";
                request.setAttribute("errm", errm);
                request.getServletContext().getRequestDispatcher("/join.jsp").forward(request, response);
            } else if(result==1) { // User Name Exists
                errm="Unfortunately this User Name is alreadt taken , choose another one!";
                request.setAttribute("errm", errm);
                request.getServletContext().getRequestDispatcher("/join.jsp").forward(request, response);
            } else if(result==2) {
                
                SendEmail.newUser(user);
                request.setAttribute("user", user);
                request.getServletContext().getRequestDispatcher("/newcustomer.jsp").forward(request, response);
               
            }
        }
        else
        {
            String errm="Some of the fields are empty , or incorrectly filled , try again!";
            request.setAttribute("errm", errm);
            request.getServletContext().getRequestDispatcher("/join.jsp").forward(request, response);
        }
    }

    private void profile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        String uid=((User) session.getAttribute("user")).getUserID();
        String uname=((User) session.getAttribute("user")).getUserName();
        
        String addr=request.getParameter("Address");
        String city=request.getParameter("City");
        String phone=request.getParameter("Phone");
        String email=request.getParameter("Email");
        String pmessage;
        
        if(Validation.update(addr, city, phone, email)) {
            
           int result=UsersDB.updateData(uid, addr, city, phone, email);
           
           if(result!=-1) {
               
               pmessage="The profile was updated successfully!";
               User user=UsersDB.getData(uid, uname);
               session.setAttribute("user", user);
               request.setAttribute("pmessage", pmessage);
               this.getServletContext().getRequestDispatcher("/client/profile.jsp").forward(request, response);
           } else { //SQL Exception
               pmessage="There was some problem with the server , try again later!";
               request.setAttribute("pmessage", pmessage);
               this.getServletContext().getRequestDispatcher("/client/profile.jsp").forward(request, response);
           }
            
        } else {
            
            pmessage="There was an error with input fields , or they are empty or don't match the "
                    + "information that need to be completed in them!!!";
             request.setAttribute("pmessage", pmessage);
             this.getServletContext().getRequestDispatcher("/client/profile.jsp").forward(request, response);
            
        }
            
        
       
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
       String uid=request.getParameter("ID");
       String uname=request.getParameter("UserName");
       String upass=request.getParameter("Password");
       String url="/index.jsp";
       
       if(uid==null || uname==null || upass==null) {
           String errlogin="One or more of  the login inputs is wrong!";
           request.setAttribute("errlogin", errlogin);
           this.getServletContext().getRequestDispatcher(url).forward(request, response);
           return;
       }
       
       int result=Validation.Login(uid, uname, upass);
       if(result==0) {
           url="/index.jsp";
           String errlogin="One or more of  the login inputs is wrong!";
           request.setAttribute("errlogin", errlogin);
       } else if(result==-1 || result==-2) {
           url="/index.jsp";
           String errlogin="There was some problem with the Server , try again later!";
           request.setAttribute("errlogin", errlogin);
       } else if(result==1) {
           url="/welcome/main.jsp";
           User user=UsersDB.getData(uid , uname);
           HttpSession session=request.getSession(true);
           session.setAttribute("user", user);
       }
       
       this.getServletContext().getRequestDispatcher(url).forward(request, response);
       
    }

    private void loginreq(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
        String uid=request.getParameter("id");
        String uname=request.getParameter("username");
        String upass=request.getParameter("password");
        
       int result=Validation.Login(uid, uname, upass);
       if(result==0) {
           String lerror="";
           String js=new Gson().toJson(lerror);
           response.setContentType("application/json");
           PrintWriter out =response.getWriter();
           out.print(js);
           out.flush();
       } else if(result==-1 || result==-2) {
           String lerror="";
           String js=new Gson().toJson(lerror);
           response.setContentType("application/json");
           PrintWriter out =response.getWriter();
           out.print(js);
           out.flush();
       } else if(result==1) {
           User user=UsersDB.getData(uid, uname);
           String js=new Gson().toJson(user);
           response.setContentType("application/json");
           PrintWriter out =response.getWriter();
           out.print(js);
           out.flush();
       }
    }

    private void contactUs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String fname=request.getParameter("fullname");
        String email=request.getParameter("email");
        String message=request.getParameter("mtext");
        
        if(Validation.sendMessage(fname , email , message)) {
            SendEmail.contactUs(fname, email, message);
             request.setAttribute("msg", "The message has been sent to our team!");
        } else {
             request.setAttribute("msg", "Some of the fields are empty , or incorrectly filled , try again!");
        }
        
        this.getServletContext().getRequestDispatcher("/contactus.jsp").forward(request, response);
    }

    private void GetCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        ArrayList<User> customers = UsersDB.GetAllCustomers();     
        
        request.setAttribute("customers", customers);
        this.getServletContext().getRequestDispatcher("/admin/index.jsp").forward(request, response);   
    }
}
