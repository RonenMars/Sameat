<%-- 
    Document   : Admin
    Created on : May 12, 2015, 10:18:23 AM
    Author     : College
--%>

<%@page import="java.sql.ResultSet" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>סמיט - מסעדת בשרים משובחת</title>
<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="images/icon.ico" />
</head>

<body>
<div id="headerbg">
  <div id="headerblank">
    <div id="header">
      <div id="menu">
        <ul>
          <li><a href="#" class="menu">התנתק</a></li>
          <li><a href="#" class="menu">ניהול תפריט</a></li>
          <li><a href="#" class="menu">ניהול לקוחות</a></li>
          <li><a href="#" class="menu">דו"חות</a></li>
          <li><a href="#" class="menu">דף הבית</a></li>
        </ul>
      </div>
      <div id="login">
        <div id="logintxtblank">
          <div id="loginheading">
            <h4>התחברות משתמש</h4>
          </div>
        <form action="AllUsers" method="POST">
          <div id="username">שם משתמש:</div>
          <div id="input">
            <label>
              <input name="textfield" type="text" class="input" id="textfield" value="הכנס שם משתמש" />
            </label>
          </div>
          <div id="password">סיסמא:</div>
          <div id="input02">
            <label>
              <input name="textfield2" type="password" class="input" id="textfield2" value="password" />
            </label>
          </div>
          <div id="loginbutton"><input name="login" type="submit" class="login" value="התחבר" /></div>
          <div id="register"><a href="#" class="register">הירשם כעת</a></div>
        </form>
        </div>
      </div>
    </div>
  </div>
</div>
<div id="contentbg">
  <div id="contentblank">
    <div id="content">
      <div id="contentleft">
        <div id="leftheading">
          <h4>חדשות &amp; עדכונים</h4>
        </div>
        <!--<div class="lefttxtblank">
          <div class="lefticon">16</div>
          <div class="leftboldtxtblank">
            <div class="leftboldtxt">Pulvinar interdum ...</div>
            <div class="lefttxt">By Jack Son  | 11:55 AM</div>
          </div>
          <div class="leftnormaltxt">Etiam auctor nisl adipiscing sem.  erat urna fringilla sit ametvestibulum.</div>
          <div class="morebutton"><a href="#" class="more">read more... </a></div>
        </div>
        <div class="lefttxtblank02">
          <div class="lefticon">16</div>
          <div class="leftboldtxtblank">
            <div class="leftboldtxt">Aulvinar gnterdum ...</div>
            <div class="lefttxt">By Jack Son  | 11:55 AM</div>
          </div>
          <div class="leftnormaltxt">Stiam auctor nisl adipiscing sem.  erat urna fringilla sit ametvestibulum.</div>
          <div class="morebutton"><a href="#" class="more">read more... </a></div>
        </div>
        <div class="lefttxtblank02">
          <div class="lefticon">16</div>
          <div class="leftboldtxtblank">
            <div class="leftboldtxt">Qulvinar snterdum ...</div>
            <div class="lefttxt">By Jack Son  | 11:55 AM</div>
          </div>
          <div class="leftnormaltxt">Etiam auctor nisl adipiscing sem.  erat urna fringilla sit ametvestibulum.</div>
          <div class="morebutton"><a href="#" class="more">read more... </a></div>
        </div>
        <div id="leftnavheading">
          <h4>Resources</h4>
        </div>
        <div id="leftnav">
          <ul>
            <li><a href="#" class="leftnav">Mauris neque egestas justo </a></li>
            <li><a href="#" class="leftnav">Neque eros a nequestibulum </a></li>
            <li><a href="#" class="leftnav">Primis in faucibus orci luctus </a></li>
            <li><a href="#" class="leftnav">Posuere cubilia Curae </a></li>
            <li><a href="#" class="leftnav">Ulla risus risus sagittis in </a></li>
            <li><a href="#" class="leftnav">Lobortis sed tincidunt at est.</a></li>
            <li><a href="#" class="leftnav">Donec posuere egestas ipsum</a></li>
            <li><a href="#" class="leftnav">Cras ac magna vel justo </a></li>
            <li><a href="#" class="leftnav">Sollicitudin viverra. </a></li>
            <li><a href="#" class="leftnav">Nullam elementum nibh ut </a></li>
          </ul>
        </div>-->
      </div>
      <div id="contentmid">
        <div class="midheading">
          <h2>ניהול</h2>
        </div>
          <h2>Our main purpose</h2>
        <div id="purposetxt">
        <table>
            <c:forEach items="${rs}" var="item">
                <tr>
                    <td>${item.property1}</td>
                    <td>${item.property2}</td>
                </tr>
            </c:forEach>
        </table>
        </div>
      </div>
      <div id="contentright">
        <div class="rightheading">
          <h4>משימות אחראי</h4>
        </div>
        <!--
		<div id="galleryblank">
          <div id="rightpic"><a href="#" class="rightpic"></a></div>
          <div id="rightpic02"><a href="#" class="rightpic02"></a></div>
          <div id="rightpic03"><a href="#" class="rightpic03"></a></div>
          <div class="viewbutton"><a href="#" class="view"> view more</a></div>
          <div class="rightheading">
            <h4>Creative story</h4>
          </div>
          <div class="righttxt"><span class="rightboldtxt">01. aliquet tempor nisi tellus </span>bibendum nunc. Sed venenatis scelerisque ipsum.</div>
          <div class="righttxt"><span class="rightboldtxt">02.  Tempor nisi tellus </span><br />
            Ndum nunc. Sed venenatis scelerisque ipsum.</div>
          <div class="righttxt"><span class="rightboldtxt">03.  Kempor sisi vellus </span><br />
            Qchdum nunc. Sed venenatis scelerisque ipsum.</div>
          <div class="righttxt"><span class="rightboldtxt">04. Aliquet tempor nisi tellus </span>bibendum nunc. Sed venenatis</div>
          <div class="viewbuttonbot"><a href="#" class="view"> read more</a></div>
        </div>
		-->
      </div>
    </div>
  </div>
</div>
<div id="footerbg">
  <div id="footerblank">
    <div id="footer">
      <!--
	  <div id="footerbox">
        <div class="footerheading"><h4>Tempus</h4></div>
        <div class="footertxt">Donec posuere bibendum erat.  commodo consectetuer tellus. Ut ut tellus eget</div>
        <div class="footerbutton"><a href="#" class="button">read more</a></div>
      </div>
      <div id="footermid"><div class="footerheading"><h4>Neque</h4></div>
      <div class="footertxt">Neque nisl porttitor dolor, ut posuere nibh lectus vel pede. Nam non elit.</div>
      <div class="footerbutton"><a href="#" class="button">read more</a></div>
      </div>
      <div id="footerlast">
        <div class="footerheading">
          <h4>Curabitur</h4>
        </div>
        <div class="footertxt">Eque nisl porttitor dolor, ut posuere nibh lectus vel pede. Nam non elit. </div>
        <div class="footerbutton"><a href="#" class="button">read more</a></div>
      </div>
      <div id="footerlinks"><a href="#" class="footerlinks">Home</a> | <a href="#" class="footerlinks">About Us</a> | <a href="#" class="footerlinks">Support</a> | <a href="#" class="footerlinks">Forum</a> | <a href="#" class="footerlinks">Development</a> | <a href="#" class="footerlinks">Conact Us</a></div>
      <div id="copyrights">© Copyright Information Goes Here. All Rights Reserved.</div>
      <div id="designedby">
        <p>Design by <a href="http://www.worldclasslasik.com">new york lasik surgery</a> and <a href="http://www.getnetset.com">cpa website design</a></p>
      </div>
	  -->
    </div>
  </div>
</div>
</body>
</html>

