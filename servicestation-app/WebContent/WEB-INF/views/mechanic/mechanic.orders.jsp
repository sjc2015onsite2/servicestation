<!-- Orders of mechanic -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="table-responsive col-sm-offset-2 col-sm-8">
	<table class="table table-striped table-hover table-bordered">
    	<tr>
    	<th width="15%">ID</th>
    	<th>Problem</th>
    	<th width="20%">Status</th>
    	<th width="20%">Date</th>
    	</tr>
    	<c:forEach var="order" items="${myorders}">
        <tr class="warning">
        <td><a href="<c:url value="/stationId/mechanic/myorders/orderId" />" >Order 3</a></td>
        <td>${order.problemDescription}</td>
        <td>on the go</td>
        <td>07.08.2015</td>
        </tr>
        </c:forEach>
    </table>
</div>