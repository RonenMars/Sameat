<%-- 
    Document   : thanks
    Created on : Apr 18, 2015, 8:32:20 PM
    Author     : plotk_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank You!</title>
    </head>
    <body>
        <h1>Thanks for joining to our site!</h1>
        <p>This is the information you entered:</p>
        <label>ID:</label>${user.userID}<br><br>
        <label>First Name:</label>${user.firstName}<br><br>
        <label>Last Name:</label>${user.lastName}<br><br>
        <label>Gender:</label>${user.userGender}<br><br>
        <label>Birthday:</label>${user.userBDay}<br><br>
        <label>Address:</label>${user.userAddress}<br><br>
        <label>City:</label>${user.userCity}<br><br>
        <label>Phone:</label>${user.userPhone}<br><br>
        <label>Email:</label>${user.userEmail}<br><br>
        <label>UserName:</label>${user.userName}<br><br>
        
    </body>
</html>
