<!-- Log of notifications -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="table-responsive col-sm-offset-2 col-sm-8">
    <table class="table table-striped table-hover table-bordered">
        <tr>
	        <th width="20%">Order ID</th>
	        <th width="30%">Mechanic</th>
	        <th>Notification</th>
        </tr>
        <c:forEach var="notification" items="${notificationsDto}">
		    <tr class="warning">
			    <td>Order ${notification.orderId}</td>
			    <td>${notification.mechanicName}</td>
			    <td>${notification.message}</td>
		    </tr>
        </c:forEach>
    </table>
</div>