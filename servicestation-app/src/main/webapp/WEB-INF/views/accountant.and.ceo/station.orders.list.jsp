<!-- Free orders on station -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form action="orders" method="POST">
	<div class="col-sm-offset-2 col-sm-8">
		<div class="col-sm-2">
			<strong class="text-right">Enter startDate: </strong>
		</div>
		<div class="col-sm-3">
			<input name="startdate" type="text" class="form-control input-sm" placeholder="dd.MM.yyyy">
		</div>
		<div class="col-sm-2">
		</div>
		<div class="col-sm-2">
			<strong class="text-right">Enter finishDate: </strong>
		</div>
		<div class="col-sm-3">
			<input name="finishdate" type="text" class="form-control input-sm" placeholder="dd.MM.yyyy">
		</div>
	</div>
	<div class="col-sm-offset-3 col-sm-6">
		<div class="col-sm-offset-5 col-sm-2">
			<br />
			<br />
			<button type="submit" class="btn btn-warning btn-sm">Show</button>
		</div>
		<div class="col-sm-4"></div>
	</div>
</form>

	<div class="table-responsive col-sm-offset-2 col-sm-8">
		<br />
		<br />
		<table class="table table-striped table-hover table-bordered">
    		<tr>
		    	<th width="10%">ID</th>
	    		<th>Problem</th>
	    		<th width="15%">Status</th>
	    		<th width="15%">Cost (BYR)</th>
		    	<th width="20%">createdDate</th>
    		</tr>
    		<c:forEach var="order" items="${ordersData}">
		    	<tr class="warning">
			    	<td>${order[0]}</td>
			        <td>${order[1]}</td>
	    		    <td>${order[2]}</td>
			       	<td>${order[3]}</td>
		        	<td>${order[4]}</td>
	        	</tr>
        	</c:forEach>
	    </table>
	    <br />
	    <br />
	    <br />
	    <br />
	    <br />
	    <br />
	    <br />
	    <br />
	</div>
