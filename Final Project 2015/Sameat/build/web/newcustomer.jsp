     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <jsp:include page="/includes/header.jsp" /> 
      <body>
          <div class="container">
              <div class="page-header">
                  <h1>${user.userName} Welcome to Sameat Family!</h1>
              </div>
              <strong>First Name: &nbsp;&nbsp; ${user.firstName}</strong><br>
              <strong>Last Name: &nbsp;&nbsp; ${user.lastName}</strong><br>
              <strong>ID: &nbsp;&nbsp; ${user.userID}</strong><br>
              <strong>Gender: &nbsp;&nbsp; ${user.userGender}</strong><br>
              <strong>Birthday: &nbsp;&nbsp; ${user.userBDay}</strong><br>
              <strong>Address: &nbsp;&nbsp; ${user.userAddress}</strong><br>
              <strong>City: &nbsp;&nbsp; ${user.userCity}</strong><br>
              <strong>Phone: &nbsp;&nbsp; ${user.userPhone}</strong><br>
              <strong>Email: &nbsp;&nbsp; ${user.userEmail}</strong><br>
          </div>
          <br><br>
          <form action="main/new" method="POST">
              <input type="hidden" name="uid" value="${user.userID}">
              <input type="hidden" name="uname" value="${user.userName}">
              <button type="submit" class="btn btn-warning center-block">Click here to Main Page</button>
          </form>
      </body>
</html>
