<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp"/>
    <body>
        <span class="label label-info center-block"><h1>Order Invoice</h1></span>
        <span class="label label-primary center-block"><h4>Order Number: ${ordid}</h4></span>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name></th>
                    <th>Course Price</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${courses}">
                    <tr>
                        <td>${item.course.id}</td>
                        <td>${item.course.name}</td>
                        <td>${item.course.price}</td>
                    </tr>
                </c:forEach>
                   <tr>
                    <td></td>
                    <td></td>
                    <td><strong class="text text-danger">Total Price: ${tprice}</strong></td>
                 </tr>
            </tbody>
        </table>
    </body>
</html>