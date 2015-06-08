
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sameat - Online Restaurant!</title>
        <link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css'/> ">
        <script type='text/javascript' src='//code.jquery.com/jquery-1.9.1.js'></script>
        <script type='text/javascript' src="js/bootstrap.min.js"></script>
        
        <%-- Date Picker Adds--%>
        
        <script type='text/javascript' src="js/moment.min.js"></script>
        <script type='text/javascript' src="js/daterangepicker.js"></script>
        <link rel="stylesheet" type='text/css' href="css/daterangepicker-bs3.css">
          
        <script type='text/javascript' src='js/Joinvalidation.js'></script>
        <script type='text/javascript'>
            $(function(){
                $('input[name="userBDay"]').daterangepicker({
                    singleDatePicker: true,
                    showDropdowns:true
                });
            });
        </script>
    </head>
    <body>
        <ul class="nav nav-tabs ">
            <c:choose>
                <c:when test="${user.userID != null}">
                     <li class="active"><a href="<%=request.getContextPath()%>/welcome/main.jsp"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                </c:when>
                <c:otherwise>
                    <li class="active"><a href="<c:url value='/' />"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                </c:otherwise>
            </c:choose>
            <li><a href="<%=request.getContextPath()%>/menu/getmenu"><span class="glyphicon glyphicon-cutlery"></span> Food Menu</a></li>
            <li><a href="<%=request.getContextPath()%>/cart/getcart"><span class="glyphicon glyphicon-shopping-cart"></span> Shopping cart </a></li>
            <li><a href="<%=request.getContextPath()%>/customer/history"><span class="glyphicon glyphicon-list-alt"></span> Orders History</a></li>
            <li><a href="<%=request.getContextPath()%>/customer/profile"><span class="glyphicon glyphicon-user"></span> Profile</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-info-sign"></span> About Us</a></li>
            <li><a href="<%=request.getContextPath()%>/contactus.jsp"><span class="glyphicon glyphicon-inbox"></span> Contact Us</a></li>
        </ul>
        <br>
