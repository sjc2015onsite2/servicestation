<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="col-sm-4">
	<ol>
		<c:forEach var="partoforder" items="${partsoforder }">
	  		<li>${partoforder.key.name } (x)${partoforder.value }</li>
	  	</c:forEach>
	</ol>
</div>
<div class="col-sm-8">
	<button data-toggle ="modal" data-target="#addpart-modal" type="button" class="btn btn-warning btn-sm">Add part</button>
</div>


<div class="modal fade" id="addpart-modal">
	<div class="modal-dialog modal-sm">
    	<div class="modal-content col-sm-offset-1 col-sm-10">
        	<div class="modal-header">
        		<button class="close" type="button" data-dismiss="modal">&times;</button>
		        <h4 class="modal-title">Change station</h4>
		    </div>

      		<div class="modal-body">
        		<form class="form-horizontal" action="../../mechanic/partorder" method='POST' role="form">
        			<div class="col-sm-2">
          				<label class="text-left" >Select stationé:</label>
          			</div>
              		<div class="col-sm-10">
                		<select name="partId" multiple class="form-control" >
                  			<c:forEach var="part" items="${parts}">
                  				<option value="${part.key.partId }">${part.key.name}</option>
                  			</c:forEach>
                		</select>
		                <input name="quantity" class="form-control input-sm" type="text" >
		            </div>
		          	<div>
          				<br />
          				<input name="partOrderId" value="${partorder.partOrderId }" hidden="true">
              			<button type="submit" class="btn btn-warning btn-sm" >Add</button>
          			</div>
        		</form>
      		</div>

      		<div class="modal-footer">
        		<button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
      		</div>
    	</div>
  	</div>
</div>
