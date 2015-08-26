<!-- List of spare parts -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-12">
	<div class="table-responsive col-sm-offset-1 col-sm-10">
	    <table class="table table-striped table-hover table-bordered">
	        <tr>
		        <th width="10%">ID</th>
		        <th width="50%">Order</th>
		        <th width="12%">Status</th>
		        <th width="11%">Ready</th>
		        <th width="22%">Created date</th>
	        </tr>
	        <c:forEach var="order" items="${partOrdersDto}">
		        <tr class="warning">				
			        <td>Order ${order.id }</td>
			        <td>
			        	<ol>
			        		<c:forEach var="part" items="${order.parts }">
					    		<li>${part.key } (x)${part.value}</li>
					    	</c:forEach>
						</ol>
			        </td>
			        <td>${order.status }</td>
			        <td>
			        	<c:if test="${order.changeStatus eq true }">
			        		<form action="../mechanic/partsorders" method='POST' class="form-horizontal" role="form">
			        			<button type="submit" class="btn btn-warning btn-sm">READY</button>
			        			<input name="orderId" value="${order.id}" hidden="true">
			        		</form>
			        	</c:if>
			        </td>
			        <td>${order.date }</td>
		        </tr>
	        </c:forEach>
	    </table>
	</div>
</div>
