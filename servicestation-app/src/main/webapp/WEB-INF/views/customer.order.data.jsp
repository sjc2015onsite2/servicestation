<!-- Page for data about order of customer -->


<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="mechanic/myorders" method='POST'>
<div class="col-sm-12">
	<div class="col-sm-6">
		<h4 class="text-center">Order ${order.orderId}</h4>
	</div>
	<security:authorize access="hasRole('ROLE_USER')">
		<div>
			<button data-toggle ="modal" data-target="#change-modal" type="button" class="btn btn-warning col-sm-offset-3">Change station</button>
		</div>
	</security:authorize>
</div>

<security:authorize access="hasRole('ROLE_USER')">
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
    		<p class="text-left"><em>${mechanic.name }</em></p>
    	</div>    
	</div>
</security:authorize>


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
	<security:authorize access="hasRole('ROLE_USER')">
    <div class="col-sm-9">
        <p class="text-left"><em>${order.status }</em></p>
    </div>
    </security:authorize>
    
	<security:authorize access="hasRole('ROLE_MECHANIC')">
		<div class="col-sm-1">
     	   <p class="text-left"><em>${order.status }</em></p>
   		</div>
   	 	<div class="col-sm-2">
   	 		<button data-toggle ="modal" data-target="#changestatus-modal" type="submit" class="btn btn-warning btn-sm">Change status</button>
    	</div>
    	<div class="col-sm-4">
    	</div>
    </security:authorize>
</div>
      
<div class="col-sm-offset-1 col-sm-10">
<br />
<br />
	<div class="col-sm-3">
		<p class="text-left"><strong>Works: </strong></p>
	</div>
	<div class="col-sm-4">
		<ol>
			<c:forEach var="work" items="${addedworks }">
  				<li>${work.name }</li>
  			</c:forEach>
		</ol>
	</div>
    <div class="col-sm-4">
        <button data-toggle ="modal" data-target="#addwork-modal" type="submit" class="btn btn-warning btn-sm">Add work</button>
    </div>
</div>

<div class="col-sm-offset-1 col-sm-10">
<br />
<br />
	<div class="col-sm-3">
		<p class="text-left"><strong>Parts: </strong></p>
	</div>
	<div class="col-sm-4">
		<ol>
			<c:forEach var="part" items="${partstoorder}">
  				<li>${part.key.name } (x${part.value })</li>
  			</c:forEach>
		</ol>
	</div>
    <div class="col-sm-4">
        <button data-toggle ="modal" data-target="#addpart-modal" type="submit" class="btn btn-warning btn-sm">Add part</button>
    </div>
</div>



<div class="col-sm-offset-1 col-sm-10">
<br />
<br />
	<div class="col-sm-3">
		<p class="text-left"><strong>Cost: </strong></p>
	</div>
	<security:authorize access="hasRole('ROLE_USER')">
    <div class="col-sm-9">
        <p class="text-left"><em>...</em> BYR</p>
    </div>
    </security:authorize>
    <security:authorize access="hasRole('ROLE_MECHANIC')">
    	<div class="col-sm-9">
       		<p class="text-left"><em>...</em> BYR</p>
    	</div>
    </security:authorize>
</div>

<div class="col-sm-offset-1 col-sm-10">
<br />
	<div class="col-sm-3">
		<p class="text-left"><strong>CompleteDate: </strong></p>
	</div>
	
    <security:authorize access="hasRole('ROLE_MECHANIC')">
    
    	<c:if test="${completedate != null }">
    		<div class="col-sm-1">
        		<p class="text-left"><em>${completedate }</em></p>
    		</div>
    	</c:if>
    	<c:if test="${completedate == null }">
    		<form action="../myorders/completedate" method='POST'>
    			<div class="col-sm-2">
    	   		 	<input name="completedate" type="text" class="form-control input-sm" placeholder="Enter date"> 
   				</div>
    			<div class="col-sm-4">    	
    				<input name="orderId" value="${order.orderId }" hidden="true" placeholder="mm.dd.yyyy">
    				<button type="submit" class="btn btn-warning btn-sm">Save</button>
    			</div>
    		</form>
    	</c:if>
    	
    </security:authorize>
    
    <security:authorize access="hasRole('ROLE_USER')">
    	<div class="col-sm-9">
        	<p class="text-left"><em>...</em></p>
    	</div>
    </security:authorize>
</div>


<div class="col-sm-offset-1 col-sm-10">
<br />
	<div class="col-sm-3">
		<p class="text-left"><strong>CreateDate: </strong></p>
	</div>
	<div class="col-sm-9">
        	<p class="text-left"><em>${createdate}</em></p>
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
</form:form>


<div class="modal fade" id="addpart-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content col-sm-offset-1 col-sm-10">
      <div class="modal-header">
        <button class="close" type="button" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add part</h4>
      </div>

      <div class="modal-body">
        <form class="form-horizontal" action="../myorders/addparts" method='POST' role="form">
        	<div class="col-sm-2">
          		<label class="text-left" >Select work:</label>
          	</div>
              <div class="col-sm-10">
                <select name="partId" multiple class="form-control" >
        		<c:forEach var="part" items="${parts}" >
        			<option value="${part.key.partId }">${part.key.name }</option>
  	    	  	</c:forEach>
    	   		 </select>
                <input name="orderId" value="${order.orderId }" hidden="true">
                <input name="quantity" type="text" class="form-control" placeholder="Enter quantity">
              </div>
          <div>
          		<br />
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



<div class="modal fade" id="addwork-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content col-sm-offset-1 col-sm-10">
      <div class="modal-header">
        <button class="close" type="button" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add work</h4>
      </div>

      <div class="modal-body">
        <form class="form-horizontal" action="../myorders/addworks" method='POST' role="form">
        	<div class="col-sm-2">
          		<label class="text-left" >Select work:</label>
          	</div>
              <div class="col-sm-10">
                <select name="workId" multiple class="form-control" >
        		<c:forEach var="work" items="${works}" >
        			<option value="${work.key.serviceId }">${work.key.name }</option>
  	    	  	</c:forEach>
    	   		 </select>
                <input name="orderId" value="${order.orderId }" hidden="true">
              </div>
          <div>
          		<br />
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




<div class="modal fade" id="changestatus-modal">
  <div class="modal-dialog modal-sm">
    <div class="modal-content col-sm-offset-3 col-sm-6">
      <div class="modal-header">
        <button class="close" type="button" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Change status</h4>
      </div>

      <div class="modal-body">
        <form class="form-horizontal" action="../myorders/changestatus" method='POST' role="form">
        	<div class="col-sm-2">
          		<label class="text-left" >Select statusé:</label>
          	</div>
              <div class="col-sm-10">
                <select name="newstatus" class="form-control" >
        		<c:forEach var="status" items="${statuses}" >
        			<option>${status }</option>
  	    	  	</c:forEach>
    	   		 </select>
                <input name="orderId" value="${order.orderId }" hidden="true">
              </div>
          <div>
          		<br />
              <button type="submit" class="btn btn-warning btn-sm" >Change</button>
          </div>
        </form >
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
      </div>
    </div>
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