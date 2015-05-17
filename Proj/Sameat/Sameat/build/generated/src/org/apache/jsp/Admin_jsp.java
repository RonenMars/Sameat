package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.io.*;
import java.net.*;

public final class Admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("<title>סמיט - מסעדת בשרים משובחת</title>\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("<link rel=\"icon\" href=\"images/icon.ico\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<div id=\"headerbg\">\n");
      out.write("  <div id=\"headerblank\">\n");
      out.write("    <div id=\"header\">\n");
      out.write("      <div id=\"menu\">\n");
      out.write("        <ul>\n");
      out.write("          <li><a href=\"#\" class=\"menu\">התנתק</a></li>\n");
      out.write("          <li><a href=\"#\" class=\"menu\">ניהול תפריט</a></li>\n");
      out.write("          <li><a href=\"#\" class=\"menu\">ניהול לקוחות</a></li>\n");
      out.write("          <li><a href=\"#\" class=\"menu\">דו\"חות</a></li>\n");
      out.write("          <li><a href=\"#\" class=\"menu\">דף הבית</a></li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"login\">\n");
      out.write("        <div id=\"logintxtblank\">\n");
      out.write("          <div id=\"loginheading\">\n");
      out.write("            <h4>התחברות משתמש</h4>\n");
      out.write("          </div>\n");
      out.write("        <form action=\"AllUsers\" method=\"POST\">\n");
      out.write("          <div id=\"username\">שם משתמש:</div>\n");
      out.write("          <div id=\"input\">\n");
      out.write("            <label>\n");
      out.write("              <input name=\"textfield\" type=\"text\" class=\"input\" id=\"textfield\" value=\"הכנס שם משתמש\" />\n");
      out.write("            </label>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"password\">סיסמא:</div>\n");
      out.write("          <div id=\"input02\">\n");
      out.write("            <label>\n");
      out.write("              <input name=\"textfield2\" type=\"password\" class=\"input\" id=\"textfield2\" value=\"password\" />\n");
      out.write("            </label>\n");
      out.write("          </div>\n");
      out.write("          <div id=\"loginbutton\"><input name=\"login\" type=\"submit\" class=\"login\" value=\"התחבר\" /></div>\n");
      out.write("          <div id=\"register\"><a href=\"#\" class=\"register\">הירשם כעת</a></div>\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div id=\"contentbg\">\n");
      out.write("  <div id=\"contentblank\">\n");
      out.write("    <div id=\"content\">\n");
      out.write("      <div id=\"contentleft\">\n");
      out.write("        <div id=\"leftheading\">\n");
      out.write("          <h4>חדשות &amp; עדכונים</h4>\n");
      out.write("        </div>\n");
      out.write("        <!--<div class=\"lefttxtblank\">\n");
      out.write("          <div class=\"lefticon\">16</div>\n");
      out.write("          <div class=\"leftboldtxtblank\">\n");
      out.write("            <div class=\"leftboldtxt\">Pulvinar interdum ...</div>\n");
      out.write("            <div class=\"lefttxt\">By Jack Son  | 11:55 AM</div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"leftnormaltxt\">Etiam auctor nisl adipiscing sem.  erat urna fringilla sit ametvestibulum.</div>\n");
      out.write("          <div class=\"morebutton\"><a href=\"#\" class=\"more\">read more... </a></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"lefttxtblank02\">\n");
      out.write("          <div class=\"lefticon\">16</div>\n");
      out.write("          <div class=\"leftboldtxtblank\">\n");
      out.write("            <div class=\"leftboldtxt\">Aulvinar gnterdum ...</div>\n");
      out.write("            <div class=\"lefttxt\">By Jack Son  | 11:55 AM</div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"leftnormaltxt\">Stiam auctor nisl adipiscing sem.  erat urna fringilla sit ametvestibulum.</div>\n");
      out.write("          <div class=\"morebutton\"><a href=\"#\" class=\"more\">read more... </a></div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"lefttxtblank02\">\n");
      out.write("          <div class=\"lefticon\">16</div>\n");
      out.write("          <div class=\"leftboldtxtblank\">\n");
      out.write("            <div class=\"leftboldtxt\">Qulvinar snterdum ...</div>\n");
      out.write("            <div class=\"lefttxt\">By Jack Son  | 11:55 AM</div>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"leftnormaltxt\">Etiam auctor nisl adipiscing sem.  erat urna fringilla sit ametvestibulum.</div>\n");
      out.write("          <div class=\"morebutton\"><a href=\"#\" class=\"more\">read more... </a></div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"leftnavheading\">\n");
      out.write("          <h4>Resources</h4>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"leftnav\">\n");
      out.write("          <ul>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Mauris neque egestas justo </a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Neque eros a nequestibulum </a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Primis in faucibus orci luctus </a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Posuere cubilia Curae </a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Ulla risus risus sagittis in </a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Lobortis sed tincidunt at est.</a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Donec posuere egestas ipsum</a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Cras ac magna vel justo </a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Sollicitudin viverra. </a></li>\n");
      out.write("            <li><a href=\"#\" class=\"leftnav\">Nullam elementum nibh ut </a></li>\n");
      out.write("          </ul>\n");
      out.write("        </div>-->\n");
      out.write("      </div>\n");
      out.write("      <div id=\"contentmid\">\n");
      out.write("        <div class=\"midheading\">\n");
      out.write("          <h2>ניהול</h2>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"purposetxt\">\n");
      out.write("        <form id=\"my_form\" action=\"AllUsers\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" value=\"Login\" name=\"log\" />\n");
      out.write("        </form>\n");
      out.write("        ");
      out.print( request.getContextPath() );
      out.write("<br/>\n");
      out.write("        ");
      out.print( request.getRequestURI() );
      out.write("<br/>\n");
      out.write("        ");
      out.print( request.getRequestURL() );
      out.write("<br/>\n");
      out.write("        <b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"contentright\">\n");
      out.write("        <div class=\"rightheading\">\n");
      out.write("          <h4>משימות אחראי</h4>\n");
      out.write("        </div>\n");
      out.write("        <!--\n");
      out.write("\t\t<div id=\"galleryblank\">\n");
      out.write("          <div id=\"rightpic\"><a href=\"#\" class=\"rightpic\"></a></div>\n");
      out.write("          <div id=\"rightpic02\"><a href=\"#\" class=\"rightpic02\"></a></div>\n");
      out.write("          <div id=\"rightpic03\"><a href=\"#\" class=\"rightpic03\"></a></div>\n");
      out.write("          <div class=\"viewbutton\"><a href=\"#\" class=\"view\"> view more</a></div>\n");
      out.write("          <div class=\"rightheading\">\n");
      out.write("            <h4>Creative story</h4>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"righttxt\"><span class=\"rightboldtxt\">01. aliquet tempor nisi tellus </span>bibendum nunc. Sed venenatis scelerisque ipsum.</div>\n");
      out.write("          <div class=\"righttxt\"><span class=\"rightboldtxt\">02.  Tempor nisi tellus </span><br />\n");
      out.write("            Ndum nunc. Sed venenatis scelerisque ipsum.</div>\n");
      out.write("          <div class=\"righttxt\"><span class=\"rightboldtxt\">03.  Kempor sisi vellus </span><br />\n");
      out.write("            Qchdum nunc. Sed venenatis scelerisque ipsum.</div>\n");
      out.write("          <div class=\"righttxt\"><span class=\"rightboldtxt\">04. Aliquet tempor nisi tellus </span>bibendum nunc. Sed venenatis</div>\n");
      out.write("          <div class=\"viewbuttonbot\"><a href=\"#\" class=\"view\"> read more</a></div>\n");
      out.write("        </div>\n");
      out.write("\t\t-->\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("<div id=\"footerbg\">\n");
      out.write("  <div id=\"footerblank\">\n");
      out.write("    <div id=\"footer\">\n");
      out.write("      <!--\n");
      out.write("\t  <div id=\"footerbox\">\n");
      out.write("        <div class=\"footerheading\"><h4>Tempus</h4></div>\n");
      out.write("        <div class=\"footertxt\">Donec posuere bibendum erat.  commodo consectetuer tellus. Ut ut tellus eget</div>\n");
      out.write("        <div class=\"footerbutton\"><a href=\"#\" class=\"button\">read more</a></div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"footermid\"><div class=\"footerheading\"><h4>Neque</h4></div>\n");
      out.write("      <div class=\"footertxt\">Neque nisl porttitor dolor, ut posuere nibh lectus vel pede. Nam non elit.</div>\n");
      out.write("      <div class=\"footerbutton\"><a href=\"#\" class=\"button\">read more</a></div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"footerlast\">\n");
      out.write("        <div class=\"footerheading\">\n");
      out.write("          <h4>Curabitur</h4>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footertxt\">Eque nisl porttitor dolor, ut posuere nibh lectus vel pede. Nam non elit. </div>\n");
      out.write("        <div class=\"footerbutton\"><a href=\"#\" class=\"button\">read more</a></div>\n");
      out.write("      </div>\n");
      out.write("      <div id=\"footerlinks\"><a href=\"#\" class=\"footerlinks\">Home</a> | <a href=\"#\" class=\"footerlinks\">About Us</a> | <a href=\"#\" class=\"footerlinks\">Support</a> | <a href=\"#\" class=\"footerlinks\">Forum</a> | <a href=\"#\" class=\"footerlinks\">Development</a> | <a href=\"#\" class=\"footerlinks\">Conact Us</a></div>\n");
      out.write("      <div id=\"copyrights\">© Copyright Information Goes Here. All Rights Reserved.</div>\n");
      out.write("      <div id=\"designedby\">\n");
      out.write("        <p>Design by <a href=\"http://www.worldclasslasik.com\">new york lasik surgery</a> and <a href=\"http://www.getnetset.com\">cpa website design</a></p>\n");
      out.write("      </div>\n");
      out.write("\t  -->\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
