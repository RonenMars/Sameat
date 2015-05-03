<%-- 
    Document   : login
    Created on : Apr 24, 2015, 12:41:16 AM
    Author     : plotk_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to the System</title>
        <style type="text/css">
            body {
                text-align: center;
            }
           form {
               
                margin-left: auto;
                margin-right: auto;
                text-align: left;
                width:250px;
            }
            p.error {
                color:red;
            }
        </style>
    </head>
    <body>
        <p class="error"><b>${Message}</b></p>
        <form action="Login" method="POST">
            <label>User Name: </label><input type="text" name="username" value="" /><br><br>
            <label>ID: </label><input type="text" name="id" value="" /><br><br>
            <label>Password: </label><input type="password" name="password" value="" /><br><br>
             <input type="hidden" name="appType" value="1" />
            <input type="submit" value="Login" name="log" />
        </form>
    </body>
</html>
