package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FoodMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registration To the Site!</title>\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            body {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            form {\n");
      out.write("                border: 2px dashed darkslategray;\n");
      out.write("                margin-left: auto;\n");
      out.write("                margin-right: auto;\n");
      out.write("                text-align: left;\n");
      out.write("                width:500px;\n");
      out.write("            }\n");
      out.write("            form input[type='submit'] {\n");
      out.write("                display: inline-block;\n");
      out.write("                width:80px;\n");
      out.write("            }\n");
      out.write("            div.btn {\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            p.error {\n");
      out.write("                color:red;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Registration Form!</h1><br><br>\n");
      out.write("        <!--<p class=\"error\"><b></b></p>-->\n");
      out.write("        <form action=\"NewUser\" method=\"POST\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"add\">\n");
      out.write("            <br><label>ID: </label><input type=\"text\" name=\"userID\" value=\"\" /><br><br>\n");
      out.write("            <label>First Name: </label><input type=\"text\" name=\"fName\" value=\"\" /><br><br>\n");
      out.write("            <label>Last Name: </label><input type=\"text\" name=\"lName\" value=\"\" /><br><br>\n");
      out.write("            <label>Choose Gender: </label><br>\n");
      out.write("            <input type=\"radio\" name=\"gender\" value=\"1\" checked=\"checked\" /><label>Female</label><br>\n");
      out.write("            <input type=\"radio\" name=\"gender\" value=\"2\" /><label>Male</label><br><br>\n");
      out.write("            <label>Enter your Birthday (in format dd/mm/yyyy):</label><input type=\"text\" name=\"uBDay\" value=\"\" /><br><br>\n");
      out.write("            <label>Address: </label><input type=\"text\" name=\"uAddr\" value=\"\" /><br><br>\n");
      out.write("            <label>City: </label><input type=\"text\" name=\"uCity\" value=\"\" /><br><br>\n");
      out.write("            <label>Phone: </label><input type=\"text\" name=\"uPhone\" value=\"\" /><br><br>\n");
      out.write("            <label>Email: </label><input type=\"text\" name=\"uEmail\" value=\"\" /><br><br>\n");
      out.write("            <label>Username: </label> <input type=\"text\" name=\"userN\" value=\"\" /><br><br>\n");
      out.write("            <label>Password: </label><input type=\"password\" name=\"password\" value=\"\" /><br><br>\n");
      out.write("            <input type=\"hidden\" name=\"uType\" value=\"2\" />\n");
      out.write("            <div class='btn'>\n");
      out.write("            <input type=\"submit\" value=\"Submit\"/><br><br>\n");
      out.write("            </div>\n");
      out.write("               \n");
      out.write("            </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
