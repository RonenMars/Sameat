/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sameat.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sameat.business.*;
import sameat.data.CourseDB;
import sameat.data.IngredientDB;
import sameat.data.OrdersDB;
import sameat.data.UsersDB;
import sameat.util.*;
/**
 *
 * @author RomanPlt
 */

public class OrderController extends HttpServlet {


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
       
         String requestURI = request.getRequestURI();
         
         if(requestURI.endsWith("/getcart")) {
             cart(request , response);
         } else if(requestURI.endsWith("/history")) {
             history(request , response);
         } else if(requestURI.endsWith("/add")) {
             addToCart(request , response);
         } else if(requestURI.endsWith("/remove")) {
             removeFromCart(request , response);
         } else if(requestURI.endsWith("/update")) {
             updateCart(request , response);
         } else if(requestURI.endsWith("/order")) {
             request.setAttribute("creditCardYears", creditCardYears());
             String path="/ucart/order.jsp";
             this.getServletContext().getRequestDispatcher(path).forward(request, response);
         } else if(requestURI.endsWith("/complete")) {
             completeOrder(request , response);
         } else if(requestURI.endsWith("/rate")) {
             rateCourse(request , response);
         } else if(requestURI.endsWith("/completeMobile")) {
             completeMobOrder(request , response);
         } else if(requestURI.endsWith("/orders")) {
             GetOrders(request , response); 
         }
    }

    private void cart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession(false);

        String url;
        String message="You must to register to the site before you can add items to cart and make order!";

        if(session==null){
            url="/un_join.jsp";
            request.setAttribute("message", message);
        } else if(session.getAttribute("user")==null) {
            url="/un_join.jsp";
            request.setAttribute("message", message);
        } else {
            Cart cart;
            final Object lock=session.getId().intern();
            synchronized(lock) {
                cart=(Cart)session.getAttribute("cart");
            }
            if(cart==null || cart.getCount()==0) {
                request.setAttribute("emptyCart", "Your cart is Empty!");
            }
            else {
                synchronized(lock) {
                    request.getSession().setAttribute("cart", cart);
                }
            }
            url="/ucart/show.jsp";
        }
        
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void history(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        HttpSession session=request.getSession(false);
        String url;
        String message="You must register to the site before you can be able to order and see your orders history!";
        
        if(session==null) {
            url="/un_join.jsp";
            request.setAttribute("message", message);
        } else if(session.getAttribute("user")==null) {
            url="/un_join.jsp";
            request.setAttribute("message", message);
        } else {
            User user=(User)session.getAttribute("user");
            ArrayList<Order> orders=OrdersDB.getOrdersHistory(user.getUserID());
            if(orders.isEmpty()){
                orders=null;
            }
            request.setAttribute("orders", orders);
            url="/orders/history.jsp";
        }
        
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        final Object lock=session.getId().intern();
        Cart cart;
        synchronized(lock) {
            cart=(Cart)session.getAttribute("cart");
        }
        if(cart==null) {
            cart=new Cart();
        }
        int cid=Integer.parseInt(request.getParameter("courseid"));
        int quant=Integer.parseInt(request.getParameter("quant"));
        Item item=new Item();
        item.setCourse(CourseDB.getCourse(cid));
        item.setQuantity(quant);
        cart.addItem(item);
        
        synchronized(lock) {
             request.getSession().setAttribute("cart", cart);
        }
        String url="/cart/getcart";
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void removeFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        Cart cart=(Cart) session.getAttribute("cart");
        int cid=Integer.parseInt(request.getParameter("courseid"));
        
        for (Item i : cart.getItems()) {
            if(i.getCourse().getId()==cid) {
                cart.removeItem(i);
                break;
            }
        }
        String url="/cart/getcart";
        this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       HttpSession session=request.getSession();
       Cart cart=(Cart)session.getAttribute("cart");
       int cid=Integer.parseInt(request.getParameter("courseid"));
       int quant=Integer.parseInt(request.getParameter("quant"));
       
       for(Item i : cart.getItems()) {
           if(i.getCourse().getId()==cid) {
               i.setQuantity(quant);
               break;
           }
       }
       String url="/cart/getcart";
       this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private ArrayList<String> creditCardYears() {
        
       ArrayList<String> years= new ArrayList<>();
       GregorianCalendar cdate=new GregorianCalendar();
       int cyear=cdate.get(Calendar.YEAR);
       
       for(int i=0 ; i<8 ; i++) {
           int year=cyear+i;
           String yearS=Integer.toString(year);
           years.add(yearS);
       }
       return years;
    }

    private void completeOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      String hid=request.getParameter("holderid");
      String ctype=request.getParameter("ctype");
      String cnum=request.getParameter("cnumber");
      String expm=request.getParameter("cexpm");
      String expy=request.getParameter("cexpy");
      
      HttpSession session=request.getSession();
      Cart cart=(Cart)session.getAttribute("cart");
      User user=(User)session.getAttribute("user");
     
      if(hid==null || hid.isEmpty() || ctype==null || ctype.isEmpty() || cnum==null ||
              cnum.isEmpty() || expm==null || expm.isEmpty() || expy==null || expy.isEmpty() ) {
           String url="/cart/order";
           String infoerror="One or more of the fields is empty , fill all the fields to make the order!";
           request.setAttribute("infoerror", infoerror);
           this.getServletContext().getRequestDispatcher(url).forward(request, response);
      } 
      
      //Step 1 : Get every Course Ingredients
      ArrayList<Course_Ingredients> courses=new ArrayList<>();
      Course_Ingredients ci=null;
      for(Item item : cart.getItems()) {
          int camount=item.getQuantity();
          for(int j=0 ; j<camount ; j++) {
              ci=IngredientDB.getCourseIngredients(item.getCourse());
              courses.add(ci);
          }
      }
      
      //Step 2 : Check the Inventory
      
      for(Course_Ingredients c : courses) {
          int amount=c.getCount();
          for(Ingredient ing : c.getIngredients()) {
              int result=IngredientDB.checkStock(ing);
              if(result!=-1) {
                  amount-=result;
              }
              else { //SQL Exception
                  String ordmsg="There was some problem in the DataBase , please try again later! ";
                  String url="/cart/getcart";
                  request.setAttribute("ordmsg", ordmsg);
                  this.getServletContext().getRequestDispatcher(url).forward(request, response);
                  return;
              }      
          }
          if(amount!=0) { //There are deficiencies in stock of this course 
              courses.remove(c);
          }
      }
          
         //Step 3: Pay for the order
         // pay(hid , ctype , cnum , expm , expy);
          
        //Step 4: Make the order
          
          if(courses.isEmpty()) { //There are deficiencies in stock of all the courses in the Cart
              session.setAttribute("cart",null);
              String ordmsg="There are deficiencies in stock and so we can not provide you the courses you want to order, we are very sorry, please try again later.";
              String url="/cart/getcart";
              request.setAttribute("ordmsg", ordmsg);
              this.getServletContext().getRequestDispatcher(url).forward(request, response);
              return;
          }
          
          //Create the Order in DB
          
          float tprice=0;
          for(Course_Ingredients co : courses) {
              tprice+=co.getCourse().getPrice();
          }
            LocalDate date=LocalDate.now(ZoneId.of("UTC"));
            String ordate=date.toString();
            
            int ordid=OrdersDB.addOrder(hid, ordate, tprice); //Add order to DB
            
          // Create the connection between order and courses in DB
            
            for(Course_Ingredients co : courses) {
                int result=OrdersDB.addCoursesToOrder(ordid, co.getCourse().getId());
                if(result==-1) { //SQLException
                  String ordmsg="There was some problem in the DataBase , please try again later! ";
                  String url="/cart/getcart";
                  request.setAttribute("ordmsg", ordmsg);
                  this.getServletContext().getRequestDispatcher(url).forward(request, response);
                  return;
                }
                    
            }
            
            
           //Update Stock for each Ingredient of the order courses
            
            for(Course_Ingredients co : courses) {
                for(Ingredient ing : co.getIngredients()) {
                    int result=OrdersDB.updateStock(ing.getId(),ing.getInventory() );
                    if(result==-1) { //SQLException
                        String ordmsg="There was some problem in the DataBase , please try again later! ";
                        String url="/cart/getcart";
                        request.setAttribute("ordmsg", ordmsg);
                        this.getServletContext().getRequestDispatcher(url).forward(request, response);
                        return;
                    }
                }
            }
            
            //Step 5: Send Invoice to User Email.
            
            String order=new String();
            for(Course_Ingredients co : courses) {
                order+="Course Name: "+co.getCourse().getName()+" , Course Price:  "+Float.toString(co.getCourse().getPrice())+" \n\n";
            }
            
            
            String to=user.getUserEmail();
            String from="plotkinrom@gmail.com";
            String subject="Sameat : (Order Number: "+ordid+") ,- Confirmation";
            String body="Dear "+user.getFirstName()+",\n\n"+
                    "Thanks for ordering from us.\n"+
                    "You should receive your order in next hours. \n"+
                    "Please contact us if you have any questions.\n" +
                    "Have a great day and thanks again!\n\n"+
                    "Your Order Summary: \n\n"+order+
                    "Total Price: "+tprice+
                    "\n\n Sameat Team - 2015";
            boolean isBodyHTML=false;
            try {
                MailUtil.sendMail(to, from, subject, body, isBodyHTML);
            } catch(MessagingException ex) {
                this.log(
                "Unable to send email. \n" +
                "You may need to configure your system as " +
                "described in chapter 15. \n" +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + to + "\n" +
                "FROM: " + from + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body + "\n\n");
            }
            
            request.setAttribute("courses", courses);
            session.setAttribute("cart", null);
            request.setAttribute("ordid", ordid);
            request.setAttribute("tprice" , tprice);
            
            String url="/orders/invoice.jsp";
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
      }

    private void rateCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        int orderid=Integer.parseInt(request.getParameter("ordid"));
        int courseid=Integer.parseInt(request.getParameter("courseid"));
        int rating=Integer.parseInt(request.getParameter("rating"));
        
        
        OrdersDB.rateOrderCourse(orderid, courseid , rating);
        
       history(request , response);
 
    }

    private void completeMobOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
       
      String uname=request.getParameter("uname");
      String hid=request.getParameter("holderid");
      String ctype=request.getParameter("ctype");
      String cnum=request.getParameter("cnumber");
      String expm=request.getParameter("cexpm");
      String expy=request.getParameter("cexpy");
      
      int cid=Integer.parseInt(request.getParameter("cid"));
      int camount=Integer.parseInt(request.getParameter("camount"));
      
      //Step 1 : Get every Course Ingredients
      
      
      ArrayList<Course_Ingredients> courses=new ArrayList<>();
      Course_Ingredients ci;
      
      Course co=CourseDB.getCourse(cid);
      Item item=new Item();
      item.setCourse(co);
      item.setQuantity(camount);
      
      for(int j=0 ; j<camount ; j++) {
          ci=IngredientDB.getCourseIngredients(item.getCourse());
          courses.add(ci);
      }
      
     //Step 2 : Check the Inventory
      
      for(Course_Ingredients c : courses) {
          int amount=c.getCount();
          for(Ingredient ing : c.getIngredients()) {
              int result=IngredientDB.checkStock(ing);
              if(result!=-1) {
                  amount-=result;
              }
              else { //SQL Exception
                  String sqlexp="-2"; //First One
                  String js=new Gson().toJson(sqlexp);
                  response.setContentType("application/json");
                  PrintWriter out =response.getWriter();
                  out.print(js);
                  out.flush();
                  return;
              }      
          }
          if(amount!=0) { //There are deficiencies in stock of this course 
              courses.remove(c);
          }
      }
          
         //Step 3: Pay for the order
         // pay(hid , ctype , cnum , expm , expy);
      
      //Step 4: Make the order
          
          if(courses.isEmpty()) { //There are deficiencies in stock of all the courses in the Cart
              String stock="-1";
              String js=new Gson().toJson(stock);
              response.setContentType("application/json");
              PrintWriter out =response.getWriter();
              out.print(js);
              out.flush();
              return; 
          }
          
           //Create the Order in DB
          
          float tprice=0;
          for(Course_Ingredients cou : courses) {
              tprice+=cou.getCourse().getPrice();
          }
            LocalDate date=LocalDate.now(ZoneId.of("UTC"));
            String ordate=date.toString();
            
            int ordid=OrdersDB.addOrder(hid, ordate, tprice); //Add order to DB
          
         // Create the connection between order and courses in DB
            
            for(Course_Ingredients cou : courses) {
                int result=OrdersDB.addCoursesToOrder(ordid, cou.getCourse().getId());
                if(result==-1) { //SQLException
                    String sqlexp="-3"; //Second
                    String js=new Gson().toJson(sqlexp);
                    response.setContentType("application/json");
                    PrintWriter out =response.getWriter();
                    out.print(js);
                    out.flush();
                    return;
                }
                    
            }
            
         //Update Stock for each Ingredient of the order courses
            
            for(Course_Ingredients cou : courses) {
                for(Ingredient ing : cou.getIngredients()) {
                    int result=OrdersDB.updateStock(ing.getId(),ing.getInventory() );
                    if(result==-1) { //SQLException
                        String sqlexp="-4"; //Third
                        String js=new Gson().toJson(sqlexp);
                        response.setContentType("application/json");
                        PrintWriter out =response.getWriter();
                        out.print(js);
                        out.flush();
                        return;
                    }
                }
            }
            
            
           //Step 5: Send Invoice to User Email.
            
            String order=new String();
            for(Course_Ingredients cou : courses) {
                order+="Course Name: "+cou.getCourse().getName()+" , Course Price:  "+Float.toString(cou.getCourse().getPrice())+" \n\n";
            }
            
            User user=UsersDB.getData(hid, uname);
            String to=user.getUserEmail();
            String from="sameatsce@gmail.com";
            String subject="Sameat : (Order Number: "+ordid+") ,- Confirmation";
            String body="Dear "+user.getFirstName()+",\n\n"+
                    "Thanks for ordering from us.\n"+
                    "You should receive your order in next hours. \n"+
                    "Please contact us if you have any questions.\n" +
                    "Have a great day and thanks again!\n\n"+
                    "Your Order Summary: \n\n"+order+
                    "Total Price: "+tprice+
                    "\n\n Sameat Team - 2015";
            boolean isBodyHTML=false;
            try {
                MailUtil.sendMail(to, from, subject, body, isBodyHTML);
            } catch(MessagingException ex) {
                this.log(
                "Unable to send email. \n" +
                "You may need to configure your system as " +
                "described in chapter 15. \n" +
                "Here is the email you tried to send: \n" +
                "=====================================\n" +
                "TO: " + to + "\n" +
                "FROM: " + from + "\n" +
                "SUBJECT: " + subject + "\n" +
                "\n" +
                body + "\n\n");
            }
            
            String result="Order has been made successfully!!!";
            String js=new Gson().toJson(result);
            response.setContentType("application/json");
            PrintWriter out =response.getWriter();
            out.print(js);
            out.flush();
    }
    
       private void GetOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String url="/admin/adminIndex.jsp";
            this.getServletContext().getRequestDispatcher(url).forward(request, response);
    }   
     
}
