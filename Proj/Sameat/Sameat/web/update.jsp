<%-- 
    Document   : update
    Created on : 08/05/2015, 11:39:01
    Author     : userty5
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration To the Site!</title>
        <style type="text/css">
            body {
                text-align: center;
            }
            form {
                border: 2px dashed darkslategray;
                margin-left: auto;
                margin-right: auto;
                text-align: left;
                width:500px;
            }
            form input[type='submit'] {
                display: inline-block;
                width:80px;
            }
            div.btn {
                text-align: center;
            }
            p.error {
                color:red;
            }
        </style>
    </head>
    <body>
        <h1>Registration Form!</h1><br><br>
        <p class="error"><b>${Message}</b></p>
        <form action="NewUser" method="POST">
            <input type="hidden" name="action" value="add">
            <br><label>ID: </label><input type="text" name="userID" value="${user.userID}" /><br><br>
            <label>First Name: </label><input type="text" name="fName" value="${user.firstName}" /><br><br>
            <label>Last Name: </label><input type="text" name="lName" value="${user.lastName}" /><br><br>
            <label>Choose Gender: </label><br>
            <input type="radio" name="gender" value="1" checked="checked" /><label>Female</label><br>
            <input type="radio" name="gender" value="2" /><label>Male</label><br><br>
            <label>Enter your Birthday (in format dd/mm/yyyy):</label><input type="text" name="uBDay" value="${user.userBDay}" /><br><br>
            <label>Address: </label><input type="text" name="uAddr" value="${user.userAddress}" /><br><br>
            <label>City: </label><input type="text" name="uCity" value="${user.userCity}" /><br><br>
            <label>Phone: </label><input type="text" name="uPhone" value="${user.userPhone}" /><br><br>
            <label>Email: </label><input type="text" name="uEmail" value="${user.userEmail}" /><br><br>
            <label>Username: </label> <input type="text" name="userN" value="${user.userName}" /><br><br>
            <label>Password: </label><input type="password" name="password" value="" /><br><br>
            <input type="hidden" name="uType" value="2" />
            <div class='btn'>
            <input type="submit" value="Submit"/><br><br>
            </div>
               
            </form>
    </body>
</html>