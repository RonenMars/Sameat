<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <jsp:include page="/includes/header.jsp" /> 
      <body>
          <div class="container">
              <div class="page-header">
                  <h1> ...Administration Login...</h1>
              </div>
          </div>
          <form class="form-horizontal" action="j_security_check" method="POST">
          <div class="form-group">
              <label class="control-label col-xs-2" for="UserName"><h5>User Name:</h5></label>
              <div class="col-sm-5">
                  <input type="text" class="form-control" name="j_username" placeholder="Enter User Name">
              </div>
          </div>
          <div class="form-group">
              <label class="control-label col-xs-2" for="Password"><h5>Password:</h5></label>
              <div class="col-sm-5">
                  <input type="password" class="form-control" name="j_password" placeholder="Enter Password">
              </div>
          </div>
          <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                  <input type="submit" class="btn btn-default" value="Login">
              </div>
         </div>
          </form>
      </body>
      </html>