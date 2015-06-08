<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp"/>
    <body>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Course ID</th>
                    <th>Course Name</th>
                    <th>Course Description</th>
                    <th>Course Price</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${courses}" var="courses">
                <tr>
                    <td>${courses.id}</td>
                    <td>${courses.name}</td>
                    <td>${courses.desc}</td>
                    <td>${courses.price}</td>
                    <td><form action="<%=request.getContextPath()%>/cart/add" method="POST">
                            <input type="hidden" name="courseid" value="${courses.id}">
                            <input type="text" name="quant" value="1" />
                            <input type="submit" class="btn btn-success"  value="Add to Cart" />
                        </form></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
