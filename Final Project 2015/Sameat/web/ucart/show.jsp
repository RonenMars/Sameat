<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp"/>
    <body>
        <span class="label label-info center-block"><h1>Orders Cart</h1></span>
        <p class="text text-danger"><strong>${ordmsg}</strong></p>
        <c:choose>
            <c:when test="${emptyCart!=null}">
                  <span class="label label-warning center-block"><h4>Your Cart is Empty!</h4></span>
            </c:when>
            <c:otherwise>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Quantity</th>
                            <th>Course ID</th>
                            <th>Course Name</th>
                            <th>Course Description</th>
                            <th>Course Price</th>
                            <th>Total Price</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="item" items="${cart.items}">
                        <tr>
                            <td><form action="<%=request.getContextPath()%>/cart/update" method="POST">
                                    <input type="hidden" name="courseid" value="${item.course.id}">
                                    <input type="text" name="quant" value="${item.quantity}"/>
                                    <input type="submit" class="btn btn-success" value="Update" />
                                </form></td>
                            <td>${item.course.id}</td>
                            <td>${item.course.name}</td>
                            <td>${item.course.desc}</td>
                            <td>${item.course.price}</td>
                            <td>${item.total}</td>
                            <td><form action="<%=request.getContextPath()%>/cart/remove" method="POST">
                                    <input type="hidden" name="courseid" value="${item.course.id}">
                                    <input type="submit" class="btn btn-success"  value="Remove Item" />
                                </form></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:otherwise>
        </c:choose>
            <c:if test="${emptyCart==null}">
                <form action="<%=request.getContextPath()%>/cart/order" method="POST">
                    <input type="submit"  class="btn btn-info center-block"  value="Process Order" />
                </form>
            </c:if>
    </body>
</html>