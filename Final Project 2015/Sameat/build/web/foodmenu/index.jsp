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
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${courses}" var="courses">
                <tr>
                    <td>${courses.id}</td>
                    <td>${courses.name}</td>
                    <td>${courses.desc}</td>
                    <td>${courses.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
