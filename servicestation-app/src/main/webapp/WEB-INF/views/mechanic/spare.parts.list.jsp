<!-- List of spare parts -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<div class="table-responsive col-sm-offset-2 col-sm-6">
	    <table class="table table-striped table-hover table-bordered">
	        <tr>
		        <th width="20%">Part ID</th>
		        <th>Name of spare part</th>
		        <th width="20%">Quantity on stock</th>
	        </tr>
	        <c:forEach var="part" items="${parts}" >
		        <tr class="warning">
			        <td>Part ${part.key.partId}</td>
			        <td>${part.key.name}</td>
			        <td>${part.value}</td>
		        </tr>
	        </c:forEach>
	    </table>
	</div>
	<div class="col-sm-2">
		<form action="../mechanic/newpartorder" method='POST' class="navbar-form navbar-right">
			<button type="submit" class="btn btn-warning">Create partorder</button>
		</form>
	</div>
</div>

