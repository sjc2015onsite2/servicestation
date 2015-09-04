<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-offset-5">
	<h3>Partsorder ${partorder.partOrderId}</h3>
</div>
<div>
	<br/>
	<br/>
	<div class="col-sm-offset-4 col-sm-4">
		<ol>
			<c:forEach var="partoforder" items="${partsoforder}">
		  		<li>${partoforder.key.name} (x)${partoforder.value}</li>
		  	</c:forEach>
		</ol>
	</div>
	<div class="col-sm-4">
		<button data-toggle ="modal" data-target="#addpart-modal" type="button" class="btn btn-warning btn-sm">Add part</button>
	</div>
	<div class="col-sm-offset-3 col-sm-3">
		<div class="col-sm-offset-9 col-sm-1">
			<br />
			<br />
			<a href="<c:url value="/mechanic/partsorders" />" ><button type="submit" class="btn btn-warning btn-sm">Save</button></a>
		</div>
	</div>
</div>


<div class="modal fade" id="addpart-modal">
	<div class="modal-dialog modal-sm">
    	<div class="modal-content col-sm-offset-1 col-sm-10">
        		<form class="form-horizontal" action="../../mechanic/partorder" method='POST' role="form">
        	<div class="modal-header">
        		<button class="close" type="button" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Add parts</h4>
		    </div>

      		<div class="modal-body">
        			<div class="form-group has-feedback">
          				<label class="text-left" >Select part:</label>
                		<select name="partId" multiple class="form-control" >
                  			<c:forEach var="part" items="${parts}">
                  				<option value="${part.key.partId }">${part.key.name}</option>
                  			</c:forEach>
                		</select>
                	</div>
                	<div class="form-group has-feedback">
                		<label class="text-left" >Enter quantity:</label>
                		<input name="partOrderId" value="${partorder.partOrderId}" hidden="true">
		                <input name="quantity" class="form-control input-sm" type="text" placeholder="Enter quantity">
		            </div>
      		</div>

      		<div class="modal-footer">
      			<button type="submit" class="btn btn-warning btn-sm" >Add</button>
        		<button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
      		</div>
        		</form>
    	</div>
  	</div>
</div>

