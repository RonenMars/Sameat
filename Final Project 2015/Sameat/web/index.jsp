<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${user!=null}">
        <c:set var="path" value="${request.contextPath}/"></c:set>
        <c:redirect url="${path}login/main"></c:redirect>
    </c:when>
<c:otherwise>
  
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
              <jsp:include page="/includes/header.jsp" />
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4"><jsp:include page="/includes/ind_left.jsp" /></div>
            <div class="col-sm-4">
                <!-- The Middle Column -->
                <section>
                    <img class="img-responsive" src="<%=request.getContextPath()%>/images/logo.png" class="img-responsive center-block">
                </section>
                <!-- End of the Middle Column -->
            </div>
            <div class="col-sm-4"><jsp:include page="/includes/ind_right.jsp" /></div>
         </div>
         <div class="row">
             <div class="col-sm-12">
              <jsp:include page="/includes/footer.jsp" />
             </div>
         </div>
    </div>
   
</c:otherwise>
</c:choose>