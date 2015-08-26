<!-- List of spare parts -->


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-10">
<div class="table-responsive col-sm-offset-1 col-sm-10">
    <table class="table table-striped table-hover table-bordered">
        <tr>
	        <th width="5%">ID</th>
	        <th width="50%">Order</th>
	        <th width="23%">Status</th>
	        <th width="22%">Created date</th>
        </tr>
        <c:forEach var="order" items="${partOrdersDto}">
	        <tr class="warning">				
		        <td>${order.id }</td>
		        <td> 
		        	<ol>
		        		<c:forEach var="part" items="${order.parts }">
				    		<li>${part.key } (x)${part.value}</li>
				    	</c:forEach>
					</ol>
		        </td>
		        <td>${order.status }</td>
		        <td>${order.date }</td>
	        </tr>
        </c:forEach>
    </table>
</div>
</div>
