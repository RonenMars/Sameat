<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp"/>
    <body>
        <span class="label label-info center-block"><h1>Order Finalization</h1></span>
        <span class="label label-primary center-block"><h4>Order Summary</h4></span>
        <table class="table table-bordered">
            <thead>
                <tr class="success">
                    <th class="text text-info"> Course ID</th>
                    <th class="text text-info">Quantity</th>
                    <th class="text text-info">Course Name</th>
                    <th class="text text-info">Course Price</th>
            </thead>
            <tbody>
                <c:set var="totalprice" value="0" scope="page" />
                <c:forEach var="item" items="${cart.items}">
                    <tr class="active">
                        <td><strong>${item.course.id}</strong></td>
                        <td><strong>${item.quantity}</strong></td>
                        <td><strong>${item.course.name}</strong></td>
                        <td><strong>${item.total}</strong></td>
                        <c:set var="totalprice" value="${totalprice + item.total}" scope="page" />
                </c:forEach>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td class="pull-right"><strong>Total Price of the order: ${totalprice}</strong></td>
                    </tr>
            </tbody>
        </table>
                        <p class="text text-danger"><strong>${infoerror}</strong></p>
                    <div class="container center-block">
                        <form class="form-horizontal" role="form" action="<%=request.getContextPath()%>/order/complete" method="POST">
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="ID">Credit Card Holder ID:</label>
                                <div class="col-xs-6">
                                <input type="text" class="form-control" id="holderid" name="holderid" placeholder="Enter ID:">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="creditcardtype">Select Credit Card Type:</label>
                                <div class="col-xs-6">
                                <select class="form-control" id="ctype" name="ctype">
                                    <option value="Visa">Visa</option>
                                    <option value="MasterCard">MasterCard</option>
                                    <option value="IsraCard">IsraCard</option>
                                    <option  value="AmEx">American Express</option>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="creditcardnumber">Credit Card Number:</label>
                                <div class="col-xs-6">
                                <input type="text" class="form-control" id="cnumber" name="cnumber" placeholder="Enter Credit Card Number:">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-xs-2" for="creditcardexp">Credit Card Expiration date (mm/yyyy)</label>
                                <div class="col-xs-6">
                                <select class="form-control" id="cexpm" name="cexpm">
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
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                                </div>
                                <div class="col-xs-6">
                                <select class="form-control" id="cexpy" name="cexpy">
                                    <c:forEach var="year" items="${creditCardYears}">
                                        <option value="${year}">${year}</option>
                                    </c:forEach>
                                </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-danger btn pull-right">Make Order</button> 
                            </div>
                        </form>  
                    </div>
    </body>
</html>
