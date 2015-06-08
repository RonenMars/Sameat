<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<aside id="sidebarB">
    <c:import url="/menu/">
        <c:param name="req" value="chef"></c:param>
    </c:import>
    <c:set var="chefcourse" value="${requestScope.ccourse}"></c:set>
   <div class="row">
    <div class="col-md-4">
        <h1 class="text text-primary">Chef Course</h1>
    </div>
    <div class="col-md-6">
             <img class="img-responsive" src="<%=request.getContextPath()%>/images/chef.jpg">
    </div>
   </div>
    <div class="row">
    <div class="panel panel-info">
        <div class="panel-heading">Today's recommendation</div>
        <div class="panel-body"><strong>Name:</strong> ${chefcourse.name}<br>
            <strong>Description:</strong> ${chefcourse.desc}<br>
            <strong>Price:</strong> ${chefcourse.price} &#8362;</div>
    </div>
    </div>
</aside>
