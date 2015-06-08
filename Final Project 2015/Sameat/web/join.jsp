    <jsp:include page="/includes/header.jsp" />      
      <body>
          <span class="label label-info center-block">${message}</span>
          <span class="label label-danger center-block"><h3><strong>${errm}</strong></h3></span>
        <div class="container">
            <h2>Join to Sameat</h2>
           
            <form name="joinF" class="form-horizontal" role="form" action="user/join" method="post" onsubmit="return ValidateForm();">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label class="control-label col-sm-2" for="FirstName">First Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="FirstName" name="FirstName" placeholder="Enter First Name" value=""/>
                    <div class="alert alert-danger" id="fnerr" hidden="hidden"><strong></strong></div>
                </div>
            </div>
            <div class="form-group">
               <label class="control-label col-sm-2" for="LastName">Last Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="LastName" name="LastName" placeholder="Enter Last Name" />
                    <div class="alert alert-danger" id="lnerr" hidden="hidden"><strong></strong></div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="ID">ID:</label>
                 <div class="col-sm-10">
                     <input type="text" class="form-control" id="ID" name="ID" placeholder="Enter ID" maxlength="9" />
                     <div class="alert alert-danger" id="IDerr" hidden="hidden"><strong></strong></div>
                 </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Gender:</label>
                <div class="radio-inline">
                    <label><input type="radio" name="gender" id="mGender" value="1" checked="checked">Male</label>
                </div>
                <div class="radio-inline">
                     <label><input type="radio" name="gender" id="fGender" value="2">Female</label>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2">Birthday:</label>
               <div class="col-sm-10">
                    <input type="text" class="form-control" id="bday" name="userBDay" placeholder="Click to Choose Birth Date" />
            
               </div>
            </div> 
             <div class="form-group">
                <label class="control-label col-sm-2" for="Address">Address:</label>
                 <div class="col-sm-10">
                    <input type="text" class="form-control" id="Address" name="Address" placeholder="Enter Address" />
                     <div class="alert alert-danger" id="addrerr" hidden="hidden"><strong></strong></div>
                 </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="City">City:</label>
                 <div class="col-sm-10">
                    <input type="text" class="form-control" id="City" name="City" placeholder="Enter City" />
                    <div class="alert alert-danger" id="cityerr" hidden="hidden"><strong></strong></div>
                 </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="Phone">Phone:</label>
                 <div class="col-sm-10">
                     <input type="text" class="form-control" id="Phone" name="Phone" placeholder="Enter Phone" maxlength="10" />
                    <div class="alert alert-danger" id="phonerr" hidden="hidden"><strong></strong></div>
                 </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="Email">Email:</label>
                 <div class="col-sm-10">
                    <input type="text" class="form-control" id="Email" name="Email" placeholder="Enter Email" />
                    <div class="alert alert-danger" id="emailerr" hidden="hidden"><strong></strong></div>
                 </div>
            </div>
            <h3>Enter User Details:</h3>
            <div class="form-group">
                <label class="control-label col-sm-2" for="UserName">User Name:</label>
                 <div class="col-sm-10">
                     <div class="alert alert-info" id="uinf"><strong>The User Name must contain 5-12 letters!</strong></div>
                    <input type="text" class="form-control" id="UserName" name="UserName" placeholder="Enter UserName" />
                    <div class="alert alert-danger" id="usernerr" hidden="hidden"><strong></strong></div>
                 </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="Password">Password:</label>
                 <div class="col-sm-10">
                    <div class="alert alert-info" id="pinf"><strong>The Password must contain: 6-12 characters(at least 1 digit , at least 1 special character , at least 1 upper case letter)! </strong></div>
                    <input type="password" class="form-control" id="Password" name="Password" placeholder="Enter Password" />
                    <div class="alert alert-danger" id="passerr" hidden="hidden"><strong></strong></div> 
                 </div>
            </div>
             <div class="form-group">
                 <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default">Join</button>
                 </div>
            </div>
          </form>
        </div>
    </body>
</html>
