<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <jsp:include page="/includes/header.jsp" /> 
      <body>
          <div class="container">
              <div class="page-header">
                  <h1 class="text text-danger"> ...Login or Join to Sameat...</h1>
              </div>
          </div>
          <div class="container">
              <p class="text text-info"><strong>You tried to reach a page that is part of the<br>
                  services that we offering to our customers ,<br>
              so please Login to the system or join to our family of customers!</strong></p>
          </div>
          <div class="container">
              <div class="btn-group">
                  <a href="<%=request.getContextPath()%>" class="btn btn-primary">Login to Sameat</a>
                  <a href="<%=request.getContextPath()%>/join.jsp" class="btn btn-primary">Join to Sameat</a>
              </div>
          </div>
      </body>
      </html>