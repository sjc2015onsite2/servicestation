<!-- Page for data about order of customer -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="col-sm-12">
	<div class="col-sm-6">
		<h4 class="text-center">Order ${order.orderId}</h4>
	</div>
	<div>
		<button data-toggle ="modal" data-target="#change-modal" type="button" class="btn btn-warning col-sm-offset-3">Change station</button>
	</div>
</div>
    <div class="col-sm-offset-1 col-sm-10">
    <br /> 
    <br />
    	<div class="col-sm-3">
        	<p class="text-left"><strong>Station: </strong></p>
        </div>
    	<div class="col-sm-9">
    		<p class="text-left"><em>${station.name}</em></p>
    	</div>
	</div>

<div class="col-sm-offset-1 col-sm-10">
	<div class="col-sm-3">
    	<p class="text-left"><strong>Mechanic: </strong></p>
    </div>
	<div class="col-sm-9">
    	<p class="text-left"><em>Mechanic 1</em></p>
    </div>    
</div>


<div class="col-sm-offset-1 col-sm-10">
	<br /> 
	<div class="col-sm-3">
    	<p class="text-left"><strong>Description of the problem: </strong></p>
    </div>
    <div class="col-sm-9">
    	<p class="text-left"><em>${order.problemDescription}</em></p>
    </div>
</div>

<div class="col-sm-offset-1 col-sm-10">
<br /> 
	<div class="col-sm-3">
		<p class="text-left"><strong>Status: </strong></p>
	</div>
    <div class="col-sm-9">
        <p class="text-left"><em>...</em></p>
    </div>
</div>
      
<div class="col-sm-offset-1 col-sm-10">
	<div class="col-sm-3">
		<p class="text-left"><strong>Works list: </strong></p>
	</div>
    <div class="col-sm-9">
        <p class="text-left"><em>...</em></p>
    </div>
</div>

<div class="col-sm-offset-1 col-sm-10">
	<div class="col-sm-3">
		<p class="text-left"><strong>Cost: </strong></p>
	</div>
    <div class="col-sm-9">
        <p class="text-left"><em>...</em> BYR</p>
    </div>
</div>

<div class="col-sm-offset-1 col-sm-10">
	<div class="col-sm-3">
		<p class="text-left"><strong>Date of readiness: </strong></p>
	</div>
    <div class="col-sm-9">
        <p class="text-left"><em>...</em></p>
    </div>
</div>

<div class="col-sm-offset-1 col-sm-10">
<br /> 
<br /> 
	<div class="col-sm-3">
		<p class="text-left"><strong>Notification: </strong></p>
	</div>
    <div class="col-sm-9">
        <p class="text-left"><em>...</em></p>
    </div>
</div>

<div class="modal fade" id="change-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content col-sm-offset-1 col-sm-10">
      <div class="modal-header">
        <button class="close" type="button" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Change station</h4>
      </div>

      <div class="modal-body">
        <form class="form-horizontal" action="../../user/myorders" method='POST' role="form">
        	<div class="col-sm-2">
          		<label class="text-left" >Select stationé:</label>
          	</div>
              <div class="col-sm-10">
                <select name="stationId" multiple class="form-control" >
                  <c:forEach var="station" items="${stations}">
                  	<option value="${station.stationId }">${station.name}</option>
                  </c:forEach>
                </select>
                <input name="orderId" value="${order.orderId }" hidden="true">
              </div>
          <div>
          		<br />
              <button type="submit" class="btn btn-warning btn-sm" >Change</button>
          </div>
        </form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
      </div>
    </div>
  </div>
</div>