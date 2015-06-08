<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp"/>
<body>
    <div class="container">
              <div class="page-header">
                  <h1> ...Contact Us...</h1>
              </div>
    </div>
    <p class="text text-danger"><strong>${msg}</strong></p>
    <form class="form-horizontal" action="user/contact" method="POST">
        <div class="form-group">
            <label class="control-label col-xs-2">Full Name:</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="fullname">
            </div>
        </div>
        <div class="form-group">
           <label class="control-label col-xs-2">Email:</label>
            <div class="col-sm-5">
               <input type="text" class="form-control" name="email">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-xs-2">Your Message:</label>
            <div class="col-sm-5">
                <textarea class="form-control" rows="10" name="mtext"></textarea>
            </div>
        </div>
        <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                 <input type="submit" class="btn btn-success" value="Send">
              </div>
        </div>
    </form>
</body>
</html>