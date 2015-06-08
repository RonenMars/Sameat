<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarA">
    <div class="alet alert-success">
        <h4 class="text-center">Welcome <strong>${user.firstName} ${user.lastName}</strong> to Sameat!</h4>
    </div>
    <form action="user/logout" method="POST">
        <input type="submit" class="btn btn-danger pull-right" value="Logout">
    </form>
</aside>