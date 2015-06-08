<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
 
  <p class="text text-danger"><strong>${errlogin}</strong></p>
    <form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/user/login" method="POST">
    <div class="row">
        <div class="form-group col-lg-7">
          <label class="control-label" for="UserName"><h5 class="text text-danger"><strong>User Name:</strong></h5></label>
          <div class="input-group">
              <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
            <input type="text" class="form-control" id="UserName" name="UserName" placeholder="Enter User Name">
          </div>
        </div>
    </div>
    <div class="row">
      <div class="form-group col-lg-7">
          <label class="control-label" for="ID"><h5 class="text text-danger"><strong>ID:</strong></h5></label>
         <div class="input-group">
            <span class="input-group-addon"><span class="glyphicon glyphicon-book"></span></span>
            <input type="text" class="form-control" id="ID" name="ID" placeholder="Enter ID" maxlength="9">
         </div>
      </div>
    </div>
    <div class="row">
         <div class="form-group col-lg-7">
             <label class="control-label" for="Password"><h5 class="text text-danger"><strong>Password:</strong></h5></label>
             <div class="input-group">
                 <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                 <input type="password" class="form-control" id="Password" name="Password" placeholder="Enter Password">
             </div>
         </div>
      </div>
  <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-danger">Login</button>
            <a href="<c:url value='join.jsp'/>" type="button" class="btn btn-success" >Join</a>
        </div>
   </div>
  </form>
</aside>