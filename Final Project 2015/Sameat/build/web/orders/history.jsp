<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp"/>
    <body>
        <span class="label label-info center-block"><h1>Orders History</h1></span>
        <c:choose>
            <c:when test="${orders==null}">
                 <span class="label label-warning center-block"><h4>You don't have orders yet!</h4></span>
            </c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Order Date</th>
                            <th>Order Price</th>
                            <th>Courses</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.orderDate}</td>
                            <td>${order.price}</td>
                            <td><table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th>Course Amount</th>
                                            <th>Course ID</th>
                                            <th>Course Name </th>
                                            <th>Course Price</th>
                                            <th>Rate Course</th>
                                        </tr> 
                                    </thead>
                                    <c:forEach var="item" items="${order.items}">
                                    <tbody>
                                        <tr>
                                            <td>${item.quantity}</td>
                                            <td>${item.course.id}</td>
                                            <td>${item.course.name}</td>
                                            <td>${item.course.price}</td>
                                            <td>
                                                <c:choose>
                                                <c:when test="${item.course.rating==-1}">
                                                <form action="<%=request.getContextPath()%>/order/rate" method="POST">
                                                    <input type="hidden" name="ordid" value="${order.id}">
                                                    <input type="hidden" name="courseid" value="${item.course.id}">
                                                    <select class="form-control" id="rating" name="rating">
                                                    <option value="01">01</option>
                                                    <option value="02">02</option>
                                                    <option value="03">03</option>
                                                    <option value="04">04</option>
                                                    <option value="05">05</option>
                                                    <option value="06">06</option>
                                                    <option value="07">07</option>
                                                    <option value="08">08</option>
                                                    <option value="09">09</option>
                                                    <option value="10">10</option>
                                                 </select>
                                                <input type="submit"  class="btn btn-info center-block"  value="Rate Order" />
                                                </form>
                                             </c:when>
                                                    <c:otherwise>
                                                        Course Rating: ${item.course.rating}
                                                    </c:otherwise>
                                                </c:choose>  
                                              </td>
                                        </tr>
                                    </tbody>
                                    </c:forEach>
                                </table></td>
                            <td></td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
   </body>
</html>  