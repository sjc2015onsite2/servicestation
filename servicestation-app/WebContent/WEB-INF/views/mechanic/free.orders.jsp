<!-- Free orders on station -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="table-responsive col-sm-offset-2 col-sm-8">
	<table class="table table-striped table-hover table-bordered">
    	<tr><th width="15%">Number</th><th>Problem</th><th width="20%">Status</th><th width="20%">Date</th></tr>
        <tr class="warning"><td><a href="<c:url value="/stationId/mechanic/myorders/orderId" />" >Order 3</a></td><td>Problem 1</td><td>awaiting</td><td>07.08.2015</td></tr>
    </table>
</div>