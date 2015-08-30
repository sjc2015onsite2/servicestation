<!-- Orders of mechanic -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="table-responsive col-sm-offset-2 col-sm-8">
	<table class="table table-striped table-hover table-bordered">
    	<tr>
	    	<th width="15%">Order ID</th>
	    	<th>Problem</th>
	    	<th width="20%">Status</th>
	    	<th width="20%">Date</th>
    	</tr>
    	<c:forEach var="order" items="${ordersanddate}">
	    	<c:url value="/mechanic/myorders/${order.key.orderId}" var="orderUrl" />
	        <tr class="warning">
		        <td><a href="${orderUrl}" >Order ${order.key.orderId}</a></td>
		        <td>${order.key.problemDescription}</td>
		        <td>${order.key.status}</td>
		        <td>${order.value}</td>
	        </tr>
        </c:forEach>
    </table>
</div>