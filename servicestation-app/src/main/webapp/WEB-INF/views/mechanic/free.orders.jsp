<!-- Free orders on station -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



	<div class="table-responsive col-sm-offset-2 col-sm-8">
		<table class="table table-striped table-hover table-bordered">
    		<tr>
		    	<th width="15%">ID</th>
	    		<th>Problem</th>
	    		<th width="20%">Status</th>
		    	<th width="20%">Date</th>
		    	<th>Pick Up</th>
    		</tr>
    		<c:forEach var="order" items="${orders}" >
	    		<form:form action="../mechanic/freeorders" method='POST'>
	    		    <tr class="warning">
		    	    	<td>${order.key.orderId}</td>
				        <td>${order.key.problemDescription}</td>
		    		    <td>${order.key.status}</td>
		    	    	<td>${order.value}</td>
		    	    	<input name="orderId" value="${order.key.orderId }" hidden="true">
			        	<td><button type="submit" class="btn btn-warning btn-sm">Pick Up</button></td>
		        	</tr>
		        </form:form>
    	    </c:forEach>
	    </table>
	</div>
