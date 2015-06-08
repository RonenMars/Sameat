<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type"/>
    <title>Sameat - Best meat you'll ever eat !</title>
    <link href="<%=request.getContextPath()%>/admin/style.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script>
    $(function() {
      $( "#datepicker" ).datepicker();
    });
    </script>
</head>

<body>
<div id="headerbg">
  <div id="headerblank">
    <div id="header">
      <div id="menu">
        <ul>
          <li><a href="${pageContext.request.requestURL}" class="menu">Home</a></li>
          <li><a href="<%=request.getContextPath()%>/admin/customers" class="menu">Customers</a></li>
          <li><a href="<%=request.getContextPath()%>/admin/courses" class="menu">Courses</a></li>
          <li><a href="<%=request.getContextPath()%>/admin/orders" class="menu">Orders</a></li>
          <li><a href="${pageContext.request.requestURL}?display=reports"class="menu">Reports</a></li>
          <li><a href="${pageContext.request.requestURL}?display=logout" class="menu">Logout</a></li>
        </ul>
      </div>
      </div>
    </div>
</div>
<div id="contentbg">
  <div id="contentblank">
    <div id="content">
        <c:choose>
            <c:when test="${courses != null and not fn:endsWith(pageContext.request.requestURI, '/courses')}">
                <div class="midheading">
                  <h2>Restaurant courses</h2>
                </div>
                <div id="purposenav" style="color:white">
                    <table class="CSSTableGenerator">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Price</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${courses}" var="courses">
                                <tr>
                                    <td>${courses.id}</td>
                                    <td>${courses.name}</td>
                                    <td>${courses.desc}</td>
                                    <td>${courses.price}</td>
                                    <td>
                                        <form action="<%=request.getContextPath()%>/menu/in-out-course/" method="POST">
                                            <input type="hidden" name="courseid" value="${courses.id}">
                                                <c:choose>
                                                    <c:when test="${courses.isInMenu}"><input type="submit" class="btn btn-success"  value="Hide" /></c:when>
                                                    <c:otherwise><input type="submit" class="btn btn-success"  value="Unhide" /></c:otherwise>
                                                </c:choose>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:when test="${popCourses != null and not fn:endsWith(pageContext.request.requestURI, '/popular-courses')}">
                <div class="midheading">
                  <h2>Restaurant courses</h2>
                </div>
                <div id="purposenav" style="color:white">
                    <table class="CSSTableGenerator">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${popCourses}" var="popCourses">
                                <tr>
                                    <td>${popCourses.id}</td>
                                    <td>${popCourses.name}</td>
                                    <td>${popCourses.desc}</td>
                                    <td>${popCourses.price}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:when test="${customers != null and not fn:endsWith(pageContext.request.requestURI, '/customers')}">
                <div class="midheading">
                  <h2>Restaurant customers</h2>
                </div>
                <div id="purposenav" style="color:white">
                    <table class="CSSTableGenerator">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Gender</th>
                                <th>City</th>
                                <th>Phone</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${customers}" var="customers">
                                <tr>
                                    <td>${customers.userID}</td>
                                    <td>${customers.firstName} ${customers.lastName}</td>
                                    <td>${customers.userGender}</td>
                                    <td>${customers.userCity}</td>
                                    <td>${customers.userPhone}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when> 
            <c:when test="${orders != null}">
                <div class="midheading">
                  <h2>Orders</h2>
                </div>
                <div id="purposenav" style="color:white">
                <p>Date: <input type="text" id="datepicker"></p>

                </div>
            </c:when> 
            <c:when test="${param.display=='reports'}">                                          
                <div class="midheading">
                  <h2>System Reports</h2>
                </div>
                <div id="purposenav" style="color:white">
                    <table class="CSSTableGenerator">
                        <thead>
                            <tr>
                                <th>Please choose needed report</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="<%=request.getContextPath()%>/admin/reports/balance" class="menu">Balance</a></td>
                            </tr>
                            <tr>
                                <td>
                                    <a href="${pageContext.request.requestURL}?display=reports?report=refil-commodities" class="menu">Refill commodities</a>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div> 
            </c:when> 
            <c:when test="${balance != null and not fn:endsWith(pageContext.request.requestURI, '/admin/reports/balance')}">
                <div class="midheading">
                  <h2>Balance report</h2>
                </div>
                <div id="purposenav" style="color:white">
                    The balance is: ${balance}
                </div>                           
            </c:when>
            <c:when test="${strongCustomers != null and not fn:endsWith(pageContext.request.requestURI, '/strong-customers')}">
                <div class="midheading">
                  <h2>Restaurant strongest customers</h2>
                </div>
                <div id="purposenav" style="color:white">
                    <table class="CSSTableGenerator">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Gender</th>
                                <th>City</th>
                                <th>Phone</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${strongCustomers}" var="strongCustomers">
                                <tr>
                                    <td>${strongCustomers.userID}</td>
                                    <td>${strongCustomers.firstName} ${strongCustomers.lastName}</td>
                                    <td>${strongCustomers.userGender}</td>
                                    <td>${strongCustomers.userCity}</td>
                                    <td>${strongCustomers.userPhone}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
                  
        </c:choose>    
        
      </div>
  </div>
</div>
          <c:choose>
            <c:when test="${weakestCustomers != null and not fn:endsWith(pageContext.request.requestURI, '/weakest-customers')}">
                <div class="midheading">
                  <h2>Restaurant weakest customers</h2>
                </div>
                <div id="purposenav" style="color:white">
                    <table class="CSSTableGenerator">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Gender</th>
                                <th>City</th>
                                <th>Phone</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${weakestCustomers}" var="weakestCustomers">
                                <tr>
                                    <td>${weakestCustomers.userID}</td>
                                    <td>${weakestCustomers.firstName} ${weakestCustomers.lastName}</td>
                                    <td>${weakestCustomers.userGender}</td>
                                    <td>${weakestCustomers.userCity}</td>
                                    <td>${weakestCustomers.userPhone}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
                  
        </c:choose>    
        
      </div>
  </div>
</div>

        
<div id="footerbg">
  <div id="footerblank">
    <div id="footer">
        <div id="footerbox">
            <div class="footerheading"><h4>Most popular courses</h4></div>
            <div class="footertxt">
                <br/>
            </div>
            <div class="footerbutton"><a href="<%=request.getContextPath()%>/admin/reports/popular-courses" class="button">Click here</a></div>
        </div>
      <div id="footermid"><div class="footerheading"><h4>Strongest customers</h4></div>
      <div class="footertxt"><br/></div>
      <div class="footerbutton"><a href="<%=request.getContextPath()%>/admin/reports/strong-customers" class="button">Click here</a></div>
      </div>
      <div id="footerlast">
        <div class="footerheading">
          <h4>Weakest<br/> customers</h4>
        </div>
          <div class="footertxt"><br/></div>
        <div class="footerbutton"><a href="<%=request.getContextPath()%>/admin/reports/weakest-customers" class="button">Click here</a></div>
      </div>
      <div id="footerlinks"><a href="#" class="footerlinks">Home</a> | <a href="#" class="footerlinks">About Us</a> | <a href="#" class="footerlinks">Support</a> | <a href="#" class="footerlinks">Forum</a> | <a href="#" class="footerlinks">Development</a> | <a href="#" class="footerlinks">Conact Us</a></div>
      <div id="copyrights">© Sameat 2012-2015</div>
    </div>
  </div>
</div>

</body>
</html>