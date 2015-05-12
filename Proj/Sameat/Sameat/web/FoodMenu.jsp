<%-- 
    Document   : FoodMenu
    Created on : 12/05/2015, 10:14:40
    Author     : userty5
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Food Menu</title>
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
        <!--<p class="error"><b></b></p>-->
        <form action="NewUser" method="POST">
            <input type="hidden" name="action" value="add">
            <br><label>ID: </label><input type="text" name="userID" value="" /><br><br>
            <label>First Name: </label><input type="text" name="fName" value="" /><br><br>
            <label>Last Name: </label><input type="text" name="lName" value="" /><br><br>
            <label>Choose Gender: </label><br>
            <input type="radio" name="gender" value="1" checked="checked" /><label>Female</label><br>
            <input type="radio" name="gender" value="2" /><label>Male</label><br><br>
            <label>Enter your Birthday (in format dd/mm/yyyy):</label><input type="text" name="uBDay" value="" /><br><br>
            <label>Address: </label><input type="text" name="uAddr" value="" /><br><br>
            <label>City: </label><input type="text" name="uCity" value="" /><br><br>
            <label>Phone: </label><input type="text" name="uPhone" value="" /><br><br>
            <label>Email: </label><input type="text" name="uEmail" value="" /><br><br>
            <label>Username: </label> <input type="text" name="userN" value="" /><br><br>
            <label>Password: </label><input type="password" name="password" value="" /><br><br>
            <input type="hidden" name="uType" value="2" />
            <div class='btn'>
            <input type="submit" value="Submit"/><br><br>
            </div>
               
            </form>
    </body>
</html>





