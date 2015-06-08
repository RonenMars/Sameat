  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <jsp:include page="/includes/header.jsp" /> 
      <body>
          <div class="container">
              <div class="page-header">
                  <h1 class="text text-muted">${user.userName}'s Profile!</h1>
              </div>
                  <span class="label label-info center-block"><h4>${pmessage}</h4></span><br><br>
              <form class="form-horizontal" action="<%=request.getContextPath()%>/user/update" method="POST">
                  <div class="form-group">
                      <label class="control-label col-sm-2" for="FullName">Full Name:</label>
                      <div class="col-sm-10">
                          <input type="text" class="form-control" id="FullName" name="FullName" value="${user.firstName} ${user.lastName}" readonly>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="control-label col-sm-2" for="ID">ID:</label>
                      <div class="col-sm-10">
                          <input type="text" class="form-control" id="ID" name="ID" value="${user.userID}" readonly>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="control-label col-sm-2" for="Gender">Gender:</label>
                      <div class="col-sm-10">
                          <input type="text" class="form-control" id="Gender" name="Gender" value="${user.userGender}" readonly>
                      </div>
                  </div>
                  <div class="form-group">
                      <label class="control-label col-sm-2" for="BDay">Birthday:</label>
                      <div class="col-sm-10">
                          <input type="text" class="form-control" id="BDay" name="BDay" value="${user.userBDay}" readonly>
                      </div>
                  </div>  
                  <div class="form-group">
                      <label class="control-label col-sm-2" for="Address">Address:</label>
                      <div class="col-sm-10">
                          <input type="text" class="form-control" id="Address" name="Address" value="${user.userAddress}" />
                     </div>
                 </div>
                 <div class="form-group">
                     <label class="control-label col-sm-2" for="City">City:</label>
                     <div class="col-sm-10">
                        <input type="text" class="form-control" id="City" name="City" value="${user.userCity}" />
                     </div>
                 </div>
                 <div class="form-group">
                     <label class="control-label col-sm-2" for="Phone">Phone:</label>
                      <div class="col-sm-10">
                         <input type="text" class="form-control" id="Phone" name="Phone" value="${user.userPhone}" maxlength="10" />
                      </div>
                </div>
                 <div class="form-group">
                     <label class="control-label col-sm-2" for="Email">Email:</label>
                     <div class="col-sm-10">
                        <input type="text" class="form-control" id="Email" name="Email" value="${user.userEmail}" />
                     </div>
                </div>
                <div class="form-group">
                 <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default">Update Profile</button>
                 </div>
                </div> 
        </form>